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

public class T4_Iframes_Practice {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://practice.cydeo.com/iframe");
    }

    @Test
    public void iframe_test() {
        //4. Assert: “Your content goes here.” Text is displayed.
        // We have to switch to iframe to be able to locate web element in there

        // Option#1 : switch Frame using "id" attribute value
       // driver.switchTo().frame("mce_0_ifr");
        // option#2 : switch Frame using "index" number
        driver.switchTo().frame(0);
        // option#3 : switch Frame using WebElement
       // driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']")));

        WebElement iFrame_pgraph_Txt_Elem = driver.findElement(By.tagName("p"));
        Assert.assertTrue(iFrame_pgraph_Txt_Elem.isDisplayed());

        //Assert: “An iFrame containing the TinyMCE WYSIWYG Editor

        driver.switchTo().parentFrame();
        WebElement head_txt = driver.findElement(By.tagName("h3"));
        Assert.assertTrue(head_txt.isDisplayed());


    }


    @AfterMethod
    public void tearDown() {
        //driver.quit();
    }

}

/*
TC #4: Iframe practice
1. Create a new class called: T4_Iframes
2. Create new test and make set ups
3. Go to: https://practice.cydeo.com/iframe
4. Assert: “Your content goes here.” Text is displayed.
5. Assert: “An iFrame containing the TinyMCE WYSIWYG Editor
 */