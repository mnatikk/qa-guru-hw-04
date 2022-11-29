package pages.data;
import com.github.javafaker.Faker;
import lombok.*;

import java.io.File;
import java.util.Locale;

@Getter
//@NoArgsConstructor
//@AllArgsConstructor
public class StudentRegistrationData {
    Faker faker = new Faker(new Locale("ru"));
    Faker fakerEmail = new Faker(new Locale("en"));

    String firstname = faker.name().firstName();
    String lastName = faker.name().lastName();
    String email = fakerEmail.internet().emailAddress();
    String gender = "Male";
    String phoneNumber = faker.phoneNumber().subscriberNumber(10);
    String day = "10";
    String month = "May";
    String year = "1980";
    String subj = "Math";
    String hobby = "Sports";
    File picture = new File("src/test/resources/wall-e.png");
    String address = faker.address().fullAddress();
    String state = "NCR";
    String city = "Delhi";

}
