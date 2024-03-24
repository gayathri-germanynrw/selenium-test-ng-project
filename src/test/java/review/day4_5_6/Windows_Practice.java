package review.day4_5_6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.Set;

public class Windows_Practice {
    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        //    1. Open browser
        driver= WebDriverFactory.getDriver("chrome");
        //    2. Go to website: https://demoqa.com/browser-windows
        driver.get("https://demoqa.com/browser-windows");
    }
    @Test
    public void windowsTask() throws InterruptedException {

        String mainWindow=driver.getWindowHandle();
        //    3. Click on New Tab button
        WebElement newtab_Element=driver.findElement(By.id("tabButton"));
        newtab_Element.click();
        Thread.sleep(3000);
        //    4. Click on New Window button
        WebElement windowBtn=driver.findElement(By.id("windowButton"));
        windowBtn.click();
        Thread.sleep(3000);

        //    5. Click on New Window Message button
        WebElement messageWindowButton=driver.findElement(By.id("messageWindowButton"));
        messageWindowButton.click();
        Thread.sleep(3000);

        //    6. Print out each window title

        Set<String>  allWindowHandles=driver.getWindowHandles();
        for (String eachWindow: allWindowHandles){
            driver.switchTo().window(eachWindow);
            System.out.println("driver.getTitle() = " + driver.getTitle());
            System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());

        }
        driver.switchTo().window(mainWindow);

    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }





}
