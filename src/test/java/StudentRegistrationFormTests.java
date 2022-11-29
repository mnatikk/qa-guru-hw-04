import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.TestBase;
import pages.data.StudentRegistrationData;
public class StudentRegistrationFormTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    StudentRegistrationData student = new StudentRegistrationData();

    @Test
    void AllFieldsCityDisabled() {
        registrationPage.openPage()
                .setFirstName(student.getFirstname())
                .setLastName(student.getLastName())
                .setUserEmail(student.getEmail())
                .setGender(student.getGender())
                .setPhone(student.getPhoneNumber())
                .setDateOfBirth(student.getDay(), student.getMonth(), student.getYear())
                .setSubject(student.getSubj())
                .setHobby(student.getHobby())
                .uploadPicture(student.getPicture())
                .setCurrentAddress(student.getAddress())
                .setState(student.getAddress());
        if (registrationPage.isCityEnable()) {
            registrationPage.setState(student.getAddress());
        }
                registrationPage.submit();

        registrationPage
                .verifyResults("Student Name", student.getFirstname() +" " + student.getLastName())
                .verifyResults("Student Email", student.getEmail())
                .verifyResults("Gender", student.getGender())
                .verifyResults("Mobile", student.getPhoneNumber())
                .verifyResults("Date of Birth", student.getDay() + " " + student.getMonth() + "," + student.getYear())
                .verifyResults("Subjects", student.getSubj())
                .verifyResults("Hobbies", student.getHobby())
                .verifyResults("Picture", student.getPicture().getName())
                .verifyResults("Address", student.getAddress());

        if (registrationPage.isCityEnable()) {
            registrationPage.verifyResults("State and City", student.getState() + " " + student.getCity());
        }
    }

}
