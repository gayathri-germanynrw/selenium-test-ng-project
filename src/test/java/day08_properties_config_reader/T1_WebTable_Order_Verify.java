package day08_properties_config_reader;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T1_WebTable_Order_Verify extends TestBase {
    @Test
    public void order_verify_name_test(){
        driver.get("https://practice.cydeo.com/web-tables");
        //2. Verify Bob’s name is listed as expected.
        //Expected: “Bob Martin”
        WebElement txtElement=driver.findElement(By.xpath(" //table[@id='ctl00_MainContent_orderGrid']//td[.='Bob Martin']"));
        String actualTxt=txtElement.getText();
        System.out.println("actualTxt = " + actualTxt);
        String expectedTxt="Bob Martin";
        Assert.assertEquals(actualTxt,expectedTxt);

        //3. Verify Bob Martin’s order date is as expected
        //Expected: 12/31/2021

        // ex1: Move to parent element and come back to 'date' cell
        //WebElement dateElement=driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//td[.='Bob Martin']/../td[5]"));

        // ex2: following-sibling::td[3]
        WebElement dateElement=driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//td[.='Bob Martin']/following-sibling::td[3]"));

        String actualDateTxt=dateElement.getText();
        String expectedDateText="12/31/2021";
        Assert.assertEquals(actualDateTxt,expectedDateText);
    }
    @Test
    public void order_verify_name_test2(){
        driver.get("https://practice.cydeo.com/web-tables");
        //2. Verify Bob’s name is listed as expected.
        //Expected: “Bob Martin”
        WebElement txtElement=driver.findElement(By.xpath(" //table[@id='ctl00_MainContent_orderGrid']//td[.='Bob Martin']"));
        String actualTxt=txtElement.getText();
        System.out.println("actualTxt = " + actualTxt);
        String expectedTxt="Bob Martin";
        Assert.assertEquals(actualTxt,expectedTxt);

        // Call Utility method
       String date_from_Customer= T2_WebTableUtils.returnOrderDate(driver,"Alexandra Gray");
        System.out.println("date_from_Customer = " + date_from_Customer);
        T2_WebTableUtils.orderVerify(driver,"Alexandra Gray",date_from_Customer);
    }

    @Test
    public void test3(){
        driver.get("https://practice.cydeo.com/web-tables");
        T2_WebTableUtils.order_Verify(driver,"Bob Martin","12/31/2021");
    }


}

/*
TC #1: Web table practice
1. Go to: https://practice.cydeo.com/web-tables
2. Verify Bob’s name is listed as expected.
Expected: “Bob Martin”
3. Verify Bob Martin’s order date is as expected
Expected: 12/31/2021
 */