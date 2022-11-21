package pages.components;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationResultsModal {
    public void verifyModalAppears() {
        $(".table-responsive").shouldBe(Condition.appear);
        $("#example-modal-sizes-title-lg").shouldHave(Condition.text("Thanks for submitting the form"));
    }

    public void verifyResults(String key, String value) {
        $(".table-responsive").$(byText(key)).parent().shouldHave(Condition.text(value));
    }

}
