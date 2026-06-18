package io.github.tamar.bunturi.tests;

import io.github.tamar.bunturi.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    @Test
    public void validLoginShowsDashboard() {
        LoginPage loginPage = new LoginPage(driver, config.getExplicitWait());
        loginPage.login("Admin", "admin123");

        Assert.assertTrue(loginPage.isOnDashboard(),
                "Expected to land on the dashboard after valid login.");
    }

    @Test
    public void invalidLoginShowsError(){
        LoginPage loginPage = new LoginPage(driver, config.getExplicitWait());
        loginPage.login("Admin", "wrong");

        String errorMessage = loginPage.getErrorMessage();
        Assert.assertEquals(errorMessage, "Invalid credentials",
                "Expected an invalid credentials error for the wrong password");
    }
}
