package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class W3Page {
    // Create Constructor and initialize the 'driver' instance and 'object' of the current class.
    public W3Page(){
        // Initialize driver and Object of that class
        PageFactory.initElements(Driver.getDriver(),this);
    }
    // Instead of using
    @FindBy(id="demo")
    public WebElement paragraph;
}
