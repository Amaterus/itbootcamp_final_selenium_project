package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import retryAnalyzer.RetryAnalyzer;

public class ProfileTests extends BasicTest{
    @Test(priority = 1, retryAnalyzer = RetryAnalyzer.class)
    public void visitsProfilePageAndVerifyEmail() throws InterruptedException {

        loginPage.autoLogin("admin@admin.com", "12345");

        navPage.clickOnProfileButton();

        Assert.assertTrue(driver.getCurrentUrl().contains("/profile"));

        profilePage.verifyEmailFieldValue();

        navPage.clickOnLogoutButton();
    }
    @Test(priority = 2, retryAnalyzer = RetryAnalyzer.class)
    public void visitsProfilePageAndVerifyInputTypes() throws InterruptedException {
        navPage.clickOnLoginButton();

        loginPage.autoLogin("admin@admin.com", "12345");

        navPage.clickOnProfileButton();

        profilePage.verifyAttribute("email", "type", "email");
        profilePage.verifyAttribute("email", "disabled", "true");

        profilePage.verifyAttribute("name", "type", "text");

        profilePage.verifyAttribute("city", "type", "text");

        profilePage.verifyAttribute("country", "type", "text");

        profilePage.verifyAttribute("urlTwitter", "type", "url");

        profilePage.verifyAttribute("urlGitHub", "type", "url");

        profilePage.verifyAttribute("phone", "type", "tel");

        navPage.clickOnLogoutButton();
    }
}
