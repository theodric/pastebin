#!/bin/bash
## theodric 2016-06-02
## veracrypt volume creation script
 
[[ $@ ]] || { 
printf "\nCreates a Veracrypt volume formatted as NTFS. Requires Veracrypt 1.17 or higher.\n"
printf "\nUsage: $0 <archive file or device> <'password'> <other optional arguments>\n";
printf "\nExample 1: encrypting an entire partition, where the client's disk is /dev/sdb and the target partition is /dev/sdb1 \n"
printf "$0 /dev/sdb1 'a5jq4rrw\$\zLQT3W8OfLl' \n";
printf "\nExample 2: creating an encrypted file within an existing filesystem, with a size of 500GB (size=bytes) \n"
printf "$0 /mnt/clientdisk/offload.vc 'a5jq4rrw\$\zLQT3W8OfLl' --size=500000000000\n";
printf "\nPlease note that the password MUST be enclosed in single quotes 'like this' \nand consequently the password cannot actually contain single quotes \n(escaping them doesn't work for some reason)\n\n";
 exit 1; }

printf "\nI'm about to run the following command:\n"
printf "veracrypt --verbose --create $1 --volume-type=normal --encryption=AES --hash=SHA-512 --filesystem=NTFS --quick --force --random-source=/dev/urandom --password=$2 --non-interactive $3\n\n"
read -r -p "Errors WILL result in unrecoverable data loss. Are you sure this is correct? [y/N] " response
if [[ $response =~ ^([yY][eE][sS]|[yY])$ ]]
	then
	veracrypt --verbose --create $1 --volume-type=normal --encryption=AES --hash=SHA-512 --filesystem=NTFS --quick --force --random-source=/dev/urandom --password=$2 --non-interactive $3 2> /dev/null

else
	printf "\nBailing out. Filesystem untouched.\n"
fi
