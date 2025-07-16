package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.files.DownloadActions.click;

public class RegistrationPage {

    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInpit = $("#lastName"),
            EmailInput = $("#userEmail"),
            GenderLocator = $("#genterWrapper"),
            numberInput = $("#userNumber");


    public RegistrationPage openPage() {
        open("/automation-practice-form");
        return this;
    }

    public RegistrationPage setfirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInpit.setValue(value);
        return this;
    }

    public RegistrationPage setEmail(String value) {
        EmailInput.setValue(value);
        return this;
    }

    public RegistrationPage setGender(String value) {
        GenderLocator.$(byText("Male")).click();
        return this;
    }

    public RegistrationPage setNumber(String value) {
        GenderLocator.setValue(value);
        return this;
    }
    public RegistrationPage setBirthDate(String day, String monrh, String year) {
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("November");
        $(".react-datepicker__year-select").selectOption("1999");
        $(".react-datepicker__day--009").click();
        return this;
    }
}
