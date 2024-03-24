package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class WebDriverFactory {
    public static WebDriver getDriver(String browserName) {
        WebDriver webDriver = null;
        if(browserName.equals("chrome")){
            webDriver= new ChromeDriver();
            webDriver.manage().window().maximize();
            webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
        else if(browserName.equals("firefox")){
            webDriver = new FirefoxDriver();
            webDriver.manage().window().maximize();
            webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
        else{
            System.out.println("Browser not supported");
        }

        return webDriver;
    }

}
