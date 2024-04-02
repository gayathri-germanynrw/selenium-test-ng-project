package day09_review_javafaker_driverUtil;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import utilities.BrowserUtils;
import utilities.ConfigurationReader;
import utilities.Driver;

public class T2_DriverUtil_Practice {
    @Test
    public void bing_search() {
        // Driver.getDriver() --> will return me the "driver"
        Driver.getDriver().get(ConfigurationReader.getProperty("BING_URL"));
        //3- Write “apple” in search box
        WebElement searchElem=Driver.getDriver().findElement(By.xpath("//textarea[@id='sb_form_q']"));
        BrowserUtils.sleep(2);
        searchElem.sendKeys(ConfigurationReader.getProperty("searchValue")+ Keys.ENTER);
        // driver.findElement(By.xpath("//button[@id='bnp_btn_reject']")).click();
        BrowserUtils.sleep(2);
        BrowserUtils.verifyTitleContains(Driver.getDriver(),"apple - Search");
    }



    @Test
    public void bing_search_test2() {
        // Driver.getDriver() --> will return me the "driver"
        Driver.getDriver().get(ConfigurationReader.getProperty("BING_URL"));
        //3- Write “apple” in search box
        WebElement searchElem=Driver.getDriver().findElement(By.xpath("//textarea[@id='sb_form_q']"));
        BrowserUtils.sleep(2);
        searchElem.sendKeys(ConfigurationReader.getProperty("searchValue")+ Keys.ENTER);
        // driver.findElement(By.xpath("//button[@id='bnp_btn_reject']")).click();
        BrowserUtils.sleep(2);
        BrowserUtils.verifyTitleContains(Driver.getDriver(),"apple - Search");
    }
    @AfterMethod
    public void tearDown(){
        /* We won't be using the Selenium's quit method directly anymore.
        Driver.getDriver().quit(); --> No more using this method

        We will use Driver.closeDriver();
         */
        Driver.closeDriver();
    }
}
