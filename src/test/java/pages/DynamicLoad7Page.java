package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class DynamicLoad7Page {
    public DynamicLoad7Page(){

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(tagName = "strong")
    public WebElement msg_Done_Element;

   @FindBy(xpath="//img[@alt='square pants']")
    public WebElement img_Element;


}
