#!/bin/sh
xev | sed -n 's/^.*keycode *\([0-9]\+\).* * \([a-z,A-Z,0-9,_-]\+\)).*$/keycode \1 = \2 /p'

