#!/bin/sh
#jsharp 2016-08-25

[[ $@ ]] || { printf "\nCopies filenames not found in a second directory, compared to a source directory, to a third directory.\nUseful if you fill up a hard drive while copying stuff. Faster and dumber than rsync.\n\n\nUsage: $0 /full/path/to/source/dir /comparison/dir /output/dir\n\n"; exit 1; }

diff -qr $1 $2 | sed 's/Only in //g' | sed 's/: //g' | xargs cp -t $3



