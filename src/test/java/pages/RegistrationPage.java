package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import pages.components.CalenderComponent;
import pages.components.RegistrationResultsModal;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    private final String TITLE_TEXT = "Student Registration Form";

    CalenderComponent calendar = new CalenderComponent();
    RegistrationResultsModal modal = new RegistrationResultsModal();

    private SelenideElement
            firstname = $("#firstName"),
            lastName = $("#lastName"),
            userEmail = $("#userEmail"),
            gender = $("#genterWrapper"),
            phone = $("#userNumber"),
            subject = $("#subjectsInput"),
            hobby = $("#hobbiesWrapper"),
            picture = $("#uploadPicture"),
            currentAddress = $("#currentAddress"),
            state = $("#react-select-3-input"),
            city = $("#react-select-4-input"),
            submit = $("#submit");


    public RegistrationPage openPage() {
        //открываем форму
        open("https://demoqa.com/automation-practice-form");

        //проверка, что форма открылась, чтобы не ходить во все тесты если завалилась
        $(".practice-form-wrapper").shouldHave(Condition.text(TITLE_TEXT));

        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public RegistrationPage setFirstName(String value){
        firstname.setValue(value);
        return this;
    }

    public RegistrationPage setLastName(String value){
        lastName.setValue(value);
        return this;
    }

    public RegistrationPage setUserEmail(String value){
        userEmail.setValue(value);
        return this;
    }

    public RegistrationPage setGender(String value){
        gender.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setPhone(String value){
        phone.setValue(value);
        return this;
    }

    public RegistrationPage setDateOfBirth(String day, String month, String year){
        calendar.setDate(day, month, year);
        return this;
    }

    public RegistrationPage setSubject(String value){
        subject.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage setHobby(String value){
        hobby.$(byText(value)).click();
        return this;
    }

    public RegistrationPage uploadPicture(File file){
        picture.uploadFile(file);
        return this;
    }

    public RegistrationPage setCurrentAddress(String value){
        currentAddress.setValue(value);
        return this;
    }

    public RegistrationPage setState(String value){
        state.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage setCity(String value){
        city.setValue(value).pressEnter();
        return this;
    }

    public void submit(){
        submit.pressEnter();
    }

    public RegistrationPage verifyModalAppears(){
        modal.verifyModalAppears();
        return this;
    }

    public RegistrationPage verifyResults(String key, String value){
        modal.verifyResults(key, value);
        return this;
    }


}
