# Applitools_Hackaton

[Hackathon Instructions](https://applitools.com/cross-browser-testing-hackathon-v20-1-instructions/)

## How to run the project
- The project was made for running locally, in Intellij Idea or from a command line.
- Requirements: Java 13 as project SDK and Apache Maven 3.6.3
- Maven will import all the other dependencies, such as TestNG.
#### Environment variables
- All .exe files for browsers drivers were set up locally as Windows environment variables and imported to the project at runtime.
- Applitools API key followed the same logic as browsers drivers.

### Running in Intellij Idea
- A correct testng_suite.xml file needs to be run for each approach: Traditional1, Traditional2, Modern1, Modern2. 
- Each folder contains its own testng_suite.xml file.

### Running from a command line:
1. ModernTestsV1: enter the folder C:\Users\Nena\repos\Applitools-CrossBrowser-Hackaton\ModernTestsV1\Applitools-Hackaton and run the command "mvn clean test"
2. ModernTestsV2: enter the folder C:\Users\Nena\repos\Applitools-CrossBrowser-Hackaton\ModernTestsV2\Applitools-Hackaton and run the command "mvn clean test"
3. TraditionalTestsV1: enter the folder C:\Users\Nena\repos\Applitools-CrossBrowser-Hackaton\TraditionalTestsV1\Applitools-Hackaton and run the command "mvn clean test"
4. TraditionalTestsV2: enter the folder C:\Users\Nena\repos\Applitools-CrossBrowser-Hackaton\TraditionalTestsV2\Applitools-Hackaton and run the command "mvn clean test"





Any questions? Let me know! My name is Nevena Cukucan, nevena@baetz.com
