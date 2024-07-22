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

public class T8_NonSelect_DropDown {
    WebDriver driver;

    //    TC #8: Selecting value from non-select dropdown
//1. Open Chrome browser
//2. Go to https://practice.cydeo.com/dropdown
    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://practice.cydeo.com/dropdown");
    }

    //3. Click to non-select dropdown
    @Test
    public void nonSelect_DropDown() throws InterruptedException {
        WebElement dropDn_NOnselect_Element = driver.findElement(By.xpath("//a[@id='dropdownMenuLink']"));
        Thread.sleep(2000);
        dropDn_NOnselect_Element.click();
        Thread.sleep(2000);
        //4. Select Facebook from dropdown

        WebElement faceBook_NOnselect_Element = driver.findElement(By.xpath("//a[@href='https://www.facebook.com/']"));
        faceBook_NOnselect_Element.click();
        Thread.sleep(2000);

        //5. Verify title is “Facebook - Log In or Sign Up”
        String acualTitle = driver.getTitle();
        System.out.println("acualTitle--->" + acualTitle);
        String expectedTitle = "Facebook - log in or sign up";

        Assert.assertEquals(acualTitle, expectedTitle, "Titles are not equal !");

    }

    @AfterMethod
    public void tearDown() {

        //driver.quit();
    }

}
/*
TC #8: Selecting value from non-select dropdown
1. Open Chrome browser
2. Go to https://practice.cydeo.com/dropdown
3. Click to non-select dropdown
4. Select Facebook from dropdown
5. Verify title is “Facebook - Log In or Sign Up”
 */