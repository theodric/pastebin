@echo off
echo If you didn't run this as Administrator, it won't work. Just sayin'
echo
echo
echo --== B L I T Z K R I E G ==--
taskkill /f /im OneDrive.exe
rem the non-applicable one for the current OS word size simply won't run, so fuck it
%SystemRoot%\System32\OneDriveSetup.exe /uninstall
%SystemRoot%\SysWOW64\OneDriveSetup.exe /uninstall
rd "%UserProfile%\OneDrive" /Q /S
rd "%LocalAppData%\Microsoft\OneDrive" /Q /S
rd "%ProgramData%\Microsoft OneDrive" /Q /S
rd "C:\OneDriveTemp" /Q /S
reg delete "HKEY_CLASSES_ROOT\CLSID\{018D5C66-4533-4307-9B53-224DE2ED1FE6}" /f
reg delete "HKEY_CLASSES_ROOT\Wow6432Node\CLSID\{018D5C66-4533-4307-9B53-224DE2ED1FE6}" /f
reg import FuckOneDrive1.reg /f
reg import FuckOneDrive2.reg /f
