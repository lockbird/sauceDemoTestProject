package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class CardProductPage {
    private SelenideElement
            userName = $("#user-name"),
            password = $("#password"),
            loginButton = $("#login-button"),
            shoppingCartContainer = $("#shopping_cart_container");

    public CardProductPage authorization() {
        userName.setValue("standard_user");
        password.setValue("secret_sauce");
        loginButton.click();
        shoppingCartContainer.shouldBe(visible);

        return this;
    }



}
