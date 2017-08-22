@echo off
set ROOT=%~dp0
REM echo %ROOT%
REM cd /d "%ROOT%\lib"
set CPP=.;config
set SPLIT=;
for %%i in ("lib\*.jar") do (
	call  cpappend.bat %%i
)

set params=
set cnt=0
:loop
if "%1"=="" (echo params ok ) else	(set  params=%params% %1&shift /1&goto :loop)

java -cp %CPP%  com.dc.ftp.manager.client.CommandClient %params%