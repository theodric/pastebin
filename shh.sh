#!/usr/bin/expect -f
## Never type your SSH password again!
## (This is obviously insecure, so be a smart person.)
spawn ssh -o StrictHostKeyChecking=no $argv -l username
expect "assword:"
send "Awesomep4ssw0rd!\n"
interact 
