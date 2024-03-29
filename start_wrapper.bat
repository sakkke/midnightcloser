@echo off

:restart
call .\start.bat

echo (To exit, press Ctrl+C)
echo Waiting for 10s...
timeout /t 10

goto restart