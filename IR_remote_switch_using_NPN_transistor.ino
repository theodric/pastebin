/*
Description:
	-Arduino sketch to watch for a specific remote scancode and switch a transistor if it's received. I use it to turn on my OpenELEC media center PC without getting up from the couch, but the transistor can switch whatever you like, I suppose.

Image:
	-I mounted mine on a little perfboard. Cute, eh? https://i.imgur.com/MtKy7cg.jpg

BOM:
	-5v-tolerant Arduino-compatible clone with an ATmega168P (or whatever-- but it doesn't need much)
	-TSOP1736 IR receiver
	-C547B NPN transistor
	-4.7k resistor
	-serial connection (for programming and debug)
	-(optional) some perfboard
	-(optional) some headers
	-This Arduino library: https://z3t0.github.io/Arduino-IRremote/

Wiring:
	-IR receiver OUT to pin 4
	-transistor base to pin 6
	-transistor emitter and collector to the device's momentary switch used for power control, a.k.a. the power button
	-Arduino VCC and GND to internal motherboard USB header (assumes your board keeps USB ports live when powered off-- most do.)
	-4.7k resistor between transistor base and pin 6 because it just felt right

Setup:
	-Upload code to the Arduino
	-Connect all the poop up
	-Plug your TTL serial cable into the Arduino, and open the IDE's serial console
	-Poke the button on your remote that you want to use as a power-on switch
	-Replace 11B26D9 in the sketch below with whatever code was printed in the console, being certain to leave the 0x prefix intact.
	-Reupload modified code to Arduino and test

Assumptions if using on a computer:
	-You've enabled the standard ATX 4-second hold-to-poweroff feature in your BIOS to prevent spurious IR activity dropping your device on its head
	-You have a separate IR receiver for the remote to talk to the software, and you've mapped a software trigger to the same remote button, so that your software is able to gently turn the system off. Because this sketch doesn't do that. This is on-only.

Thanks:
	-Code stolen from http://arduino-info.wikispaces.com/IR-RemoteControl and barely modified.

*/

#include "IRremote.h"
int receiver = 4

IRrecv irrecv(receiver);
decode_results results;

{
  Serial.begin(9600);
  Serial.println("IR Receiver Raw Data + Button Decode Test");
  irrecv.enableIRIn();
}

void loop()
{
  if (irrecv.decode(&results))

  {
    Serial.println(results.value, HEX);
    translateIR(); 
    irrecv.resume();
  }  
}

void translateIR()
{
  switch(results.value)
  {

  case 0x11B26D9:  
    Serial.println("That's our boy!");
    digitalWrite(6, HIGH);
    delay(500);
    digitalWrite(6, LOW);
            
    break;

  default: 
    Serial.println("nope.");

  }

  delay(500);

}
