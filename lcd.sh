#!/bin/bash
## Adafruit Raspberry Pi 3.5" LCD backlight control script
## This script is derived from the docs at https://learn.adafruit.com/adafruit-pitft-3-dot-5-touch-screen-for-raspberry-pi/backlight
## controls Adafruit PiTFT 3.5" 480x320 resistive touchscreen LCD backlight (and compatibles) using PWM
## (the varying pwmc values are to avoid an annoying whine on the dim setting)
## theodric 20160608

[[ $@ ]] || { printf "\nPlease specify one of these arguments: on/bright, dim, off\n\n" ; exit 1; }

ARG=${1}

sudo sh -c "echo 'in' > /sys/class/gpio/gpio508/direction" 2> /dev/null;
gpio -g mode 18 pwm;
gpio pwmc 100

case "$ARG" in
   "on") gpio pwmc 1000;gpio -g pwm 18 1023
;;
   "bright") gpio pwmc 1000;gpio -g pwm 18 1023
;;
   "dim") gpio -g pwm 18 650
;; 
  "off") gpio -g pwm 18 0
;;
esac
