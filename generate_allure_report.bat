@echo off
:: If you already have a valid JAVA_HOME environment variable set, feel free to comment the below two lines
set JAVA_HOME=C:\Users\mohamed.abdelhay\.jdks\openjdk-19.0.2
set path=%JAVA_HOME%\bin;%path%
set path=C:\Users\mohamed.abdelhay\.m2\repository\allure\allure-2.22.0\bin;%path%
allure serve allure-results
pause
exit