@echo off
set ROOT=%~dp0
REM echo %ROOT%
REM cd /d "%ROOT%\lib"
set CPP=.;config
set SPLIT=;
for %%i in ("lib\*.jar") do (
	call  cpappend.bat %%i
)
REM echo %CPP%

java -cp %CPP% -Dbase.path=%ROOT% com.zl.base.ftp.server.Main
 