package day05_testNG_intro_dropdowns;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class T4_CydeoTitleVerfication {

    //        TC #4: Cydeo Title Verification
//        1.Open Chrome browser
    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        2.Go to https://www.cydeo.com
        driver.get("https://www.cydeo.com/");

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testTitle() {
//        3.Verify title:
        // Expected Title: "Cydeo"
        String actualTitle = driver.getTitle();
        String expectedTitle = "Cydeo";
        Assert.assertEquals(actualTitle, expectedTitle);
    }

}
