package day11_pom_explicit_waits;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DynamicLoad7Page;
import utilities.Driver;

import java.time.Duration;

public class T10_Dynamically_LoadedPage_Elements {
    //TC#10 : Dynamically Loaded Page Elements 7
    //1. Go to https://practice.cydeo.com/dynamic_loading/7
    @Test
    public void t10_dynamic_loadPage() {
        Driver.getDriver().get("https://practice.cydeo.com/dynamic_loading/7");
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        //2. Wait until title is “Dynamic title”
        String expectedTitle = "Dynamic title";
        wait.until(ExpectedConditions.titleIs(expectedTitle));
        //3. Assert: Message “Done” is displayed.

        DynamicLoad7Page dynamicLoad7Page = new DynamicLoad7Page();

        dynamicLoad7Page.msg_Done_Element.getText();
        Assert.assertTrue(dynamicLoad7Page.msg_Done_Element.isDisplayed());
        //4. Assert: Image is displayed.
        Assert.assertTrue(dynamicLoad7Page.img_Element.isDisplayed());
        //Note: Follow POM
    }
}

/*
TC#10 : Dynamically Loaded Page Elements 7
1. Go to https://practice.cydeo.com/dynamic_loading/7
2. Wait until title is “Dynamic title”
3. Assert: Message “Done” is displayed.
4. Assert: Image is displayed.
Note: Follow POM
 */