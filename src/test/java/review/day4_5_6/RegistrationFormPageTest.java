package review.day4_5_6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.awt.event.MouseWheelEvent;
import java.time.Duration;

public class RegistrationFormPageTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
            // 1. Open Chrome browser
            driver= WebDriverFactory.getDriver("chrome");
            // 2. Go to https://practice.cydeo.com/registration_form
            driver.get("https://practice.cydeo.com/registration_form");
    }

        @Test
        public void registrationFormPageTest() {
            // 3. Verify title is as expected:
            // Expected: "Registration Form"
            String actualTitle=driver.getTitle();
            String expectedTitle="Registration Form";
            Assert.assertEquals(actualTitle,expectedTitle);

            //Assert.assertTrue(actualTitle.equals(expectedTitle));

        }

        @Test
        public void registrationFormPageFillingOutTest(){
            // 1. Open Chrome browser
            // 2. Go to https://practice.cydeo.com/registration_form
            // 3. Enter First name: "John"
            WebElement firstName=driver.findElement(By.className("form-control"));
            firstName.sendKeys("John");
            //input.form-control  --> cssSelector --> tagName.classvalue
            // 4. Enter Last name: "Smith"
            WebElement lastName=driver.findElement(By.xpath("//input[@name='lastname']"));
            lastName.sendKeys("Smith");


            // 5. Enter Username: "johnsmith123"  (Using index from xpath)
            WebElement userName=driver.findElement(By.xpath("(//input[@type='text'])[3]"));
            userName.sendKeys("johnsmith123");

            // 6. Enter Email address: "john.smith@email.com"

            WebElement emailAddress=driver.findElement(By.cssSelector("input[placeholder='email@email.com']"));
            emailAddress.sendKeys("john.smith@email.com");

            // 7. Enter password: "John1234"
            WebElement password=driver.findElement(By.xpath("//input[@name='password']"));
            password.sendKeys("John1234");

            // 8. Enter Phone number: "123-456-7890"
            WebElement pnNumber=driver.findElement(By.xpath("//input[@type='tel']"));
            pnNumber.sendKeys("123-456-7890");

            // 9. Click to "Male" from Gender

            WebElement maleBtn=driver.findElement(By.xpath("//input[@value='male']"));
            maleBtn.click();
            Assert.assertTrue(maleBtn.isSelected());

            // 10. Enter Date of birth "01/28/1990"
            WebElement bDate=driver.findElement(By.xpath("//input[@placeholder='MM/DD/YYYY']"));
            bDate.sendKeys("01/28/1990");
            // 11. Select "Department of Engineering" from Department/Office dropdown
            WebElement selDept=driver.findElement(By.xpath("//select[@name='department']"));
            Select select=new Select(selDept);
           // select.getFirstSelectedOption().getText(); // return default values

           // select.selectByIndex(1); // default takes 0 index (hard to find when 50 elements)
           // select.selectByValue("DE");
            select.selectByVisibleText("Department of Engineering");  // will be working every time (Best one )






            // 12. Select "SDET" from Job title dropdown
            Select selectJob=new Select(driver.findElement(By.xpath("//select[@name='job_title']")));
            System.out.println("selectJob.getFirstSelectedOption().getText() = " + selectJob.getFirstSelectedOption().getText());

            //selectJob.selectByIndex(4);
            selectJob.selectByVisibleText("SDET");



            // 13. Click to "Java" from languages
            WebElement javaLang=driver.findElement(By.cssSelector("input[id='inlineCheckbox2']"));
            javaLang.click();
            Assert.assertTrue(javaLang.isSelected());


            // 14. Click to "Sign up" button
            WebElement btn_SignUp=driver.findElement(By.cssSelector("button[id='wooden_spoon']"));
            btn_SignUp.click();

            // 15. Verify text displayed on page
            //     Expected: "Well done!"
            WebElement textOnPage=driver.findElement(By.cssSelector("h4[class='alert-heading']"));
            String actualText=textOnPage.getText();
            String expectedText="Well done!";
            Assert.assertTrue(actualText.equals(expectedText));

        }

        @AfterMethod
    public void tearDown(){
        //driver.quit();
        }


}
