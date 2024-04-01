package day09_review_javafaker_driverUtil;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.BrowserUtils;
import utilities.ConfigurationReader;

public class T1_Bing_Search extends TestBase {
    @Test
    public void bing_search() {
        driver.get(ConfigurationReader.getProperty("BING_URL"));
        //3- Write “apple” in search box
        WebElement searchElem=driver.findElement(By.xpath("//textarea[@id='sb_form_q']"));
        BrowserUtils.sleep(2);
        searchElem.sendKeys(ConfigurationReader.getProperty("searchValue")+ Keys.ENTER);
       // driver.findElement(By.xpath("//button[@id='bnp_btn_reject']")).click();
        BrowserUtils.sleep(2);
        BrowserUtils.verifyTitleContains(driver,"apple - Search");
    }
}
/*
TC #1: Bing search
1- Open a chrome browser
2- Go to: https://bing.com
3- Write “apple” in search box
4- Verify title:
Expected: apple - Search
Use `configuration.properties` for the following:
1. The browser type
2. The URL
3. The search keyword
4. Make title verification dynamic. If search value changes, title
assertion should not fail.
 */