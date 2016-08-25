#!/bin/sh
#jsharp 2016-08-25

[[ $@ ]] || { printf "\nUsage: $0 /full/path/to/source/dir /comparison/dir /output/dir\n\n"; exit 1; }

diff $1 $2 | sed 's/Only in //g' | sed 's/: //g' | xargs cp -t $3



