package test;

import org.junit.jupiter.api.Test;

import static test.TestData.*;

public class TestCardProduct extends TestBase {

    @Test
    void cardProductFirstAZSort() {
        cardProductPage.authorization()
                .verifySortSelect(sortAZ)
                .firstCardProduct()
                .verifyElementsCardProduct();
    }

    @Test
    void cardProductLastAZSort() {
        cardProductPage.authorization()
                .verifySortSelect(sortAZ)
                .lastCardProduct()
                .verifyElementsCardProduct();
    }

    @Test
    void cardProductFirstZASort() {
        cardProductPage.authorization()
                .sortSelect(sortZA)
                .verifySortSelect(sortZA)
                .firstCardProduct()
                .verifyElementsCardProduct();
    }

    @Test
    void cardProductLastZASort() {
        cardProductPage.authorization()
                .sortSelect(sortZA)
                .verifySortSelect(sortZA)
                .lastCardProduct()
                .verifyElementsCardProduct();
    }

    @Test
    void cardProductFirstPriceAscending() {
        cardProductPage.authorization()
                .sortSelect(sortAscending)
                .verifySortSelect(sortAscending)
                .firstCardProduct()
                .verifyElementsCardProduct();
    }

    @Test
    void cardProductLastPriceAscending() {
        cardProductPage.authorization()
                .sortSelect(sortAscending)
                .verifySortSelect(sortAscending)
                .lastCardProduct()
                .verifyElementsCardProduct();
    }

    @Test
    void cardProductFirstPriceDescending() {
        cardProductPage.authorization()
                .sortSelect(sortDescending)
                .verifySortSelect(sortDescending)
                .firstCardProduct()
                .verifyElementsCardProduct();
    }

    @Test
    void cardProductLastPriceDescending() {
        cardProductPage.authorization()
                .sortSelect(sortDescending)
                .verifySortSelect(sortDescending)
                .lastCardProduct()
                .verifyElementsCardProduct();
    }

    @Test
    void cardProductBackButton() {
        cardProductPage.authorization()
                .firstCardProduct()
                .verifyBackButton();
    }

    @Test
    void cardProductAddToCartButton() {
        cardProductPage.authorization()
                .firstCardProduct()
                .verifyAddToCartButton();
    }

    @Test
    void cardProductRemoveButton() {
        cardProductPage.authorization()
                .firstCardProduct()
                .verifyRemoveButton();
    }
}
