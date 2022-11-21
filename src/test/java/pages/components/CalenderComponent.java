package pages.components;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CalenderComponent {
    public void setDate (String day, String month, String year){
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionContainingText(month);
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__day--" + ("000" + day).substring(day.length())).click();
    }
}
