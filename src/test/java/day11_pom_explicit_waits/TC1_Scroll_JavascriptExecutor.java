package day11_pom_explicit_waits;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.BrowserUtils;
import utilities.Driver;

public class TC1_Scroll_JavascriptExecutor {
    @Test
    public void scroll_test(){
        Driver.getDriver().get("https://practice.cydeo.com/large");

        WebElement cydeoLink_Elem=Driver.getDriver().findElement(By.linkText("CYDEO"));
        System.out.println("cydeoLink_Elem.getText() = " + cydeoLink_Elem.getText());

        WebElement homeLink_Elem=Driver.getDriver().findElement(By.linkText("Home"));
        System.out.println("homeLink_Elem.getText() = " + homeLink_Elem.getText());

        //3- Scroll down to “Cydeo” link

        JavascriptExecutor je= (JavascriptExecutor) Driver.getDriver();
        BrowserUtils.sleep(2);
        je.executeScript("arguments[0].scrollIntoView(true)",cydeoLink_Elem,homeLink_Elem);

        //4- Scroll up to “Home” link
        BrowserUtils.sleep(2);
        je.executeScript("arguments[1].scrollIntoView(true)",cydeoLink_Elem,homeLink_Elem);

        Driver.closeDriver();
    }



}
/*
TC #1: Scroll using JavascriptExecutor
1- Open a chrome browser
2- Go to: https://practice.cydeo.com/large
3- Scroll down to “Cydeo” link
4- Scroll up to “Home” link
5- Use below provided JS method only
JavaScript method to use : arguments[0].scrollIntoView(true)
Note: You need to locate the links as web elements and pass them as
arguments into executeScript() method
 */