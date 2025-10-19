@echo off
:: ----------- Définition des variables ----------- 
set src=src\
set lib=lib\
set bin=bin\
set src_temp=src_temp
set build=build
set webapp=C:\Program Files\Apache Software Foundation\Tomcat 10.1\webapps
set name=helloworld


:: ----------- Préparation ----------- 
echo Préparation des dossiers...
mkdir %src_temp%
mkdir %build%
cd %build%
mkdir WEB-INF\classes
mkdir WEB-INF\lib
cd ..

:: ----------- Copie des fichiers sources ----------- 
echo Copie des fichiers sources...
@REM xcopy /s /e /i "%src%" "%src_temp%" 
cd %src%
for /r %%F in (*.java) do (
    copy "%%F" "..\%src_temp%"
)

cd ..
@REM :: ----------- Compilation ----------- 
echo Compilation des fichiers Java...
javac -cp %lib%\* -g:vars -d %bin% %src_temp%\*.java

:: ----------- Copie des fichiers compilés ----------- 
echo Copie des fichiers compilés et des bibliothèques...
xcopy /s /e /i "%bin%\*" "%build%\WEB-INF\classes\"
xcopy /s /e /i "%lib%\*" "%build%\WEB-INF\lib\"
xcopy /s /e /i "src\webapp\WEB-INF\web.xml" "%build%\WEB-INF\"

:: ----------- Création du fichier WAR ----------- 
echo Création du fichier WAR...
cd %build%
jar -cvf "%name%.war" .
cd ..

@REM :: ----------- Déploiement sur Tomcat ----------- 
echo Déploiement sur Tomcat...
del "%webapp%\%name%.war" >nul 2>&1
del "%webapp%\%name%.war.deployed" >nul 2>&1
copy "%build%\%name%.war" "%webapp%\"

@REM :: ----------- Nettoyage ----------- 
echo Nettoyage...
del "%build%\%name%.war"
rd /s /q %build%
rd /s /q %src_temp%

@REM :: ----------- Fin ----------- 
echo Déploiement terminé avec succès !
pause
