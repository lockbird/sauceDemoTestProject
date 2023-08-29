package test;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import pages.authorizationPage;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class testBase {

    pages.authorizationPage authorizationPage = new authorizationPage();

    @BeforeAll
    static void beforeAll() {
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

}
