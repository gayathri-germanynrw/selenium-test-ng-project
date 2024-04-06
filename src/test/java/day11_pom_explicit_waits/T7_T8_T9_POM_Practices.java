package day11_pom_explicit_waits;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LibraryLogin_Page;
import utilities.BrowserUtils;
import utilities.Driver;

public class T7_T8_T9_POM_Practices {
    LibraryLogin_Page loginPage;

    @BeforeMethod
    public void setUpMethod() {
        //1- Open a chrome browser
        //2- Go to: https://library1.cydeo.com
        Driver.getDriver().get("https://library1.cydeo.com");
        loginPage = new LibraryLogin_Page();
    }

    @AfterMethod
    public void tearDownMethod() {
        Driver.closeDriver();
    }

    @Test
    public void t7_field_required_error_msg_test() {
        //TC #7: Required field error message test

        //3- Do not enter any information
        //4- Click to “Sign in” button
        loginPage.signInButton.click();

        //5- Verify expected error is displayed:
        Assert.assertTrue(loginPage.fieldReqErrMsg.isDisplayed());
        //Expected: This field is required.
        //NOTE: FOLLOW POM DESIGN PATTERN
    }

    @Test
    public void t8_invalidEmail_format_ErrMsg() {
        //TC #8: Invalid email format error message test
        //3- Enter invalid email format
        loginPage.emailInput.sendKeys("gaya" + Keys.ENTER);

        //4- Verify expected error is displayed:
        String expected_ErrMsg = "Please enter a valid email address.";
        Assert.assertTrue(loginPage.errMsg_invalid_email.isDisplayed());
        //Assert.assertEquals(loginPage.errMsg_invalid_email.getText(),expected_ErrMsg);

        //Expected: Please enter a valid email address.
        //NOTE: FOLLOW POM DESIGN PATTERN
    }

    @Test
    public void t9_Library_negative_login() {
        //TC #9: Library negative login
        loginPage.emailInput.sendKeys("gayay@gmail.com");
        BrowserUtils.sleep(2);
        loginPage.inputPassword.sendKeys("ghgchag" + Keys.ENTER);
        loginPage.signInButton.click();
        //4- Verify title expected error is displayed:
        //Expected: Sorry, Wrong Email or Password
        String expectedStr = "Sorry, Wrong Email or Password";
        BrowserUtils.sleep(2);
        Assert.assertEquals(loginPage.wrong_Email_or_Passwd.getText(), expectedStr);

        //NOTE: FOLLOW POM DESIGN PATTERN
    }
}

