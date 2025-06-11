import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestRegistationForm {

    String imageName = "images/Ninja.jpeg";
    String firstName = "Mike";
    String lastName = "Tarantov";

    @BeforeAll
    static void BeforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = false;
        Configuration.timeout = 5000; // default 4000
    }

    @Test
    void FullForm() {
        open("/automation-practice-form");
        $("#firstName").setValue("Mike");
        $("#lastName").setValue("Tarantov");
        $("#userEmail").setValue("mike@tarantov.com");
        //Пол
        // <label title for="gender-radio-1" class="custom-control-label">
        //$("#gender-radio-1").parent().$(byText("Male")).click();
        $(byText("Male")).click();
        $("#userNumber").setValue("0987654321");

        //Дата, клик по дате
        $("#dateOfBirthInput").click();
        //$(byText("May")).click();
        //$(byText("March")).click();
        $(".react-datepicker__month-select").selectOption("November");
        $(".react-datepicker__year-select").selectOption("1999");
        $(".react-datepicker__day--009").click();
        //Предмет
        $("#subjectsInput").setValue("B").pressEnter();
        $(byText("Reading")).click();
        $("#currentAddress").setValue("Some street 1");
        $("#uploadPicture").uploadFromClasspath(imageName);
        //нужно сделать проверку что фото загружено и отображается название

        //Выбрать страну потом город,
        //Клик по селектору, выбор по тексту
        $("#state").click();
        $(byText("NCR")).click();
        $("#city").click();
        $(byText("Delhi")).click();
        $("#submit").click();


        $(".modal-content").shouldBe(visible);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table").$(byText("Student Name")).sibling(0).shouldHave(text(firstName + " " + lastName));
        $(".table").$(byText("Student Email")).sibling(0).shouldHave(text("mike@tarantov.com"));
        $(".table").$(byText("Gender")).sibling(0).shouldHave(text("Male"));
        $(".table").$(byText("Mobile")).sibling(0).shouldHave(text("0987654321"));
        $(".table").$(byText("Date of Birth")).sibling(0).shouldHave(text("09 November,1999"));
        $(".table").$(byText("Subjects")).sibling(0).shouldHave(text("Biology"));
        $(".table").$(byText("Hobbies")).sibling(0).shouldHave(text("Reading"));
        $(".table").$(byText("Picture")).sibling(0).shouldHave(text("Ninja.jpeg"));
        $(".table").$(byText("Address")).sibling(0).shouldHave(text("Some street 1"));
        $(".table").$(byText("State and City")).sibling(0).shouldHave(text("NCR Delhi"));

        $("#closeLargeModal").click();
    }
}