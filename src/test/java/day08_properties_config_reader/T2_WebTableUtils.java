package day08_properties_config_reader;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class T2_WebTableUtils {
    public static String returnOrderDate(WebDriver driver,String customerName){
        String locator="//table[@id='ctl00_MainContent_orderGrid']//td[.='"+customerName+"']/following-sibling::td[3]";
        WebElement customerDateCell=driver.findElement(By.xpath(locator));
       return customerDateCell.getText();
    }

    // Method #2
    public static void orderVerify(WebDriver driver,String customerName,
                                   String expectedOrderDate){
        String acutual_Order_Date=returnOrderDate(driver,customerName);
        System.out.println("acutual_Order_Date = inside WebTableUtils --> " + acutual_Order_Date);
        Assert.assertEquals(acutual_Order_Date,expectedOrderDate);
    }

    //instrucor with another method
    public static void order_Verify(WebDriver driver,String customerName,
                                   String expectedOrderDate){
        String locator="//td[.='"+customerName+"']/following-sibling::td[3]";
        WebElement customerDateCell=driver.findElement(By.xpath(locator));
        String acutual_Order_Date=customerDateCell.getText();
        System.out.println("acutual_Order_Date = " + acutual_Order_Date);
        Assert.assertEquals(acutual_Order_Date,expectedOrderDate);
    }



}

/*
TC #2: Web table practice Task1 cont.
1. Create a new class called WebTableUtils.
2. Create two methods to verify order
Method #1 info:
• Name: returnOrderDate ()
• Return type: String
• Arg1: WebDriver driver
• Arg2: String costumerName
This method should accept a costumerName and return the costumer order date
as a String.


Method #2 info:
• Name: orderVerify ()
• Return type: void
• Arg1: WebDriver driver
• Arg2: String costumerName
• Arg3: String expectedOrderDate
This method should accept above mentioned arguments and internally assert
expectedOrderDate matching actualOrderDate.
 */