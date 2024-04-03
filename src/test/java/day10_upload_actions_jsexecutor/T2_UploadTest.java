package day10_upload_actions_jsexecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.BrowserUtils;
import utilities.ConfigurationReader;
import utilities.Driver;

import java.io.File;

public class T2_UploadTest {
    @Test
    public void uploadFile() {
        Driver.getDriver().get(ConfigurationReader.getProperty("Upload_URL"));
        //2. Find some small file from your computer, and get the path of it.
       /* File file=new File("C:\\Users\\gayat\\OneDrive\\Desktop\\Git Startegy.png");
        Assert.assertTrue(file.exists());*/

        WebElement chooseFile_Elem = Driver.getDriver().findElement(By.xpath("//input[@id='file-upload']"));
        /* We can send "Path" as the sendKeys */
        chooseFile_Elem.sendKeys("C:\\Users\\gayat\\OneDrive\\Desktop\\Git Startegy.png");

        BrowserUtils.sleep(3);

        WebElement btn_upload_Elem = Driver.getDriver().findElement(By.xpath("//input[@id='file-submit']"));
        btn_upload_Elem.click();

        //4. Assert:
        //-File uploaded text is displayed on the page

        WebElement text_Elem = Driver.getDriver().findElement(By.xpath("//div[@id='content']//h3"));
        System.out.println("text_Elem.getText() = " + text_Elem.getText());
        Assert.assertTrue(text_Elem.isDisplayed());
        Driver.closeDriver();
    }

}
/*
TC #2 Upload Test
1. Go to https://practice.cydeo.com/upload
2. Find some small file from your computer, and get the path of it.
3. Upload the file.
4. Assert:
-File uploaded text is displayed on the page
 */