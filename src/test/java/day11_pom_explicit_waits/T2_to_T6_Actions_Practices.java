package day11_pom_explicit_waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.BrowserUtils;
import utilities.Driver;

import javax.swing.*;

public class T2_to_T6_Actions_Practices {

    @BeforeMethod
    public void beforeMethod(){
        //1. Go to https://practice.cydeo.com/drag_and_drop_circles
        Driver.getDriver().get("https://practice.cydeo.com/drag_and_drop_circles");
    }


    @Test
    public void T2_dragAnddrop_Verify(){
        // TC2 #: Drag and drop default value verification

        //2. Verify big circle default text is as below.
        WebElement bigCicle_Elem=Driver.getDriver().findElement(By.xpath("//div[@id='droptarget']"));
        System.out.println("bigCicle_Elem.getText() = " + bigCicle_Elem.getText());
        //3. Assert:
        //-Text in big circle changed to: “Drag the small circle here.”
        String expectedStr="Drag the small circle here.";
        BrowserUtils.verify_ActualStr_ExpectedStr_Same(bigCicle_Elem.getText(),expectedStr);
      /*-----------------------------------------------------------------------------------------*/

    }
    @Test
    public void T3_dragAnddrop_small_Circle()
    {
        //TC3 #: Drag and drop into the big circle
        //2. Drag and drop the small circle to bigger circle.
        WebElement smallCircle_Elem=Driver.getDriver().findElement(By.xpath("//div[@id='draggable']"));
        WebElement bigCicle_Elem=Driver.getDriver().findElement(By.xpath("//div[@id='droptarget']"));
        Actions actions=new Actions(Driver.getDriver());
        actions.dragAndDrop(smallCircle_Elem,bigCicle_Elem).perform();
        BrowserUtils.sleep(3);
        //3. Assert:
        //-Text in big circle changed to: “You did great!”
        String expectedStr="You did great!";
        BrowserUtils.verify_ActualStr_ExpectedStr_Same(bigCicle_Elem.getText(),expectedStr);
      }
    /*-----------------------------------------------------------------------------------------*/
    @Test
    public void T4_Click_And_Hold(){
        //TC4 #: Click and hold
        //2. Click and hold the small circle.
        WebElement smallCircle_Elem=Driver.getDriver().findElement(By.xpath("//div[@id='draggable']"));
        WebElement bigCicle_Elem=Driver.getDriver().findElement(By.xpath("//div[@id='droptarget']"));
        Actions actions=new Actions(Driver.getDriver());

        WebElement cydeoLink_Elem=Driver.getDriver().findElement(By.linkText("CYDEO"));
        actions.clickAndHold(smallCircle_Elem)
                        .pause(1000)
                                .moveToElement(cydeoLink_Elem)
                                        .pause(1000)
                                                .perform();


        //3. Assert:
        //-Text in big circle changed to: “Drop here.”
        String expectedStr="Drop here.";
        BrowserUtils.verify_ActualStr_ExpectedStr_Same(bigCicle_Elem.getText(),expectedStr);
    }
    /*---------------------------------------------------------------------*/
    @Test
    public void T5_DragAndDrop_Outside_BigCircle(){
        //TC5 #: Drag and drop outside of the big circle
        //2. Drag and drop the small circle to bigger circle.
        WebElement smallCircle_Elem=Driver.getDriver().findElement(By.xpath("//div[@id='draggable']"));
        WebElement bigCicle_Elem=Driver.getDriver().findElement(By.xpath("//div[@id='droptarget']"));
        Actions actions=new Actions(Driver.getDriver());

        WebElement homeLink_Elem=Driver.getDriver().findElement(By.linkText("Home"));
        actions.dragAndDrop(smallCircle_Elem,homeLink_Elem)
                .pause(1000)
                .perform();
        BrowserUtils.sleep(3);

        //3. Assert:
        //-Text in big circle changed to: “Try again!”
        String expectedStr="Try again!";
        BrowserUtils.verify_ActualStr_ExpectedStr_Same(bigCicle_Elem.getText(),expectedStr);
    }
    /*----------------------------------------------------------------*/

    @Test
    public void T6_Drag_Hover(){
      //TC6 #: Drag and hover
        //2. Drag the small circle on top of the big circle, hold it, and verify.
        WebElement smallCircle_Elem=Driver.getDriver().findElement(By.xpath("//div[@id='draggable']"));
        WebElement bigCicle_Elem=Driver.getDriver().findElement(By.xpath("//div[@id='droptarget']"));
        Actions actions=new Actions(Driver.getDriver());
        actions.clickAndHold(smallCircle_Elem).pause(1000)
                .moveToElement(bigCicle_Elem)
                .pause(1000)
                .perform();
        //3. Assert:
        //-Text in big circle changed to: “Now drop...”
        String expectedStr="Now drop...";
        BrowserUtils.verify_ActualStr_ExpectedStr_Same(bigCicle_Elem.getText(),expectedStr);
    }

    @AfterMethod
    public void tearDownMethod(){
        Driver.closeDriver();
    }


}
/*
TC2 #: Drag and drop default value verification
1. Go to https://practice.cydeo.com/drag_and_drop_circles
2. Verify big circle default text is as below.
3. Assert:
-Text in big circle changed to: “Drag the small circle here.”
TC3 #: Drag and drop into the big circle
1. Go to https://practice.cydeo.com/drag_and_drop_circles
2. Drag and drop the small circle to bigger circle.
3. Assert:
-Text in big circle changed to: “You did great!”
TC4 #: Click and hold
1. Go to https://practice.cydeo.com/drag_and_drop_circles
2. Click and hold the small circle.
3. Assert:
-Text in big circle changed to: “Drop here.”

TC5 #: Drag and drop outside of the big circle
1. Go to https://practice.cydeo.com/drag_and_drop_circles
2. Drag and drop the small circle to bigger circle.
3. Assert:
-Text in big circle changed to: “Try again!”

TC6 #: Drag and hover
1. Go to https://practice.cydeo.com/drag_and_drop_circles
2. Drag the small circle on top of the big circle, hold it, and verify.
3. Assert:
-Text in big circle changed to: “Now drop...”
 */