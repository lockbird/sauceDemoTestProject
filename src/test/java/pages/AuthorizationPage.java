package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class AuthorizationPage {

    private SelenideElement
            userNameInput = $("#user-name"),
            passwordInput = $("#password"),
            loginButton = $("#login-button"),
            errorContainer = $(".error"),
            errorMessageContainer = $("[data-test=error]"),
            shoppingCartContainer = $("#shopping_cart_container");

    public AuthorizationPage setUserName(String value) {
        userNameInput.setValue(value);

        return this;
    }

    public AuthorizationPage setPassword(String value) {
        passwordInput.setValue(value);

        return this;
    }

    public AuthorizationPage loginButtonClick() {
        loginButton.click();

        return this;
    }

    public AuthorizationPage verifyAuthorization() {
        shoppingCartContainer.shouldBe(visible);

        return this;
    }

    public AuthorizationPage verifyResultsError(String text) {
        errorContainer.shouldBe(visible);
        errorMessageContainer.shouldHave(exactText(text));

        return this;
    }

}
