package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Driver {

    // private constructor to remove access of this object
    private Driver(){}

    // private WebDriver, because we want to close access from outside the class
    // we are making it as static , because we will use it in a static method.
    private static WebDriver driver;
    public static WebDriver getDriver(){
        if (driver==null){
            /* We will read our browserType from configuration.properties file
            * This way , we can control which  browser is opened from outside our code.
            * */
            String browserType=ConfigurationReader.getProperty("browser");
            switch(browserType){
                case "chrome":
                    driver= new ChromeDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;
                case "firefox":
                    driver = new FirefoxDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;
                }

        }
        return driver;
    }

    /*
    Create a new Driver.closeDriver(); It will use .quit() method to quit browsers.
    and then set driver value is null.
     */

    public static void closeDriver(){
        if(driver!=null){
            /*
            This line will terminate the currently existing
            driver completely. It will not exist going forward.
             */
            driver.quit();
            // instead of non-existence , we have to assign null.
            // We assign the value back to "null" so that my "Singleton" can create a newer one if added.
            driver=null;
        }

    }


}
