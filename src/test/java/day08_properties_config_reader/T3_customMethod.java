package day08_properties_config_reader;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class T3_customMethod extends TestBase {

    @Test
    public void customMethod(){
        driver.get("https://practice.cydeo.com/tables");
        getTableGetEmail(driver,"table2","Tim");
    }

    public void getTableGetEmail(WebDriver driver,String tableNum,String firstName){
        //WebElement tblElement = driver.findElement(By.xpath("//table[@id='" + tableNum + "']//tr/td[.='" + firstName + "']/../td[3]"));
       WebElement tblElement = driver.findElement(By.xpath("//table[@id='" + tableNum + "']//tr/td[text()='" + firstName + "']/../td[3]"));
        System.out.println("Email of given table num and first Name = " + tblElement.getText());

    }
}

/*
TC #3: Create a custom method
1- Open a chrome browser
2- Go to: https://practice.cydeo.com/tables
3- Write custom method:
• Method name: getTableGetEmail()
• Return type: void
• Arg1: WebDriver driver
• Arg2: String tableNum
• Arg3: String firstName
 */