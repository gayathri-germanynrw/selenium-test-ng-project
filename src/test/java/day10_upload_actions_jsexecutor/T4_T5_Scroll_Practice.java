package day10_upload_actions_jsexecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.ConfigurationReader;
import utilities.Driver;

public class T4_T5_Scroll_Practice {
    @Test
    public void scroll_practice() {
        Driver.getDriver().get(ConfigurationReader.getProperty("Cydeo_Practice_URL"));

        // 3- Scroll down to “Powered by CYDEO”
        WebElement cydeoLink = Driver.getDriver().findElement(By.linkText("CYDEO"));

        // 4- Scroll using Actions class “moveTo(element)” method

        // To be able to hover on images, we need to create object,
        //and pass 'driver' in the constructor
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(cydeoLink);

        // Task 5 --> Page Up
        actions.sendKeys(Keys.PAGE_UP, Keys.PAGE_UP).perform();
    }
}
/*
TC #4: Scroll practice
1- Open a chrome browser
2- Go to: https://practice.cydeo.com/
3- Scroll down to “Powered by CYDEO”
4- Scroll using Actions class “moveTo(element)” method


TC #5: Scroll practice 2
1- Continue from where the Task 4 is left in the same test.
2- Scroll back up to “Home” link using PageUP button

 */
