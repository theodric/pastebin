#!/bin/bash
## Adafruit Raspberry Pi 3.5" LCD backlight control script
## This script is derived from the docs at https://learn.adafruit.com/adafruit-pitft-3-dot-5-touch-screen-for-raspberry-pi/backlight
## controls Adafruit PiTFT 3.5" 480x320 resistive touchscreen LCD backlight (and compatibles) using PWM
## (the varying pwmc values are to avoid an annoying whine on the dim setting)
## theodric 20180412

[[ $@ ]] || { printf "\nPlease specify one of these arguments: on, off\n\n" ; exit 1; }

ARG=${1}

case "$ARG" in
   "on") sudo sh -c 'echo "1" > /sys/class/backlight/soc\:backlight/brightness'
;;
  "off") sudo sh -c 'echo "0" > /sys/class/backlight/soc\:backlight/brightness'
;;
esac
