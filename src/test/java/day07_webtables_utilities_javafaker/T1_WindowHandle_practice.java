package day07_webtables_utilities_javafaker;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.Set;

public class T1_WindowHandle_practice {
    WebDriver driver;

    //TC #1: Window Handle practice
    //1. Create new test and make set ups
    //2. Go to : https://www.amazon.com
    @Test
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.amazon.com");
    }

    @Test
    public void window_handling_test() {
        //3. Copy paste the lines from below into your class
        ((JavascriptExecutor) driver).executeScript("window.open('http://google.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('http://etsy.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('http://facebook.com','_blank');");
        Set<String> allWindowHandles = driver.getWindowHandles();

        for (String eachWindow : allWindowHandles) {
            driver.switchTo().window(eachWindow);
            System.out.println("Current URL :" + driver.getCurrentUrl());
            //4. Create a logic to switch to the tab where Etsy.com is open
            if (driver.getCurrentUrl().contains("etsy")) {
                break;
            }
        }
        //5. Assert: Title contains “Etsy”

        String actualTitle = driver.getTitle();
        String expectedTitle = "Etsy";

        Assert.assertTrue(actualTitle.contains(expectedTitle));

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
/*

TC #1: Window Handle practice
1. Create new test and make set ups
2. Go to : https://www.amazon.com
3. Copy paste the lines from below into your class
4. Create a logic to switch to the tab where Etsy.com is open
5. Assert: Title contains “Etsy”
Lines to be pasted:
((JavascriptExecutor) driver).executeScript("window.open('http://google.com','_blank');");
((JavascriptExecutor) driver).executeScript("window.open('http://etsy.com','_blank');");
((JavascriptExecutor) driver).executeScript("window.open('http://facebook.com','_blank');");
These lines will simply open new tabs using something called JavascriptExecutor
and get those pages. We will learn JavascriptExecutor later as well.
 */