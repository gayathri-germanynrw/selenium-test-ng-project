package review.day4_5_6;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

public class Alerts_Practice {
    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        // 1. Open Chrome browser
        driver= WebDriverFactory.getDriver("chrome");
        // 2. Go to website: https://practice.cydeo.com/javascript_alerts
        driver.get("https://practice.cydeo.com/javascript_alerts");
    }

    // 3. Click to “Click for JS Prompt” button
    @Test
    public void jsPrompt() throws InterruptedException {
        WebElement jsElement=driver.findElement(By.xpath("//button[.='Click for JS Prompt']"));
        jsElement.click();

        // Switch to accept button
        // 4. Send “hello” text to alert
        Alert alert=driver.switchTo().alert();
        Thread.sleep(3000);
        alert.sendKeys("hello");
        Thread.sleep(5000);
        // 5. Click to OK button from the alert
        alert.accept();

        // 6. Verify “You entered: hello” text is displayed.
        WebElement resText=driver.findElement(By.xpath("//p[@id='result']"));
        String actualText=resText.getText();
        String expectedText="You entered: hello";
        Assert.assertEquals(actualText,expectedText);
  }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
