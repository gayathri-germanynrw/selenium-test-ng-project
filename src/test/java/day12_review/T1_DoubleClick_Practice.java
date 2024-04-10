package day12_review;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.W3Page;
import utilities.BrowserUtils;
import utilities.Driver;

public class T1_DoubleClick_Practice {
    @Test
    public void doubleClick_test() {
        //TC #1: Double Click Test
        //1. Go to
        //https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblcli
        //ck2
        Driver.getDriver().get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2");
        BrowserUtils.sleep(3);
        //WebElement iframe_acceptAll_Elem=Driver.getDriver().findElement(By.xpath("//iframe[@name='cnftComm']"));
       // Driver.getDriver().switchTo().frame(iframe_acceptAll_Elem);
//        WebElement acpt_choice=Driver.getDriver().findElement(By.xpath("//div[@class='sn-v-table']/div[@id='accept-choices']"));
//        acpt_choice.click();
//        Driver.getDriver().switchTo().parentFrame();

        //2. Switch to iframe.
        //3. Double click on the text “Double-click me to change my text color.”
        Driver.getDriver().switchTo().frame("iframeResult");
        W3Page w3page=new W3Page();
        // Using Actions object to be able to 'double-Click ' to the given WebElement.
        Actions actions=new Actions(Driver.getDriver());
        actions.doubleClick(w3page.paragraph).perform();

        // Assert: Text’s “style” attribute value contains “red”.
        //NOTE: FOLLOW POM
        String actualStyleAttributeVal=w3page.paragraph.getAttribute("style");
        String expectedInAttributeVal="red";
        Assert.assertTrue(actualStyleAttributeVal.contains(expectedInAttributeVal));

    }
}
/*
TC #1: Double Click Test
1. Go to
https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblcli
ck2
2. Switch to iframe.
3. Double click on the text “Double-click me to change my text color.”
4. Assert: Text’s “style” attribute value contains “red”.
NOTE: FOLLOW POM
 */
