#!/bin/bash
## theodric 2016-06-02
## veracrypt volume mount script
 
[[ $@ ]] || { 
printf "\nMounts a specified Veracrypt volume\n"
printf "\nUsage: $0 <archive file or device> <'optional password'> <other optional arguments>\n";
printf "\nExample 1: "
printf "$0 /dev/sdb1 'a5jq4rrw\$\zLQT3W8OfLl' \n";
printf "Example 2: "
printf "$0 /mnt/client_disk/veracryptfile.vc 'a5jq4rrw\$\zLQT3W8OfLl' \n";
printf "\nPlease note that the password MUST be enclosed in single quotes 'like this' \nand consequently the password cannot actually contain single quotes \n(escaping them doesn't work for some reason)\n\n";
 exit 1; }

password=$2;

if [ -z "$2" ]
	then
	printf "\nPassword not supplied at runtime. "
	read -s -p "Please enter the password (will not echo!): " password
	printf "\n"
fi
printf "\nVeracrypt mount utility\n"
veracrypt --verbose -t -k "" --protect-hidden=no $1 --password=`echo $password | tr -d "'"` --non-interactive 2> /dev/null;
printf "My best guess for the mount location is "
tail -n1 /proc/mounts | awk '{ print $2 }'
printf "\n"

