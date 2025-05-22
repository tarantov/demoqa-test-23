import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 5000; // default 4000
    }

    @Test
    void fillFormTest() {
        open("/text-box");
        $("#userName").setValue("Test");
        $("#userEmail").setValue("test@test.com");
        $("#currentAddress").setValue("test street #1");
        $("#permanentAddress").setValue("test street #2");
        $("#submit").click();

        $("#output #name").shouldHave(text("Test"));
        $("#output #email").shouldHave(text("est@test.com"));
        $("#output #currentAddress").shouldHave(text("est street #1"));
        $("#output #permanentAddress").shouldHave(text("test street #2"));
    }
}