package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class authorizationPage {

    private SelenideElement
            userName = $("#user-name"),
            password = $("#password"),
            loginButton = $("#login-button"),
            errorContainer = $(".error"),
            errorMessageContainer = $("[data-test=error]"),
            shoppingCartContainer = $("#shopping_cart_container");

    public authorizationPage setUserName(String value) {
        userName.setValue(value);

        return this;
    }

    public authorizationPage setPassword(String value) {
        password.setValue(value);

        return this;
    }

    public authorizationPage loginButtonClick() {
        loginButton.click();

        return this;
    }

    public authorizationPage verifyAuthorization() {
        shoppingCartContainer.shouldBe(visible);

        return this;
    }

    public authorizationPage verifyResultsError(String text) {
        errorContainer.shouldBe(visible);
        errorMessageContainer.shouldHave(exactText(text));

        return this;
    }

}
