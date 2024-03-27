package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CRM_Utilities {
    /*
    This method will log in using below credentials
    @Username:
    @Password:
     */

    public static void login_crm(WebDriver driver,String username,String password){
        WebElement usrElement = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        usrElement.sendKeys(username);

        WebElement passElement = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        passElement.sendKeys(password);

        WebElement btnSubmit = driver.findElement(By.xpath("//input[@value='Log In']"));
        btnSubmit.click();


    }

    public static void login_crm2(WebDriver driver, String username,String password){

    }

}
