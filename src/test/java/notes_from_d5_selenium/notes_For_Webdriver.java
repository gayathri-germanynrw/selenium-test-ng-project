package notes_from_d5_selenium;

public class notes_For_Webdriver {
    /*
     On the very first line of code you learnt when you started your automation classes: WebDriver driver = new ChromeDriver();
I believe you know what this code means but you all should understand very well and be able to explain the logic and the key concepts behind this code using correct terminology. Here are some explanatations. However, as a team you can improve this info.
WebDriver driver = new ChromeDriver();

✅ Here, we are creating a reference variable of the WebDriver interface and casting it to the
                ChromeDriver Class.
✅ WebDriver is an interface, driver is a reference variable, ChromeDriver() is a Constructor,
     new is a keyword, and new ChromeDriver() is an object.
✅ Depending on the type of the browser you want to launch, you can change the browser-specific driver to
  FirefoxDriver(), InternetExplorerDriver(), etc.
✅ This is what runtime polymorphism is: using a parent class reference type of variable to refer to a  child class object. Here, one driver instance can take multiple forms
➡️  But why do we need to create a reference variable of type WebDriver? Here comes a few questions:
📌 Is this correct → WebDriver driver = new WebDriver(); ?

No.  WebDriver is an interface and we CANNOT instantiate an interface.
Also, logically it does not make sense because no particular browser is specified
TO BE CONTINUED
     */
}
