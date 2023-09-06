package test;

import org.junit.jupiter.api.Test;

import static test.TestData.*;

public class TestAuthorization extends TestBase {

    @Test
    void validAuthorization() {
        authorizationPage.setUserName(standartUser)
                .setPassword(password)
                .loginButtonClick()
                .verifyAuthorization();
    }

    @Test
    void invalidAuthorizationNonPassword() {
        authorizationPage.setUserName(standartUser)
                .loginButtonClick()
                .verifyResultsError("Epic sadface: Password is required");
    }

    @Test
    void invalidAuthorizationNonUsername() {
        authorizationPage.setPassword(password)
                .loginButtonClick()
                .verifyResultsError("Epic sadface: Username is required");
    }

    @Test
    void invalidAuthorizationLockedOutUser() {
        authorizationPage.setUserName(lockedOutUser)
                .setPassword(password)
                .loginButtonClick()
                .verifyResultsError("Epic sadface: Sorry, this user has been locked out.");
    }
}
