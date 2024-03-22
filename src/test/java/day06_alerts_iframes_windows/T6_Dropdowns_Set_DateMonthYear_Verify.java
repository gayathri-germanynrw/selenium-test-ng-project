package day06_alerts_iframes_windows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class T6_Dropdowns_Set_DateMonthYear_Verify {
    //    TC #6: Selecting date on dropdown and verifying
//1. Open Chrome browser
    WebDriver driver;

    //2. Go to https://practice.cydeo.com/dropdown
    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://practice.cydeo.com/dropdown");
    }

    //   3. Select “December 1st, 1933” and verify it is selected.
    //Locate the Dropdowns and pass them in Select object Constructors

    @Test
    public void selectDropDn() throws InterruptedException {
        Select dropDn_Element_Yr = new Select(driver.findElement(By.xpath("//select[@id='year']")));
        Select dropDn_Element_Mon = new Select(driver.findElement(By.xpath("//select[@id='month']")));
        Select dropDn_Element_Day = new Select(driver.findElement(By.xpath("//select[@id='day']")));
        //   Select year using : visible text
        Thread.sleep(2000);
        dropDn_Element_Yr.selectByVisibleText("1933");

        //    Select month using : value attribute
        Thread.sleep(2000);
        dropDn_Element_Mon.selectByValue("11");

        //    Select day using : index number
        Thread.sleep(2000);
        dropDn_Element_Day.selectByIndex(0);

        // create expected values
        String expectedYear = "1933";
        String expectedMonth = "December";
        String expectedDay = "1";

        // Getting actual values from browsr

        String actualYear = dropDn_Element_Yr.getFirstSelectedOption().getText();
        String actualMonth = dropDn_Element_Mon.getFirstSelectedOption().getText();
        String actualDay = dropDn_Element_Day.getFirstSelectedOption().getText();

        // Assertion for verifing the values from the dropdown

        Assert.assertTrue(actualYear.equals(expectedYear));
        Assert.assertEquals(actualMonth, expectedMonth);
        Assert.assertEquals(actualDay, expectedDay);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}

/*
TC #6: Selecting date on dropdown and verifying
1. Open Chrome browser
2. Go to https://practice.cydeo.com/dropdown
3. Select “December 1st, 1933” and verify it is selected.
Select year using : visible text
Select month using : value attribute
Select day using : index number
 */
