package test;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.webdriver;

public class TestCardProduct extends TestBase {
    @Test
    void card() {
        Configuration.holdBrowserOpen = true;
        cardProductPage.authorization();
        $$(".inventory_item_name").last().click();

    }
}
