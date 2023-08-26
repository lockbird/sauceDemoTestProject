package test;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.authorizationPage;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class testAuthorization {

    authorizationPage authorizationPage = new authorizationPage();

    @BeforeAll
    static void beforeAll () {
        Configuration.baseUrl = "https://www.saucedemo.com/";
        Configuration.browserSize = "1920x1080";
    }

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
        authorizationPage.setUserName("standard_user");
        authorizationPage.setPassword("secret_sauce");
        $("#login-button").click();
        $("#shopping_cart_container").shouldBe(visible);
    }

    @Test
    void invalidAuthorizationNonPassword () {
        authorizationPage.setUserName("standard_user");
        $("#login-button").click();
        $(".error").shouldBe(visible);
        $("[data-test=error]").shouldHave(exactText("Epic sadface: Password is required"));
    }

    @Test
    void invalidAuthorizationNonUsername () {
        authorizationPage.setPassword("secret_sauce");
        $("#login-button").click();
        $(".error").shouldBe(visible);
        $("[data-test=error]").shouldHave(exactText("Epic sadface: Username is required"));
    }

    @Test
    void invalidAuthorizationLockedOutUser() {
        authorizationPage.setUserName("locked_out_user");
        authorizationPage.setPassword("secret_sauce");
        $("#login-button").click();
        $(".error").shouldBe(visible);
        $("[data-test=error]").shouldHave(exactText("Epic sadface: Sorry, this user has been locked out."));
    }
}
