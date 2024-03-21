package day05_testNG_intro_dropdowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class T5_Dropdown_Simple_StateSelection {
//    TC#5: Verifying “Simple dropdown” and “State selection” dropdown
//    default values
//1. Open Chrome browser
    WebDriver driver;
@BeforeMethod
public void setUpMethod() {
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//2. Go to https://practice.cydeo.com/dropdown

    driver.get("https://practice.cydeo.com/dropdown");

}

    @AfterMethod
    public void tearDown() {
       // driver.quit();
    }

    //3. Verify “Simple dropdown” default selected value is correct
    //    Expected: “Please select an option”
@Test (priority =2)
public void testDropDown() {
 WebElement  drop_Simple_element = driver.findElement(By.xpath("//select[@id='dropdown']"));
Select select=new Select(drop_Simple_element);

// Actual Default Value
String actualDefaultValue = select.getFirstSelectedOption().getText();
// Expected Default Value
    String expectedDefaultValue = "Please select an option";
    Assert.assertEquals(actualDefaultValue,actualDefaultValue);

}


@Test (priority =1)
public void testStateDrpDown(){
    //    4. Verify “State selection” default selected value is correct
//    Expected: “Select a State”

    WebElement  drop_State_element = driver.findElement(By.xpath(" //select[@id='state']"));
    Select select_state=new Select(drop_State_element);

// Actual Default Value
    String actual_state_defVal = select_state.getFirstSelectedOption().getText();
// Expected Default Value
    String expected_state_defVal = "Select a State";
    Assert.assertEquals(actual_state_defVal,expected_state_defVal);
}



}
