package pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.conditions.Value;
import static com.codeborne.selenide.Selenide.$;

public class authorizationPage {

    private SelenideElement
            userName = $("#user-name"),
            password = $("#password");

    public void setUserName (String value) {
        userName.setValue(value);
    }

    public void setPassword (String value) {
        password.setValue(value);
    }

}
