package day10_upload_actions_jsexecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.BrowserUtils;
import utilities.ConfigurationReader;
import utilities.Driver;

public class T3_Hover_Test {
    @Test
    public void hover_test(){
        Driver.getDriver().get(ConfigurationReader.getProperty("Hover_URL"));
        //It doesn't mine where the image is but it get index based
       // (//img)[3]
        //div[@class='example']/div[1] --> i chosen

        WebElement img_1_Element=Driver.getDriver().findElement(By.xpath("(//img)[1]"));
        WebElement img_2_Element=Driver.getDriver().findElement(By.xpath("(//img)[2]"));
        WebElement img_3_Element=Driver.getDriver().findElement(By.xpath("(//img)[3]"));


        WebElement text_1_elem=Driver.getDriver().findElement(By.xpath("(//h5)[1]"));
        // we can use this text() locator as well -->//h5[text()='name: user1']
        WebElement text_2_elem=Driver.getDriver().findElement(By.xpath("(//h5)[2]"));
        WebElement text_3_elem=Driver.getDriver().findElement(By.xpath("(//h5)[3]"));

        // To be able to hover on images, we need to create object,
        //and pass 'driver' in the constructor

        Actions actions=new Actions(Driver.getDriver());

        //2. Hover over to first image
        BrowserUtils.sleep(3);
        actions.moveToElement(img_1_Element).perform();

        //3. Assert:
        //a. “name: user1” is displayed
        Assert.assertTrue(text_1_elem.isDisplayed());

        //4. Hover over to second image
        BrowserUtils.sleep(3);
        actions.moveToElement(img_2_Element).perform();

        //5. Assert:
        //a. “name: user2” is displayed
        Assert.assertTrue(text_2_elem.isDisplayed());

        //6. Hover over to third image
        BrowserUtils.sleep(3);
        actions.moveToElement(img_3_Element).perform();
        //7. Assert:
        //a. “name: user3” is displayed
        Assert.assertTrue(text_3_elem.isDisplayed());

        Driver.closeDriver();

    }

}
/*
TC #3: Hover Test
1. Go to https://practice.cydeo.com/hovers
2. Hover over to first image
3. Assert:
a. “name: user1” is displayed
4. Hover over to second image
5. Assert:
a. “name: user2” is displayed
6. Hover over to third image
7. Confirm:
a. “name: user3” is displayed
 */