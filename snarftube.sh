#!/bin/bash
## initial downloader for the YouTube audiofier and resyndicator
## formerly manual_sync.sh

[[ $@ ]] || { printf "\nUsage: $0 http://youtube.com/user/ZastoZatoKurac archivefileidentifier < --skip-download > \n [the second arg is ideally whatever you've decided to call the directory you're synching the youtube channel into]\n\n" ; exit 1; }

youtubechannel=${1}
archivefileid=${2}
optarg=${3}

youtube-dl -t -x --audio-format mp3 --audio-quality 96k $youtubechannel --download-archive $archivefileid-archivefile $optarg &&
rename -v s/#// *mp3 &&
chown -vR www-data:www-data * &&
chmod -vR 775 * &&
cd .. &&
echo 'Done.'
