package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class DynamicControlsPage {
    //#1 : Create Constructor, and initialize 'driver' and 'object' of this class.

    public DynamicControlsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    // #2 : Instead of using .FindElement() , we will use @FindBy annotation

    @FindBy(xpath = "//button[text()='Remove']")
    public WebElement rmvBtn_Elem;
    //  //div[@id='loading']
    @FindBy(id = "loading")
    public WebElement loadingBar_Elem;


    //@FindBy(id="checkbox")
    // @FindBy(xpath="//input[@type='checkbox']")
    /* cssSelector  :  tagName[attribute=value]
     *  xpath        : //tagName[@attribute=value]
     *  */
    @FindBy(css = "input[type='checkbox']")
    public WebElement chkBox_Elem;

    @FindBy(id = "message")
    public WebElement itsGone_Msg_Elem;

    @FindBy(xpath="//input[@type='text']")
    public WebElement inputBox_Element;

    @FindBy(xpath="//button[text()='Enable']")
    public WebElement enableBtn_Elem;

    @FindBy(id="message")
    public WebElement itsEnabledMsg_Elem;
}
