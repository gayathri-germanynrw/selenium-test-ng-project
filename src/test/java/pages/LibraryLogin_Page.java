package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class LibraryLogin_Page {
    // #1 -> Initialize the object of the class and
    // driver instance inside the constructor

    public LibraryLogin_Page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    // #2 - Use @FindBy annotation instead of FindElement() Method

    //WebElement signInBtn=Driver.getDriver().findElement(By.xpath("//button[.='Sign in']"));
    @FindBy(xpath="//button[.='Sign in']")
    public WebElement signInButton;

    @FindBy(xpath="//div[.='This field is required.']/div")
    public WebElement  fieldReqErrMsg;

    @FindBy(id = "inputEmail")
    public WebElement emailInput;

    @FindBy(xpath="//div[.='Please enter a valid email address.']/div")
    public WebElement errMsg_invalid_email;

    @FindBy(xpath="//input[@id='inputPassword']")
    public WebElement inputPassword;

    @FindBy(xpath="//div[@role='alert']")
    public WebElement wrong_Email_or_Passwd;


}

