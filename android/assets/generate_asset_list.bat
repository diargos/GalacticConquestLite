@echo off
cd "C:\Users\Diargos\Desktop\GalacticConquestLite\android\assets"
cls
cd map
set filename="C:\Users\Diargos\Desktop\GalacticConquestLite\android\assets\assetlist.txt"
echo. > %filename%

for /f %%F in ('dir /b') do echo assetManager.load(^"map/%%F^",Texture.class); >> %filename% 2>&1
