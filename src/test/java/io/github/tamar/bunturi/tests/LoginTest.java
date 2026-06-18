package io.github.tamar.bunturi.tests;

import io.github.tamar.bunturi.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    @Test
    public void validLoginShowsDashboard(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin", "admin123");

        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("dashboard"),
                "Expected to land on the dashboard after valid login, but URL was: " + currentUrl);
    }

    @Test
    public void invalidLoginShowsError(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin", "wrong");

        String errorMessage = loginPage.getErrorMessage();
        Assert.assertEquals(errorMessage, "Invalid credentials",
                "Expected an invalid credentials error for the wrong password");
    }
}
