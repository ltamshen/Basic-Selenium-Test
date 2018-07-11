
After downloading, unzip the project.
Launch Eclipse. File>Import > Select “Projects from Folder or Archive”.
You will need to add the testng.jar and jcommander.jar files in addition to the Selenium (2) files to the Build Path (libriaries tab) in Eclipse.
Also, open testbase.java and update the driver path for Chrome to point to your installation of chromedriver.exe.
Right-click on the testngAddEmployee.xml file and select Run As > TestNG Suite.
You can also right-click on Main.java and run it as a Java application.
Open the test-output folder in the project and open emailable-report.html to see the results.
The application under test is expected to be in the root directory of the C drive. (driver.get("file:///C:/login.html")). Please update the testbase if it is located elsewhere.
