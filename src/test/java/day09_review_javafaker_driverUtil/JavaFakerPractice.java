package day09_review_javafaker_driverUtil;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class JavaFakerPractice {

    @Test
    public void test1() {

        // Create Java Faker object
        Faker faker = new Faker();

        // Print out a random first name using Faker object
        System.out.println("faker.name().firstName() = " + faker.name().firstName());

        // Print out a random last name Faker
        System.out.println("faker.name().lastName() = " + faker.name().lastName());

        // Print out a Full Name from Faker

        System.out.println("faker.name().fullName() = " + faker.name().fullName());
        // Print out a city
        System.out.println("faker.address().city() = " + faker.address().city());

        // Print the Zipcode
        System.out.println("faker.address().zipCode() = " + faker.address().zipCode());

        // numerify() method is used to generate digits with specific formatting
        System.out.println("faker.numerify(\"###-###-####\") = " + faker.numerify("###-###-####"));

        System.out.println("faker.numerify(\"####-####-####-######\") = " + faker.numerify("####-####-####-######"));

        System.out.println("faker.numerify(\"####-####-####-######\") = " + faker.numerify("9999-####-####-######"));

        // letterify() method is used to generate RAndom letters with specific formatting
        System.out.println("faker.letterify(\"????-????-?????\") = " + faker.letterify("????-????-?????"));

        // Bothify() method is used to generate letters and numbers with specific formatting
        System.out.println("faker.bothify(\"???-####-????\") = " + faker.bothify("???-####-????"));

        // ChuckNorris method is used to create chuckNorris facts
        System.out.println("faker.chuckNorris().fact() = " + faker.chuckNorris().fact());
        // Gayathri facts
        System.out.println("faker.Gayathri().fact() = " + faker.chuckNorris().fact()
                .replaceAll("Chuck Norris","Gayathri"));

    }
}
