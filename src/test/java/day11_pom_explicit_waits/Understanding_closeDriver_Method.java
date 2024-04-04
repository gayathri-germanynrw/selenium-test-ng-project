package day11_pom_explicit_waits;

import org.testng.annotations.Test;
import utilities.Driver;

import java.awt.dnd.DragGestureEvent;

public class Understanding_closeDriver_Method {

    @Test
    public void test1(){
        Driver.getDriver().get("https://google.com");
        //Driver.getDriver().quit();
        //Driver.getDriver().close();
        Driver.closeDriver();
    }

    @Test
    public void test2(){
        Driver.getDriver().get("https://google.com");
    }

    @Test
    public void test3(){
        Driver.getDriver().get("https://google.com");
    }
}
