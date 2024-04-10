package day12_review;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DynamicControlsPage;
import utilities.BrowserUtils;
import utilities.Driver;

import java.time.Duration;

public class T2_T3_Explicit_Wait_Practice {
    DynamicControlsPage dynamicControlPage;

    @BeforeMethod
    public void setUp() {
        //1- Open a chrome browser
        //2- Go to: https://practice.cydeo.com/dynamic_controls
        dynamicControlPage = new DynamicControlsPage();
        Driver.getDriver().get("https://practice.cydeo.com/dynamic_controls");
    }

    @Test
    public void t2_explicit_wait_practice() {
        //3- Click to “Remove” button
        dynamicControlPage.rmvBtn_Elem.click();

        //4- Wait until “loading bar disappears”

        //For Explicit wait handle: WebDriverWait coming from Selenium
       /*
        //Create the object of 'WebDriverWait' class, and set up the constructor args
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20));
        // Use the above 'wait' object with wait.until(ExpectedConditions.invisibilityOf(WebElement))
        wait.until(ExpectedConditions.invisibilityOf(dynamicControlPage.loadingBar_Elem));
      */

        // This method accepts WebElement not to be displayed on page
        BrowserUtils.waitForInvisibilityOf(dynamicControlPage.loadingBar_Elem);

        //5- Verify:
        //a. Checkbox is not displayed

        // dynamicControlPage.chkBox_Elem.isDisplayed(); --> if displayed , returns true

        // Assert from TestNG
        //Assert.assertTrue(dynamicControlPage.chkBox_Elem.isDisplayed()); --> positive condition
        // Assert.assertTrue(!dynamicControlPage.chkBox_Elem.isDisplayed()); --> negative  condition

        // asserFalse method is expecting a "false" boolean value to PASS the test.
        try {
            Assert.assertFalse(dynamicControlPage.chkBox_Elem.isDisplayed());
        } catch (NoSuchElementException e) {
            //e.printStackTrace();
            System.out.println("NoSuchElementException is thrown. It means that the checkbox is not aon the page ");
            Assert.assertTrue(true);
        }

        //b. “It’s gone!” message is displayed.
        Assert.assertTrue(dynamicControlPage.itsGone_Msg_Elem.isDisplayed());
    }


    @Test
    public void t3_explicit_wait_practice() {
        //3- Click to “Enable” button
        dynamicControlPage.enableBtn_Elem.click();

        //4- Wait until “loading bar disappears”
       /* WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOf(dynamicControlPage.loadingBar_Elem));

        */

        // This method accepts WebElement not to be displayed on page
        BrowserUtils.waitForInvisibilityOf(dynamicControlPage.loadingBar_Elem);


        //5- Verify:
        //a. Input box is enabled.
        Assert.assertTrue(dynamicControlPage.inputBox_Element.isEnabled());
        //b. “It’s enabled!” message is displayed.
        Assert.assertTrue(dynamicControlPage.itsEnabledMsg_Elem.isDisplayed());
    }

    @AfterMethod
    public void tearDownMethod(){
        Driver.closeDriver();
    }

}

/*
TC #2: Explicit wait practice
1- Open a chrome browser
2- Go to: https://practice.cydeo.com/dynamic_controls
3- Click to “Remove” button
4- Wait until “loading bar disappears”
5- Verify:
a. Checkbox is not displayed
b. “It’s gone!” message is displayed.
NOTE: FOLLOW POM
 */

/*
TC #3: Explicit wait practice
1- Open a chrome browser
2- Go to: https://practice.cydeo.com/dynamic_controls
3- Click to “Enable” button
4- Wait until “loading bar disappears”
5- Verify:
a. Input box is enabled.
b. “It’s enabled!” message is displayed.
NOTE: FOLLOW POM
 */
