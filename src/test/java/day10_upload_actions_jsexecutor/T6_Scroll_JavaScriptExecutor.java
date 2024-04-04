package day10_upload_actions_jsexecutor;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import utilities.BrowserUtils;
import utilities.Driver;

public class T6_Scroll_JavaScriptExecutor {
    @Test
    public void scroll_JavaScript_Exe() {
        Driver.getDriver().get("https://practice.cydeo.com/infinite_scroll");
        // 3- Use below JavaScript method and scroll
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        BrowserUtils.sleep(3);
        //window.scrollBy(x,y)
        //a. 750 pixels down 10 times.
        for (int i = 0; i < 10; i++) {
            BrowserUtils.sleep(1);
            js.executeScript("window.scrollBy(0,750)");
        }
        BrowserUtils.sleep(1);
        //b. 750 pixels up 10 times

        for (int i = 0; i < 10; i++) {
            BrowserUtils.sleep(1);
            js.executeScript("window.scrollBy(0,-750)");
        }


    }
}
/*
TC #6: Scroll using JavascriptExecutor
1- Open a chrome browser
2- Go to: https://practice.cydeo.com/infinite_scroll
3- Use below JavaScript method and scroll
a. 750 pixels down 10 times.
b. 750 pixels up 10 times
JavaScript method to use : window.scrollBy(0,0)
 */
