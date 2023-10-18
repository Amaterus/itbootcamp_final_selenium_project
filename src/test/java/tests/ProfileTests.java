package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import retryAnalyzer.RetryAnalyzer;

public class ProfileTests extends BasicTest{
    @Test(priority = 1, retryAnalyzer = RetryAnalyzer.class)
    public void visitsProfilePageAndVerifyEmail() throws InterruptedException {

        loginPage.autoLogin("admin@admin.com", "12345");

        profilePage.clickOnProfileButton();

        Assert.assertTrue(driver.getCurrentUrl().contains("/profile"));

        profilePage.verifyEmailFieldValue();

        navPage.clickOnLogoutButton();
    }
}
