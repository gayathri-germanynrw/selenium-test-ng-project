package day10_upload_actions_jsexecutor;

import org.testng.annotations.Test;
import utilities.Driver;

public class T6_Scroll_JavaScriptExecutor {
    @Test
    public void scroll_JavaScript_Exe(){
        Driver.getDriver().get("https://practice.cydeo.com/infinite_scroll");
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
