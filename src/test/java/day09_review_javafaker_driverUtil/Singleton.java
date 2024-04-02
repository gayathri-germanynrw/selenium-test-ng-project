package day09_review_javafaker_driverUtil;

import org.openqa.selenium.WebDriver;

public class Singleton {

    // private constructor to remove access of this object
    private Singleton(){}

    // private static String , because we want to close access from outside the class
    // we are making it as static , because we will use it in a static method.

    // Utility method to return the 'private String' we just created

    private static String word; // By default word is null.

    public static String getWord(){
        if(word==null){
            System.out.println("first time call . Word object is null = " );
            System.out.println("Assigining value to it now .");
            word="something";
        }else{
            System.out.println("Word already has a value .");
        }
   return word;
    }

}
