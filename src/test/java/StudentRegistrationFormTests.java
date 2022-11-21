import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.TestBase;

import java.io.File;
import java.util.Locale;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class StudentRegistrationFormTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
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

    @Test
    void fillOnlyRequiredFields() {
        registrationPage.openPage()
                .setFirstName(firstname)
                .setLastName(lastName)
                .setUserEmail(email)
                .setGender(gender)
                .setPhone(phoneNumber)
                .setDateOfBirth(day, month, year)
                .setSubject(subj)
                .setHobby(hobby)
                .uploadPicture(picture)
                .setCurrentAddress(address)
                .setState(state)
                .setCity(city)
                .submit();

        registrationPage
                .verifyResults("Student Name", firstname +" " +lastName)
                .verifyResults("Student Email", email)
                .verifyResults("Gender", "Male")
                .verifyResults("Mobile", phoneNumber)
                .verifyResults("Date of Birth", day + " " + month + "," + year)
                .verifyResults("Subjects", subj)
                .verifyResults("Hobbies", hobby)
                .verifyResults("Picture", picture.getName())
                .verifyResults("Address", address)
                .verifyResults("State and City", state + " " + city);
    }
}
