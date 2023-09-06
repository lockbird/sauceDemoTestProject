package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static test.TestData.*;

public class CardProductPage {
    private SelenideElement
            userNameInput = $("#user-name"),
            passwordInput = $("#password"),
            loginButton = $("#login-button"),
            shoppingCartContainer = $("#shopping_cart_container"),
            productSortContainer = $(".product_sort_container"),
            inventoryDetailsIMG = $(".inventory_details_img"),
            inventoryDetailsName = $(".inventory_details_name"),
            inventoryDetailsDesc = $(".inventory_details_desc"),
            inventoryDetailsPrice = $(".inventory_details_price"),
            addToCartButton = $(".btn_inventory"),
            backButton = $("#back-to-products"),
            titleHeaderContainer = $(".header_secondary_container")
                    .$(".title");
    private ElementsCollection
            inventoryItemName = $$(".inventory_item_name");

    public CardProductPage authorization() {
        userNameInput.setValue(standartUser);
        passwordInput.setValue(password);
        loginButton.click();
        shoppingCartContainer.shouldBe(visible);

        return this;
    }

    public CardProductPage sortSelect(String value) {
        productSortContainer.selectOptionByValue(value);

        return this;
    }

    public CardProductPage verifySortSelect(String value) {
        productSortContainer.shouldHave(value(value));

        return this;
    }

    public CardProductPage firstCardProduct() {
        inventoryItemName.first().click();

        return this;
    }

    public CardProductPage lastCardProduct() {
        inventoryItemName.last().click();

        return this;
    }

    public CardProductPage verifyBackButton() {
        backButton.should(interactable)
                .shouldHave(exactTextCaseSensitive(backTextButton))
                .click();
        titleHeaderContainer.shouldHave(exactTextCaseSensitive(titleHeader));

        return this;
    }

    public CardProductPage verifyAddToCartButton() {
        addToCartButton.should(interactable)
                .shouldHave(exactTextCaseSensitive(addToCartTextButton))
                .click();
        addToCartButton.should(interactable)
                .shouldHave(exactTextCaseSensitive(removeButton));

        return this;
    }

    public CardProductPage verifyRemoveButton() {
        addToCartButton.should(interactable)
                .shouldHave(exactTextCaseSensitive(addToCartTextButton))
                .click();
        addToCartButton.should(interactable)
                .shouldHave(exactTextCaseSensitive(removeButton))
                .click();
        addToCartButton.should(interactable)
                .shouldHave(exactTextCaseSensitive(addToCartTextButton));

        return this;
    }

    public CardProductPage verifyElementsCardProduct() {
        inventoryDetailsIMG.should(image);
        inventoryDetailsName.shouldNotHave(empty)
                .should(matchText(regexAlphavite));
        inventoryDetailsDesc.shouldNotHave(empty)
                .should(matchText(regexAlphavite));
        inventoryDetailsPrice.shouldNotHave(empty)
                .should(matchText(regexPrice));
        addToCartButton.should(interactable)
                .shouldHave(exactTextCaseSensitive(addToCartTextButton));
        backButton.should(interactable)
                .shouldHave(exactTextCaseSensitive(backTextButton));

        return this;
    }
}