#!/usr/bin/expect -f
## Never type your SSH password again!
## (This is obviously insecure, so be a smart person.)
spawn ssh $argv -l username
expect "assword:"
send "Awesomep4ssw0rd!\n"
interact 
