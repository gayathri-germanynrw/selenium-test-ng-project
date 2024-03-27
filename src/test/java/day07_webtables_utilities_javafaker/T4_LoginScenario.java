package day07_webtables_utilities_javafaker;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.BrowserUtils;
import utilities.CRM_Utilities;

public class T4_LoginScenario extends TestBase {

    @Test
    public void test1_crm_login() {
        driver.get("http://login1.nextbasecrm.com/");
        WebElement usrElement = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        usrElement.sendKeys("helpdesk1@cydeo.com");

        WebElement passElement = driver.findElement(By.xpath("//input[@type='password']"));
        passElement.sendKeys("UserUser");

        WebElement btnSubmit = driver.findElement(By.xpath("//input[@type='submit']"));
        btnSubmit.click();
        BrowserUtils.sleep(3);

        BrowserUtils.verifyTitle(driver, "Portal");
    }

    @Test
    public void test2_crm_login() {
        driver.get("http://login1.nextbasecrm.com/");
        // logging in using the utility method we created in CRM utility class
        CRM_Utilities.login_crm(driver,"helpdesk1@cydeo.com","UserUser");
        BrowserUtils.sleep(3);
        BrowserUtils.verifyTitle(driver, "Portal");
    }


}

/*
TC #4: Login scenario
1. Create new test and make set ups
2. Go to: http://login1.nextbasecrm.com/
3. Enter valid username
4. Enter valid password
5. Click to `Log In` button
6. Verify title is as expected:
Expected: Portal


USERNAME PASSWORD
helpdesk1@cydeo.com UserUser
helpdesk2@cydeo.com UserUser

 */