import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class testAuthorization {

    @BeforeEach
    void openPage() {
        open("https://www.saucedemo.com/");
    }

    @AfterEach
    void closeWindow() {
        closeWebDriver();
    }

    @Test
    void validAuthorization () {
        $("#user-name").setValue("standard_user");
        $("#password").setValue("secret_sauce");
        $("#login-button").click();
        $("#shopping_cart_container").shouldBe(visible);
    }

    @Test
    void invalidAuthorizationNonPassword () {
        $("#user-name").setValue("standard_user");
        $("#login-button").click();
        $(".error").shouldBe(visible);
        $("[data-test=error]").shouldHave(exactText("Epic sadface: Password is required"));
    }

    @Test
    void invalidAuthorizationNonUsername () {
        $("#password").setValue("secret_sauce");
        $("#login-button").click();
        $(".error").shouldBe(visible);
        $("[data-test=error]").shouldHave(exactText("Epic sadface: Username is required"));
    }

    @Test
    void invalidAuthorizationLockedOutUser() {
        $("#user-name").setValue("locked_out_user");
        $("#password").setValue("secret_sauce");
        $("#login-button").click();
        $(".error").shouldBe(visible);
        $("[data-test=error]").shouldHave(exactText("Epic sadface: Sorry, this user has been locked out."));
    }
}
