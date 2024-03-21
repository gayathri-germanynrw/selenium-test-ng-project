package day05_testNG_intro_dropdowns;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestNG_Intro {

   @BeforeClass
   public void setUp() throws Exception {
       WebDriver driver=new ChromeDriver();
       System.out.println("Before class is running");
   }

   @AfterClass
   public void afterClass(){
       //driver.quit();

       System.out.println("After class is running");
   }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Before method is running");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("After method is running");
    }


    @Test (priority =2)
    public void test1(){

       System.out.println("test1 is running");
       // compares and returns true, if it is same.
        Assert.assertEquals("banana","banana");
    }

    @Test (priority =1)
    public void test2(){
        System.out.println("Test 2 is running ----" );
    }

}
