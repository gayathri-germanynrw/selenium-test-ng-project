package day08_properties_config_reader;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigurationReader;

public class T4_use_config_reader extends TestBase {
    //1- Open a chrome browser
    //2- Go to: https://google.com

    @Test
    public void googleSearch() {
        driver.get(ConfigurationReader.getProperty("URL"));
        driver.findElement(By.xpath("//div[.='Alle akzeptieren']")).click();
        //3- Write “apple” in search box
        // in Google search - name="q" attribute value not at all change
        WebElement searchElem=driver.findElement(By.xpath("//textarea[@class='gLFyf']"));
        searchElem.sendKeys(ConfigurationReader.getProperty("searchValue")+ Keys.ENTER);

        Assert.assertEquals(driver.getTitle(),"apple - Google Suche");
    }

    public void googleSearch_with_properties() {
        driver.get("https://google.com");
        driver.findElement(By.xpath("//div[.='Alle akzeptieren']")).click();
        //3- Write “apple” in search box
        // in Google search - name="q" attribute value not at all change
        WebElement searchElem=driver.findElement(By.xpath("//textarea[@class='gLFyf']"));
        searchElem.sendKeys("apple"+ Keys.ENTER);

        Assert.assertEquals(driver.getTitle(),"apple - Google Suche");
    }
}
/*
TC #4: Google search
1- Open a chrome browser
2- Go to: https://google.com
3- Write “apple” in search box
4- Verify title:
Expected: apple - Google Search
Use `configuration.properties` for the following:
1. The browser type
2. The URL
3. The search keyword
4. Make title verification dynamic. If search value changes, title
assertion should not fail.
 */