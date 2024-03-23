package day06_alerts_iframes_windows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class T5_Window_Handle {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://practice.cydeo.com/windows");
    }

    @Test
    public void window_Handle_test() throws InterruptedException {
//        4. Assert: Title is “Windows”
        String actualTitle = driver.getTitle();
        String expectedTitle = "Windows";
        Assert.assertEquals(actualTitle, expectedTitle);

        String mainHandle = driver.getWindowHandle();
        System.out.println("mainHandle = " + mainHandle);
        System.out.println("Before click the link title is :" + driver.getTitle());
//        5. Click to: “Click Here” link
        WebElement clickHereLink = driver.findElement(By.linkText("Click Here"));
        //a[.='Click Here']
        clickHereLink.click();
        Thread.sleep(2000);
        System.out.println("After click the link title is :" + driver.getTitle());

//        6. Switch to new Window.
        //driver.getWindowHandles();
        // 1 - windowHandle : mainHandle
        // 2 - windowHandle : 2nd Window
        for (String eachHandle : driver.getWindowHandles()) {
            driver.switchTo().window(eachHandle);
            System.out.println("Current Title while switching windows -->" + driver.getTitle());
        }


//        7. Assert: Title is “New Window”
        String expectedTitleAfterClick = "New Window";
        String actualTitleAfterClick = driver.getTitle();
        Assert.assertEquals(expectedTitleAfterClick, actualTitleAfterClick);

        // if we have to go to main page to continue our test case , we can use mainHandle to switch.
        driver.switchTo().window(mainHandle);
        // Close all the tab use : driver.quit();

    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}

/*

TC #5: Window Handle practice
1. Create a new class called: T5_WindowsPractice
2. Create new test and make set ups
3. Go to : https://practice.cydeo.com/windows
4. Assert: Title is “Windows”
5. Click to: “Click Here” link
6. Switch to new Window.
7. Assert: Title is “New Window”
 */
