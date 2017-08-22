if ""%1"" == """" goto end
set CPP=%CPP%;%1
shift
rem Process the remaining arguments
:setArgs
if ""%1"" == """" goto doneSetArgs
set CPP=%CPP% %1
shift
goto setArgs
:doneSetArgs
:end