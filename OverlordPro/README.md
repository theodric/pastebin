##WORKING E3D EXTRUSION-JAM WORKAROUND
###Successfully run an E3D V6 hotend in a DreamMaker Overlord Pro with firmware 2.3.5 without the f'in thing jamming constantly

####*a work in progress*

With firmware 2.3.5, and using Cura 15.04.6, I configured my machine profile following the usual settings...except for one thing: I set the "GCode Flavor" to "RepRap (Marlin/Sprinter)" instead of "UltiGCode." Why?

UltiGCode uses the start and end GCodes that are baked into the firmware. Since DreamMaker is so reticent to release code, we cannot fix the...
```
#define END_OF_PRINT_RETRACTION 20   // number of mm to retract when printer goes idle
```

...that causes E3D V6 hotends to make a hard ball of filament that jams the nozzle/heatbreak and requires disassembly and cutting off the ball *before each and every print.* "RepRap (Marlin/Sprinter)" allows us to specify our own start and end GCODE, mitigating this issue. I start by moving the nozzle to the X tower and squirting out some filament, and end by killing the unnecessary retracts.

Here are the blocks I am successfully using with my OLP (original/Kickstarter) 12V heater + E3D V6.

start.gcode
```
;Sliced at: {day} {date} {time}
;Basic settings: Layer height: {layer_height} Walls: {wall_thickness} Fill: {fill_density}
;Print time: {print_time}
;Filament used: {filament_amount}m {filament_weight}g
;Filament cost: {filament_cost}
;M190 S{print_bed_temperature} ;Uncomment to add your own bed temperature line
;M109 S{print_temperature} ;Uncomment to add your own temperature line
G21        ;metric values
G90        ;absolute positioning
M82        ;set extruder to absolute mode
M107       ;start with the fan off
G28          ;home head
;G28 Z0     ;move Z to min endstops
G1 X-55 Y-64.81 Z2 F12000 ;move the platform to the X tower a 2mm
G92 E0                  ;zero the extruded length
G1 F200 E10              ;extrude 10mm of feed stock
G1 Z15 F12000 E15      ;extrude another 10mm while lifting fast
G92 E0                  ;zero the extruded length again
G1 F{travel_speed}
;Put printing message on LCD screen
M117 Printing...
```


end.gcode
```
;End GCode
M104 S0                     ;extruder heater off
M140 S0                     ;heated bed heater off (if you have it)
G91                                    ;relative positioning
G1 E-1 F300                            ;retract the filament a bit before lifting the nozzle, to release some of the pressure
G1 Z+0.5 X-20 Y-20 F{travel_speed} ;move Z up a bit and retract filament even more
G28 X0 Y0                              ;move X/Y to min endstops, so the head is out of the way
M84                         ;steppers off
G90                         ;absolute positioning
;{profile_string}
```


You can either edit these into your current_profile.ini or paste them into the appropriate start/end tab that appears once you switch your flavor to Marlin. Old GCODE files you have produced will not have these modifications in them-- you have to re-slice your old models if you want to benefit from my start/end blocks.

Caveat: you print flow will look a little different with Marlin GCODE. You'll have a progress readout in degrees Celsius, first for bed heating and then for nozzle heating. You'll also lose the indication of how much longer the print will run for. I can deal with this, personally.

I've run several prints in a row now without issue, but I make no guarantees about performance. I tried this on a whim and was pleasantly surprised when it didn't catch on fire.

My current_profile.ini is available in this repo, if you trust me with your printer.
