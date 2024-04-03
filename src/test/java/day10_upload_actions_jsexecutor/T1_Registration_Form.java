package day10_upload_actions_jsexecutor;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.BrowserUtils;
import utilities.ConfigurationReader;
import utilities.Driver;

public class T1_Registration_Form {
    @Test
    public void register_Form() {
        //1. Open browser
        //2. Go to website: https://practice.cydeo.com/registration_form
        Driver.getDriver().get(ConfigurationReader.getProperty("Registration_URL"));
        WebElement fName_Element = Driver.getDriver().findElement(By.xpath("//input[@name='firstname']"));
        fName_Element.sendKeys("Gayathri" + Keys.ENTER);
        WebElement lName_Element = Driver.getDriver().findElement(By.xpath("//input[@name='lastname']"));
        lName_Element.sendKeys("Kasi" + Keys.ENTER);

        WebElement usrName_Element = Driver.getDriver().findElement(By.xpath("//input[@name='username']"));
        usrName_Element.sendKeys("GayathriKasi" + Keys.ENTER);

        WebElement email_Element = Driver.getDriver().findElement(By.xpath("//input[@name='email']"));
        email_Element.sendKeys("gayathrikasi@example.com");

        WebElement passWd_Element = Driver.getDriver().findElement(By.xpath("//input[@name='password']"));
        passWd_Element.sendKeys("Dronav@2018");

        WebElement phone_Element = Driver.getDriver().findElement(By.xpath("//input[@name='phone']"));
        phone_Element.sendKeys("124-555-9875" + Keys.ENTER);
        WebElement radioBtn_Element = Driver.getDriver().findElement(By.xpath("//input[@value='female']"));
        radioBtn_Element.click();
        System.out.println("radioBtn_Element.isSelected() = " + radioBtn_Element.isSelected());

        WebElement birthDay_Element = Driver.getDriver().findElement(By.xpath("//input[@name='birthday']"));
        birthDay_Element.sendKeys("2/26/1982");

        WebElement dep_Element = Driver.getDriver().findElement(By.xpath("//select[@name='department']"));
        Select select = new Select(dep_Element);
        select.selectByVisibleText("Department of Engineering");


        WebElement job_Element = Driver.getDriver().findElement(By.xpath("//select[@name='job_title']"));
        Select select_job = new Select(job_Element);
        select_job.selectByVisibleText("SDET");

        WebElement checkBox_Element = Driver.getDriver().findElement(By.xpath("//input[@id='inlineCheckbox2']"));
        checkBox_Element.click();
        System.out.println("checkBox_Element.isSelected() = " + checkBox_Element.isSelected());

        WebElement signUpBtn_Elem = Driver.getDriver().findElement(By.xpath("//button[@id='wooden_spoon']"));
        signUpBtn_Elem.click();


        // 15.Verify success message “You’ve successfully completed registration.” is
        // displayed.
        String expectedMessage = "You've successfully completed registration!";
        // WebElement alert_Element=Driver.getDriver().findElement(By.tagName("p"));
        WebElement alert_success_Element = Driver.getDriver().findElement(By.xpath("//div[@role='alert']"));
        Assert.assertTrue(alert_success_Element.isDisplayed());

        //driver.quit();
        // Driver.getDriver().quit(); --> We don't use this method anymore. Because we want to assign the value back to null
        // So if we have another test, our code can continue executing.

        Driver.closeDriver();

    }

}

/*
TC#1: Registration form confirmation
1. Open browser
2. Go to website: https://practice.cydeo.com/registration_form
3. Enter first name
4. Enter last name
5. Enter username
6. Enter email address
7. Enter password
8. Enter phone number
9. Select a gender from radio buttons
10.Enter date of birth
11.Select Department/Office
12.Select Job Title
13.Select programming language from checkboxes
14.Click to sign up button
15.Verify success message “You’ve successfully completed registration.” is
displayed.
 */