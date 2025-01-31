package notes_from_d5_selenium;

public class d09_Singleton_Notes {
    /*
    Today's schedule:

	- Properties review
	    - Task review
	    - New similar task
	- Javafaker
	- Driver utility
	- Singleton Design Pattern

------------------------------------------------------------------------------------------------------------

- What is a properties file?
	- Properties type of file is just another type of file just like pdf, ppt, txt, docx, doc, xsl, csv
	- This file has .properties extension.

- Why do we use properties file? What makes it different than other type of files?
	- This file stores information in "key=value" format.
	- Because we are trying to not to hard code some important test data, we will store some key=value data in .properties file, and reach the values from there.

- What is hard coding?
	- Writing data directly in our source code is called hard coding in programming.
	- If I have to go in my .java class to change the value of the test data, it means that I had hard coded that data.

- How do we read from a Properties type of file?

#1- I will create a Properties class object, because it is able to read from .properties type of file.

	Properties properties = new Properties();

#2- I will use FileInputStream object to open the properties file in Java memory.

	FileInputStream file = new FileInputStream("pathOfTheFileWeAreTryingToOpen");

#3- I will load the "properties" object with the "file" object.

	properties.load(file);
	file.close(); --> this line would close the file from the java memory.

#4- I wil use the properties.getProperty("keyWord"); to read any value from the provided file.

	properties.getProperty("key"); --> "value"
	properties.getProperty("browser"); --> "chrome"
	properties.getProperty("username"); --> "helpdesk01"

- Which part of the "key=value" is hard coded in our .java class?
	- "key" is what we hard code in our .java class.
	- We create one "unique key" for that specific test data, and pass the key around.

	- "value" is inside of configuration.properties, and outside of any .java class.
	- Therefore, it is not hardcoded. I can change it, without even going in my .java classes.

- Why did we create the ConfigurationReader class?
	- So that we can create a utility method that would help us read any data from configuration.properties file repeatedly throughout our project.

------------------------------------------------------------------------------------------------------

DRIVER UTILITY CLASS

- WHAT, WHY, HOW

- What is the topic?
- We are going to create a new utility class: Driver.java

- Why are we creating this class?
1- We are writing too many lines to just be able to instantiate our WebDriver
2- We are having hard time passing the SAME driver instance around in our project.
	- When we are using any utility method, currently we have to pass the "WebDriver driver" as argument in each utility method.

	session_id: driver_asdf9876asd9f876
	driver.quit();
	session_id: driver_asdf098127312351

SOLUTION:
- We will create a Driver utils class, and a new .getDriver() method.
- We will create a logic which will guarantee the same exact instance every time we call the method.
- Also we will hand the setup lines such as maximize, and implict wait etc in our new utility method.

HOW?
- We will use a "design pattern"

- What is a design pattern?
- In software engineering, a design pattern is a general repeatable solution to a commonly occurring problem in software design.

- We will use "SINGLETON DESIGN PATTERN"
- Singleton Design Pattern guarantuees to return the same object EVERYTIME we want to use the object.

- How do we implement/apply the Singleton Design Pattern?

#1- Create a private constructor. Once a constructor is private, there can't be any object created outside of that class.

#2- We will create a .getDriver() method to deliver the object in the way that we want it to be delivered.
	- in the utility method we will create the logic below:
		- if object == null , create a new object and return it.
		- if object != null , just return existing object.



- Driver.java
	- We created this class to store some new utility methods.

	#1- Driver.getDriver() method:
		- This method allows us to pass the same driver instance everytime we call it.

		How it works?
		- First time we call the method, it will create a new driver, then every time we call it after, it will return the same existing driver instance.

		- Singleton Design Pattern allows us to do that.

	#2- Driver.closeDriver() method:
		- This method is necessary when we want to execute tests in different browsers and back to back each other.
		- If we use the .quit() method that is coming from Selenium library directly, it will terminate the existing session completely.
		- But our Singleton Design pattern works like this

			if(driver=null){
				//create a new instance
			}
			return driver;

		- Therefore, if the driver is terminated completely, and the value is not "null", singleton won't work for the rest of the tests. That's why we must set the driver value to null, so that our code can continue executing.

			driver = null;

syntax: for the closeDriver() method:

    public static void closeDriver(){

        if (driver!=null){

            driver.quit(); //driver completely terminated.

            driver = null; //value assigned back to "null" again.
        }
    }








     */
}
