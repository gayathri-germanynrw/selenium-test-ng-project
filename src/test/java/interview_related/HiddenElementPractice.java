package interview_related;




import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.Driver;

public class HiddenElementPractice {

    @Test
    public void hidden_element_shadow_root_test(){

        Driver.getDriver().get("https://practice.expandtesting.com/shadowdom");

        WebElement shadowHost = Driver.getDriver().findElement(By.id("shadow-host"));
        SearchContext shadowRoot = shadowHost.getShadowRoot();
        shadowRoot.findElement(By.cssSelector("#my-btn")).click();

    }
}