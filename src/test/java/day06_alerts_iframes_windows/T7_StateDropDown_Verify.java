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

public class T7_StateDropDown_Verify {
    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://practice.cydeo.com/dropdown");
    }


    @Test
    public void dropDn_Select_State() throws InterruptedException {
        //3. Select Illinois
        Select select_Illinois=new Select(driver.findElement(By.xpath("//select[@id='state']")));
        select_Illinois.selectByValue("IL");
        Thread.sleep(2000);
       // 4. Select Virginia
        Select select_Virginia=new Select(driver.findElement(By.xpath("//select[@id='state']")));
        select_Virginia.selectByVisibleText("Virginia");
        Thread.sleep(2000);
        //5. Select California
        Select select_California=new Select(driver.findElement(By.xpath("//select[@id='state']")));
        select_California.selectByVisibleText("California");
        Thread.sleep(2000);



        // Getting actual values from browser
//       String actual_Illinois=select_Virginia.getFirstSelectedOption().getText();
//        System.out.println("actual_Illinois==="+actual_Illinois);
//       String actual_Virginia=select_Virginia.getFirstSelectedOption().getText();
//        System.out.println("actual_Virginia==="+actual_Virginia);
       String actual_California=select_California.getFirstSelectedOption().getText();
        System.out.println("actual_California==="+actual_California);

        // create expected values
//        String expected_Illinois="Illinois";
//        String expected_Virginia="Virginia";
        String expected_California="California";

        // Assertion to verify the values

//        Assert.assertTrue(actual_Illinois.equals(expected_Illinois));
//        Assert.assertEquals(actual_Virginia, expected_Virginia);
        Assert.assertEquals(actual_California, expected_California);

   }





    @AfterMethod
    public void tearDown() {
       // driver.quit();
    }
}


/*

TC #7: Selecting state from State dropdown and verifying result
1. Open Chrome browser
2. Go to http://practice.cybertekschool.com/dropdown
3. Select Illinois
4. Select Virginia
5. Select California
6. Verify final selected option is California.
Use all Select options. (visible text, value, index)
 */