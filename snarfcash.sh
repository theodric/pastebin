#!/bin/bash
## snarfcast.sh - script to turn RSS feeds into a pile of mp3s
## script was wrapped around command string from:
## https://stackoverflow.com/questions/9135671/curl-command-line-to-get-embedded-files-in-rss-feed

[[ $@ ]] || { printf "\nUsage: $0 http://domain.tld/path/to/rssfeed\n\n" ; exit 1; }

URL=${1}

curl -s $URL | xmlstarlet sel -N atom="http://www.w3.org/2005/Atom" -t -m './/enclosure' -v '@url' -n | wget -i -
