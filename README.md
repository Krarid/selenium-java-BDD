# selenium-java-BDD
A QA Automation project developed with Java and Cucumber as Behavior Driven Development

# Pre-requisites
Download and install Eclipse: https://eclipseide.org/

# Steps
1. Launch the Eclipse IDE
2. Create a new project by selecting File | New | Other from the Eclipse Main Menu
3. On the New dialog, select Maven | Maven Project and click Next
4. The New Maven Project dialog will be displayed. Select the Create a simple project (skip archetype selection) checkbox and click on the Next button.
5. On the New Maven Project dialog box, enter a group id, an artifact id, a name, a description and click on finish button
6. Eclipse will create the Luma project with a structure (in Package Explorer)
7. Select pom.xml from Package Explorer
8. Add the Selenium WebDriver, TestNG, Cucumber, Cucumber TestNG, PicoContainer and Commons-io dependencies from Maven Repository
9. Create “page.objects” and “steps” packages in src/test/java 
10. Create “drivers” folder in  src/test/resources
11. Download latest Chrome driver version and copy it to “drivers” folder
12. Create “steps” folder in src/test/resources and add a LUMA.feature file
13. Create a step definition class in src/test/java/steps “Browser.java”
14. Configure the project so it is a cucumber project “Right click > Configure > Convert to Cucumber Project”
15. Create runners package in “src/test/java” and add "TestRunner.java" class
16. Right click on “TestRunner.java” and “Run as > TestNG Test”
