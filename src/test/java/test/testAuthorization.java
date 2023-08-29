package test;

import org.junit.jupiter.api.Test;

public class testAuthorization extends testBase {

    @Test
    void validAuthorization() {
        authorizationPage.setUserName("standard_user")
                .setPassword("secret_sauce")
                .loginButtonClick()
                .verifyAuthorization();
    }

    @Test
    void invalidAuthorizationNonPassword() {
        authorizationPage.setUserName("standard_user")
                .loginButtonClick()
                .verifyResultsError("Epic sadface: Password is required");
    }

    @Test
    void invalidAuthorizationNonUsername() {
        authorizationPage.setPassword("secret_sauce")
                .loginButtonClick()
                .verifyResultsError("Epic sadface: Username is required");
    }

    @Test
    void invalidAuthorizationLockedOutUser() {
        authorizationPage.setUserName("locked_out_user")
                .setPassword("secret_sauce")
                .loginButtonClick()
                .verifyResultsError("Epic sadface: Sorry, this user has been locked out.");
    }
}
