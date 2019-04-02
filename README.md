**Selenium Server Standalone (a.k.a. Selenium Grid)**

1. can use to run tests in parallel if you have a large test suite that takes a long
time to run
2. requires selenium-server-standalone-3.141.59.jar
3. within command prompt, navigate to the directory where you have saved standalone jar
4. define hub: </br>
	`> java -jar selenium-server-standalone-3.141.59.jar -role hub -port 4444` </br>
	the server console can then be accessed at: http://localhost:4444/grid/console
5. configure a node: </br>
	~ To configure all browser types in one node: </br>
	`java -Dwebdriver.chrome.driver="C:\chromedriver.exe" -Dwebdriver.ie.driver="C:\IEDriverServer.exe" -jar selenium-server-standalone-3.141.59.jar -role webdriver -port 5556 -hubPort 4444 -hub "http://localhost:4444/wd/hub" -browser browserName=iexplore,maxInstances=3 -browser browserName=chrome,maxInstances=3 -browser browserName=firefox,maxInstances=3 -maxSession 3` </br>
	~ To configure Chrome and Firefox nodes: (for Pat's Windows laptop) </br>
	`java -Dwebdriver.chrome.driver="C:\chromedriver.exe" -Dwebdriver.gecko.driver=C:\geckodriver.exe -jar selenium-server-standalone-3.141.59.jar -role webdriver -port 5556 -hubPort 4444 -hub "http://localhost:4444/wd/hub" -browser browserName=chrome,maxInstances=3 -browser browserName=firefox,maxInstances=3 -maxSession 2` </br>
	
*NOTE:* it's good practice to put filepaths in quotes, just in case they have spaces
6. If you don't specify any browser configurations you will, by default, get: 5 instances of Chrome / 5 instances of Firefox / 1 instance of IE
7. If you start more than 1 node, then they have to be assigned to different ports
8. Now, once the server is set up, write the test cases...
	- need to reference the selenium-server-standalone jar in the project
	- test cases use 'DesiredCapabilities'
9. to stop the server, press 'ctrl-C'
