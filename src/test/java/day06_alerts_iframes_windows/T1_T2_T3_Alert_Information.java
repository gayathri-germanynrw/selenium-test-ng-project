package day06_alerts_iframes_windows;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class T1_T2_T3_Alert_Information {
    //1. Open browser
    //2. Go to website: http://practice.cydeo.com/javascript_alerts
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://practice.cydeo.com/javascript_alerts");
    }

    //3. Click to “Click for JS Alert” button
    @Test(priority = 2)
    public void alertInfo() throws InterruptedException {

        WebElement infoEle = driver.findElement(By.xpath("//button[.='Click for JS Alert']"));
        //WebElement infoEle=driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));

        infoEle.click();
        Thread.sleep(3000);

        Alert alert = driver.switchTo().alert();
        // Click ok from Alert
        alert.accept();

        // 5. Verify “You successfully clicked an alert” text is displayed.
        Thread.sleep(2000);
        WebElement msgAlert_Element = driver.findElement(By.xpath("//p[@id='result']"));
        //WebElement msgAlert_Element=driver.findElement(By.xpath("//p[.='You successfully clicked an alert']"));
        // Failure message will only be displayed If assertion fails
        Assert.assertTrue(msgAlert_Element.isDisplayed(), "Result text is NOT displayed !");
        // Verify the text
        String actual_Msg_Alert = msgAlert_Element.getText();
        String expected_Msg_Alert = "You successfully clicked an alert";
        Assert.assertEquals(actual_Msg_Alert, expected_Msg_Alert, " Message is same. Test PASSED!");
    }


    @Test(priority = 1)
    public void alertConfirmation() throws InterruptedException {
        // 3. Click to “Click for JS Confirm” button
        WebElement confirm_alert = driver.findElement(By.xpath("//button[.='Click for JS Confirm']"));
        confirm_alert.click();

        //4. Click to OK button from the alert

        Alert alert = driver.switchTo().alert();
        Thread.sleep(2000);
        alert.accept();

        //5. Verify “You clicked: Ok” text is displayed.
        WebElement oK_Msg_Alert = driver.findElement(By.xpath("//p[@id='result']"));
        Assert.assertTrue(oK_Msg_Alert.isDisplayed(), "Result text is NOT displayed !");
        String actual_Txt = oK_Msg_Alert.getText();
        String expected_Txt = "You clicked: Ok";
        Assert.assertEquals(actual_Txt, expected_Txt, " Message is same. Test PASSED!");

    }

    /*
    TC #2: Confirmation alert practice
1. Open browser
2. Go to website: http://practice.cydeo.com/javascript_alerts
3. Click to “Click for JS Confirm” button
4. Click to OK button from the alert
5. Verify “You clicked: Ok” text is displayed.
     */

    @Test
    public void info_Alert() throws InterruptedException {
        // 3. Click to “Click for JS Prompt” button
        WebElement info_alert = driver.findElement(By.xpath("//button[.='Click for JS Prompt']"));
        info_alert.click();
        Thread.sleep(3000);

//        4. Send “hello” text to alert
        // Switch to Alert
        Alert alert = driver.switchTo().alert();
        Thread.sleep(2000);
        alert.sendKeys("hello");
        Thread.sleep(3000);

//        5. Click to OK button from the alert
        alert.accept();
        Thread.sleep(3000);
//        6. Verify “You entered: hello” text is displayed
        WebElement txt_Alert = driver.findElement(By.xpath("//p[@id='result']"));

        Assert.assertTrue(txt_Alert.isDisplayed(), " Message is diaplayed. Test PASSED!");
    }

    /*
    TC #3: Information alert practice
1. Open browser
2. Go to website: http://practice.cydeo.com/javascript_alerts
3. Click to “Click for JS Prompt” button
4. Send “hello” text to alert
5. Click to OK button from the alert
6. Verify “You entered: hello” text is displayed
     */

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}

/*
TC #1: Information alert practice
1. Open browser
2. Go to website: http://practice.cydeo.com/javascript_alerts
3. Click to “Click for JS Alert” button
4. Click to OK button from the alert
5. Verify “You successfully clicked an alert” text is displayed.
 */