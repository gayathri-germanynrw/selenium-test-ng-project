package notes_from_d5_selenium;

public class d12_Selenium_Review_ClassNotes {
    /*
    Today's schedule:

#1- Review / Mock Interview
	- SYNCHRONIZATION
		#1- Thread.sleep
		#2- Implicit Wait
		#3- Explicit Wait
		#4- Fluent Wait

	- Page Object Model Design Pattern

#2- PRACTICES
	- Explicit Waits
		- Driver Utils
		- ConfigurationReader
		- configuration.properties
		- Singleton Design Pattern
		- Page Object Model Design Pattern

#3- Overall Mock session of Selenium Section

------------------------------------------------------------------------------------

- SYNCHRONIZATION

- What is SYNCHRONIZATION and Why do we need it?

- SYNCHRONIZATION definition: multiple things working, moving, acting at the same time.
- We need SYNCHRONIZATION because we need to make sure our browser and our driver are on the same page at all times.

#1- Thread.sleep();
	- This piece of code is coming from Java library.
	- It does NOT wait for any specific condition to happen.
	- It just stops executing current Thread for the given duration of milliseconds (no matter what)
	- Because of this its not good idea to use Thread.sleep in your code.

- All of the below wait types are coming from Selenium library.
- And they all wait for some condition to happen.
- And they all will move forward if the condition happens.

#2- Implicit Wait:
	- Which condition Implicit Wait is waiting?
	- The condition it is waiting is the web element given is located or not.
	- It is only kicked off (starts the timer) when the driver is not able to locate a WebElement with given locator.

- What triggers the Implicit Wait?
	- findElement() or FindBy annotation will trigger the NoSuchElement exception

- What throws NoSuchElementException?
	- findElement() or FindBy will throw the NoSuchElementException, if the web element is not found in the given duration.

#3- WebDriver Wait
	- WebDriverWait can be waiting for dozens of different types of conditions.

		alertIsPresent()
		elementSelectionStateToBe()
		elementToBeClickable()
		elementToBeSelected()
		frameToBeAvaliableAndSwitchToIt()
		invisibilityOfTheElementLocated()
		invisibilityOfElementWithText()
		presenceOfAllElementsLocatedBy()
		presenceOfElementLocated()
		textToBePresentInElement()
		textToBePresentInElementLocated()
		textToBePresentInElementValue()
		titleIs()
		titleContains()
		visibilityOf()
		visibilityOfAllElements()
		visibilityOfAllElementsLocatedBy()
		visibilityOfElementLocated()

- What happens if the timer runs out when using WebDriverWait?
	- TimeOutException

- What is POLLING?
	- How often the Selenium is checking the page if the condition happened or not.

- What is the default POLLING time in Selenium?
	- By default Selenium is checking the DOM (HTML page) every other 500 ms. (Twice in 1 second)

- How do we use the WebDriverWait?

	#1- We create the object of the WebDriverWait and set the Duration we want to wait in the constructor.

	WebDriverWait wait = new WebDriverWait(Duration.ofSecond(10));

	#2- Use the object to setup to wait for certain condition to happen.

	wait.until(ExpectedConditions.titleIs(String));
	wait.until(ExpectedConditions.visibilityOf(WebElement));

#4- Fluent Wait
	- FluentWait allows us to change the POLLING time in waiting.
	- That's pretty much the only difference in between the WebDriverWait and FluentWait


https://www.selenium.dev/documentation/webdriver/waits/

------------------------------------------------------------------------------------

PAGE OBJECT MODEL DESIGN PATTERN

- WHAT IS POM DESIGN PATTERN?
	- Basically just creating separate .java classes for different pages of the application.
	- We store the web elements and methods in their respective pages.

- Why do we need POM Design Pattern?
	- We create centralized repository for our WebElements.
	- REUSABILITY
	- EASY TO MAINTAIN
	- LESS CODE
	- CLEANER CODE
	- EASY TO COLLABORATE IN BETWEEN TEAM MEMBERS


- How do we implement POM Design Pattern?

After we create the java class:

#1- Create constructor and initialize the "driver" and "object" of that class.

	public Login(){
		PageFactory.initElements(Driver.getDriver(), this);
	}

#2- Instead of using findElement() method, we use FindBy annotations.

- Instead of this:

	WebElement someLink = Driver.getDriver().findElement(By.id("uh67"));

- We locate web elements like this:

	@FindBy(id='uh67')
	public WebElement someLink;


- Everytime we use the object of the class to use the WebElement, the element will be "re-located" by the @FindBy annotation.

- Therefore, the WebElement reference will always be FRESH. And this eliminates the StaleElementReferenceException.

------------------------------------------------------------------------------------

- After we created the POM Design pattern, one of the challenges (strucutural issues) that can come from it is, when we create & instantiate the object in the class level, it will be used for the 1st test and then it will be terminated.
- So, the class' object will not have a "session id" for the rest of the tests that are supposed to be executed.
- SOLUTION:
	1- We create the object in the class level,
	2- BUT INSTANTIATE in the @BeforeMethod

 //1- Create the object in the class level
 DynamicControlsPage dynamicControlsPage;

    @BeforeMethod
    public void setupMethod(){

        //2- instantiate it in the BeforeMethod
        dynamicControlsPage = new DynamicControlsPage();

    }


------------------------------------------------------------------------------------
- ANSWER THESE QUESTIONS AS IF YOU ARE IN AN INTERVIEW!

- What is Selenium?
- Selenium is an open source library to automate browsers.


------------------------------------------------------------------------------------
- Why are we using Selenium when we have so many other automation tools?
- What are the advantages of using Selenium?
	- Open source --> Free
    - Supports multiple programming languages
    - Supports multiple OS (Windows, Mac, Linux)
    - Supports multiple browsers
    - It has a major community support behind it


------------------------------------------------------------------------------------
- What are the disadvantages of using Selenium?
	- We cannot automate desktop applications
    - Requires advance programming language experience/knowledge
    - No costumer service 1-800-selenium
    - There is no built-in report coming from Selenium library


------------------------------------------------------------------------------------

- WHAT IS A WEB ELEMENT?

	- Everything we see on a web page from links, to images, to input boxes, to checkboxes all of them are web elements.

------------------------------------------------------------------------------------

- WHAT IS THE DIFFERENCE BETWEEN GETTEXT AND GETATTRIBUTE METHOD?

- webelement.getText():
        - It doesn't accept any argument.
        - It will return the text of the provided WebElement as a String
        - Return type: String
    - Where does the .getText() method, gets the text from?
        - .getText() method can only read in between the <openingTag> and </closingTag>


- .getAttribute("attributeName"):
        - It accepts a String argument as an "attributeName".
        - It will find the matching "attributeName" and return its value as a String.
        - Return type is String.
    - Where does the .getAttribute() method, gets the text from?
        - Gets the text from the opening tag.

------------------------------------------------------------------------------------

- WHAT ARE LOCATORS?
	- Locators are methods coming from Selenium library that help us locate WebElements.
    - There are 8 locators
    - id, name, linkText, partialLinkText, cssSelector, xpath, tagname, className


------------------------------------------------------------------------------------

- WHAT IS YOUR LOCATOR APPROACH? HOW DO YOU DECIDE WHICH LOCATOR TO USE?
	- If there is id, I make sure it is not dynamic and I use it.
    - If there is class, I can check if it is unique or not by using "." from cssSelector
    - If the web element is a LINK, I use "linkText" locator
    - If none of the above is applicable, I am comfortable creating custom locators using XPATH.


------------------------------------------------------------------------------------

- XPATH
	- HOW MANY TYPES OF XPATH DO WE HAVE?
	- WHAT IS THE DIFFERENCE BETWEEN USING SINGLE SLASH "/" AND DOUBLE SLASH "//" IN LOCATORS?
	#1- ABSOLUTE XPATH
	#2- RELATIVE XPATH

#1- ABSOLUTE XPATH:
    - Starts with "/" single slash
    - "/" means start from the root element "html" and go 1 by 1 to the desired web element.
    - This locator is not stable and will break very easily if there is any minimal change in the html page.
    - Therefore it is not recommended to use.

#2- RELATIVE XPATH:
    - Starts with "//" DOUBLE slash
    - "//" means jump to the web element provided
    - Relative xpath is more reliable because we are being very specific compared to "absolute xpath"

    //input[@id='something']
    //input[@id="something"]

--> //tagName[@attribute='value']
--> //tagName[.='text']
--> //tagName[text()='text']
--> /following-sibling::
--> /preceding-sibling::

----------------------------------------------------------------------------------------------------

- HOW DO YOU HANDLE DYNAMIC WEB ELEMENTS?

1- We can use the xpath locator methods such as : contains, starts-with, and ends-with to locate web elements that has dynamic attribute value.

//tagName[contains(@attribute, 'value')]
//tagName[starts-with(@attribute, 'value')]
//tagName[ends-with(@attribute, 'value')]

2- We can also locate a static (not-changing/unique) parent or child and move from there to desired web element.

----------------------------------------------------------------------------------------------------

- How do we go from child to parent using XPATH?
	- "/.." will take my locator from current child to parent.

- How do we go from parent to child using XPATH?

	-  "/" will take my locator from parent to child.


----------------------------------------------------------------------------------------------------

- What is MAVEN?
- MAVEN is a build automation tool.

----------------------------------------------------------------------------------------------------

- What is a build?
- Repeating steps when we are creating a project, and managing/maintaining after creating.

	- such as:
		- creating the folder structure,
		- adding,
		- compiling our code,
		- testing,
		- deploying

----------------------------------------------------------------------------------------------------

- What is the most important file in a Maven project?
	- pom.xml

- What is pom.xml file and why do you use it?
	- pom : project object model
	- xml : extensible markup language

- Why do you use it?
	- Add dependencies
	- Manage dependencies
	- Change versions of dependencies
	- Remove dependencies

- Where does maven store all of the dependencies?
	- .m2
	- By default, it is a hidden file.
	- If you are in a situation where your maven project is not working after adding/removing/changing version of a dependency, and you tried to re-load project, you can go into .m2 folder, and delete everything and reload project.
	- maven will auto-download everything from scratch

----------------------------------------------------------------------------------------------------

- What are the differences between .findElement() method and findElements() method?

    - findElement() method:
    	- Return type: WebElement type
   		- It returns a single WebElement

- What happens if findElement() method can't find a web element with given locator?
   		- NoSuchElementException will be thrown.

   	- findElements() method:
   		- Return type: List<WebElement>
   		- It is capable of returning multiple web elements at once.

- What happens if findElement() method can't find a web element with given locator?
		- It will not throw exception.
		- It will return empty list.

----------------------------------------------------------------------------------------------------

- How do we handle checkboxes and radio buttons using Selenium?
	- First we locate, then we click.

- How do we verify if checkbox is selected or not?

	- isSelected();
		- If checkbox is selected, this method will return 'true'
		- If checkbox is NOT selected, this method will return 'false'

	- isEnabled();
		- If checkbox is enabled, this method will return 'true'
		- If checkbox is NOT enabled, this method will return 'false'


----------------------------------------------------------------------------------------------------

- What is TESTNG?
	- Unit Testing Framework.
	- Originally it is used by developers to do UNIT TESTING.
	- As testers we are using some of the annotations and methods to create certain structure for our tests.

- Why do we use the annotations?
	- Annotations allows us to change the behavior of the JAVA methods.
	- We can enforce certain running flow in between different Java methods.


----------------------------------------------------------------------------------------------------
DROPDOWNS

- How do we handle DROPDOWNS?
- How many DROPDOWNS do we have?

- There are 2 types of dropdowns.

#1- HTML Dropdown (non-select)
	- We just locate using regular selenium locators
	- And click, then verify.

#2- Select Dropdown
	- If a dropdown is created using <select> tag, then we are allowed to use Select class' object.

Syntax:
    Select yearDropdown = new Select(dropdown_as_WebElement);
    Select monthDropdown = new Select(dropdown_as_WebElement);


- How do we get currently selected option using select object?

	- .getFirstSelectedOption();
	- This method will return the currently selected option as a WebElement type.

- How many different ways I can select an option using Select class?
	- 3 ways.

	#1- selectByIndex --> accept the index number and select based on that. indexes start from 0
	#2- selectByVisibleText --> uses the text of the <option> we want to select.
	#3- selectByValue --> uses the value of the attribute "value"

- How do we get all of the options from a select dropdown?
	- .getOptions();
	- Return type: List<WebElement>
	- This method will return all of the <option> tags contained under that <select> tag, as a list of web element.

----------------------------------------------------------------------------------------------------

ALERTS

- HOW MANY TYPES OF ALERTS DO WE HAVE?
	- 2 TYPES OF ALERTS

	#1 - NON-JS ALERTS (HTML ALERT)
		- We can directly locate them using any locators
		- Click and get rid of them from the screen.
		- Most of the time, they don't even block the page completely.

	#2 - JS ALERTS
		- They block the page completely.
		- We cant do anything else, until we handle JS alerts.

	- How many types of JS Alerts do we have?

	#1- Information Alert
		- User can only accept using
			--> .accept();
	#2- Confirmation Alert
		- User can accept and decline using
			--> .accept();
			--> .decline();

	#3- Prompt Alert
		- User can accept, decline, and pass text using
			--> .accept();
			--> .decline();
			--> .sendKeys("text here");

- How do we handle JS ALERTS?

- We handle alerts using Alert from Selenium.

syntax:

	Alert alert = driver.switchTo().alert();
	Alert alert = Driver.getDriver().switchTo().alert();

	alert.accept();
	alert.decline();
	alert.sendKeys("text here");

----------------------------------------------------------------------------------------------------
IFRAME

- What is iframe?
- An iframe is html inside of another html.

- How do we handle iframe?
- We MUST switch driver's focus from main html to iframe.

- Why do we have have to change the driver's focus?
- Selenium can focus only 1 thing at a time.
- By default, it is focusing the main <html> code.
- Until we switch the focus of the driver to the <iframe>, selenium will not be able to locate or do any action on any web elements (even if we provide correct locators)

- How many ways do we have to switch to iframes?
	- We use switchTo() method to switch to an iframe.
	- We have 3 ways to switch.

#1- index
	- we can figure out the index number of the frame, and pass it as a int
	- indexes start from 0
#2- id, name
	- if the <iframe> tag has "id" or "name" attributes, we can directly pass their values to switch to them.
#3- web element
	- We can directly locate the <iframe> tag as a WebElement and pass it into the switchTo() method.


syntax:

- index:
	driver.switchTo().frame(int index);

- id, name
	driver.switchTo().frame("idValue");
	driver.switchTo().frame("nameValue");

- WebElement

	driver.switchTo().frame(Driver.getDriver.findElement(By.locator));


- How can we switch the driver's focus back to the outer frame?

	- driver.switchTo().defaultContent();
		--> will default back to main HTML page.

	- driver.switchTo().parentFrame();
		--> if we switched to an iframe inside of another iframe, it will go back just 1 layer.

- If we have just 1 layer of iframes, both method will do the same thing.

----------------------------------------------------------------------------------------------------

WINDOWS:

- WHAT IS THE DIFFERENCE BETWEEN WINDOW AND A TAB FOR SELENIUM?
	- Both are same. There is no difference for selenium in between window and a tab.
	- Selenium treats both as a "window"

- How do we handle windows?
	- We can handle windows using "window handles."

- What is a window handle?
	- A randomly generated unique alphanumeric value for each window.


- How can we switch window handles?

syntax:
	 driver.switchTo().window("window handle");


----------------------------------------------------------------------------------------------------
ACTIONS:

- How do we handle "advanced" mouse and keyboard actions?
- Actions class can handle "advanced" mouse and keyboard actions.
	- double click
	- drag and drop
	- click and hold
	- move to element
	- keyUp
	- keyDown
	- we can do the above actions and more using Actions class.

- How do we use it?

#1- We create the object of the Actions class.

	Actions actions = new Actions(driver);

#2- Use the actions object to create chain methods, and perform at the end.

	actions.moveToElement(webElement).perform();


----------------------------------------------------------------------------------------------------

JSEXECUTOR:

- WHAT IS JavascriptExecutor?

- It is basically a simple interface with just 2 methods.
	- executeScript : this method will wait until the js code we pass in it is completed.
	- executeAsynchScript : this method won't wait until the js code is completed.
- If we need to pass JavaScript code in our JAVA+SELENIUM code, we can use this interface.

- How do we use the JavascriptExecutor?
- Because the JavascriptExecutor is another interface just like WebDriver, we have to cast our WebDriver type to JavascriptExecutor type.
- After that, we can reach the methods in the JavascriptExecutor interface, and use them with our driver instance.

Syntax:

	JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

	js.executeScript("scroolIntoView");
	js.executeScript("scrollBy");
	js.executeScript("create a new tab");

- How many ways you know to scroll?
	- actions.moveToElement
	- actions.sendKeys(PageUP)
	- actions.sendKeys(PageDOWN)

	- js.executeScript("scroolIntoView");
	- js.executeScript("scrollBy");

----------------------------------------------------------------------------------------------------

CONFIGURATION READER:
	- Why did we create the ConfigurationReader?
	- Prevent "HARD CODING" of test data
	- Centralize important test data
		- cross browser testing
		- data driven testing

----------------------------------------------------------------------------------------------------

DRIVER:

- Why did we create Driver utility class?
- Because, we were typing too many lines to instantiate our driver instance.
- We were having hard time passing our driver instance from difference classes, to diffent methods etc.

- We implemented Singleton Design Pattern.

- We achieved Singleton Design Pattern by using simple if condition.

	if(driver == null){
		//create new driver
	}
	return driver;
     */
}
