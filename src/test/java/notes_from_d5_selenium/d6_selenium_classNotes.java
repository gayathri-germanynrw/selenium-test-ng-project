package notes_from_d5_selenium;

public class d6_selenium_classNotes {
    /*
    Today's schedule:
    - Review (mock interview)
    - Practices
    - Alerts
    - Iframes
    - Windows


------------------------------------------------------------------------------------

- XPATH :

- How do you handle dynamic web elements?
- How do you handle web elements that has dynamic attribute value?

#1- We can handle dynamic web elements using xpath methods, such as:
    - startswith
    - endswith
    - contains
    - These methods are looking for static part of the text in a dynamic text.


#2- Also, we can locate a static parent or child, and go from there to the web element we are trying to locate.


------------------------------------------------------------------------------------

div id=hh33
    div
        a
        a
            div
                a
        a
    div
div

- How do we move from parent to direct child using xpath?
    - We use "/" single slash to move from parent to child.
        //div[@id='hh33']/div
        //div[@id='hh33']/div/a

    - We can use "//" double slash to move ANY child under the web element located.
         //div[@id='hh33']//a

- How do we move from child to parent using xpath?
    - We use "/.." to move from child to parent.
    - We don't have to provide any tag after this sign.
    - It will directly go to the parent of the currently located web element.

- How do we use indexes with xpath?
    - Always put the locator that is returning more than 1 web element in a parantheses before passing the index.
    - Otherwise, without parantheses it will only work on direct childs.

    - syntax: (//tagName[@attribute='value'])[index]


------------------------------------------------------------------------------------

- TestNG:

- What is TestNG?
    - TestNG is a UNIT TESTING FRAMEWORK.

- Is this tool created for testers?
    - No. It is created for developers to do UNIT testing.

- Is this the only UNIT TESTING FRAMEWORK?
    - JUnit, NUnit, XUnit

- How do we create structures or change behaviors of methods using TestNG?
    - Annotations.

- Common annotations we will be using?

- @Test :
    - This annotation will convert a regular java method to a runnable TestNG test.
    - By default, the tests will run in alphabetical order.
    - But we can change the running order using "priority" keyword. Lower number will be executed first.
    - Each test is independent from each other, UNLESS we create dependency specifically.

    @Test (priority = 1)
    public void test1(){

        //code

        //assertion

        //code

        //assertion

    }

    @Test (priority = 2, dependency = "test1")
    public void test2(){

    }

- @BeforeMethod:
    - BeforeMethod will run ONCE before EACH test in the class.
    - The number of the tests will determine how many times this method will be executed.
    - If I have 15 tests, BeforeMethod will be executed 15 times.

- @AfterMethod:
    - AfterMethod will run ONCE after EACH test in the class.
    - The number of the tests will determine how many times this method will be executed.
    - If I have 15 tests, AfterMethod will be executed 15 times.

- @BeforeClass:
    - BeforeClass will run ONCE before all BeforeMethods, and Tests.
    - It doesn't care how many tests we have in the class.
    - It will be executed only one time.

- @AfterClass
    - AfterClass is similar to BeforeClass, but it will run after all Tests, and AfterMethods.

- Ex: If we want to open a new browser before each test, and close the browser after each test, where do we put our setup and teardown lines?

#1- BeforeMethod: WebDriver driver = WebDriverFactory.getDriver("chrome");
#2- AfterMethod : driver.close();

- Assertions:
    - What do assertions do?
    - Assertions are used to verify if actual = expected.
    - Assertions determine if a test passes or fails.
    - String, int, List<String>, List<WebElement>


- Which assertions we have seen so far?
    - Assert.assertEquals();
        - Accepts 2 arguments of the same type.
        - If both arguments are equal, it will pass the test.

    - Assert.assertTrue();
        - It will accept 1 argument that has to be returning "boolean" type.
        - If boolean returns true --> test will pass
        - If boolean returns false --> test will fail

    - Assert.fail();
        - This method is used to fail the tests intentionally.

------------------------------------------------------------------------------------

- DROPDOWNS:

- How many types of dropdowns we have?
- 2.

#1- HTML Dropdowns (non-select)
    - If the dropdowns are created using anything other than <select> tag, it will be an HTML dropdown.
    - We just locate it as any other web element and click to handle.

#2- Select Dropdowns
    - If dropdown is created using <select> tag, it is a select dropdown.
    - If we find a select dropdown, we have to use the SELECT class coming from Selenium.

- How do we handle select dropdowns?
#1- I would create an object from Select class.
#2- I would locate the <select> dropdown I want to do action on, and pass it into the constructor of Select object.
#3- Now my "select" object is ready to do action on the already located dropdown.

<select>
    <option value="A">LIST A</option>
    <option value="B">LIST B</option>
    <option value="C">LIST C</option>
</select>

- getOptions() :
    - to get all <options>
    - Return type: List<WebElement>

- getFirstSelectedOption() :
    - returns the CURRENTLY selected option as a single web element.
    - Return type: WebElement
    - We can use this method to verify the default select option.
    - Also we can use this method to get an option that we select later.

- selectByIndex
- selectByValue
- selectByVisibleText

---
---

Notes coming next class:
    - Alerts
    - Iframes
    - Windows

     */
}
