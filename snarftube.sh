#!/bin/sh
## initial downloader for the YouTube audiofier and resyndicator
## formerly manual_sync.sh

[[ $@ ]] || { printf "\nUsage: $0 http://youtube.com/user/ZastoZatoKurac archivefileidentifier\n [the latter arg is ideally whatever you've decided to call the directory you're synching the youtube channel into]\n\n" ; exit 1; }

youtubechannel=${1}

archivefileid=${2}

youtube-dl -t -x --audio-format mp3 --audio-quality 96k $youtubechannel --download-archive $archivefileid-archivefile &&
rename -v s/#// *mp3 &&
chown -vR www-data:www-data * &&
chmod -vR 775 * &&
cd .. &&
echo 'Done.'
