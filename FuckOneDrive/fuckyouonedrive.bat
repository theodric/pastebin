@echo off
echo If you didn't run this as Administrator, it won't work. Just sayin'
echo.
echo --== L I G H T N I N G S T R I K E ==--
taskkill /f /im OneDrive.exe
echo.
echo I don't care to check what OS wordlength you're running,
echo so I will just attempt to run both the 32- and 64-bit uninstallers.
echo The non-applicable one for the current OS simply won't run, so fuck it.
echo You'll see an error message below as a result. Ignore.
echo.
%SystemRoot%\System32\OneDriveSetup.exe /uninstall
%SystemRoot%\SysWOW64\OneDriveSetup.exe /uninstall
rd "%UserProfile%\OneDrive" /Q /S
rd "%LocalAppData%\Microsoft\OneDrive" /Q /S
rd "%ProgramData%\Microsoft OneDrive" /Q /S
rd "C:\OneDriveTemp" /Q /S
reg delete "HKEY_CLASSES_ROOT\CLSID\{018D5C66-4533-4307-9B53-224DE2ED1FE6}" /f
reg delete "HKEY_CLASSES_ROOT\Wow6432Node\CLSID\{018D5C66-4533-4307-9B53-224DE2ED1FE6}" /f
reg import FuckOneDrive1.reg
reg import FuckOneDrive2.reg
echo.
echo You should reboot now. kthxbye
echo.
