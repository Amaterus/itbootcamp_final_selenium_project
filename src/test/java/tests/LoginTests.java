package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import retryAnalyzer.RetryAnalyzer;

public class LoginTests extends BasicTest {
    @Test(priority = 1, retryAnalyzer = RetryAnalyzer.class)
    public void visitsTheHomePage() {
        navPage.clickOnLanguageButton();
        navPage.clickOnEnglishLanguage();
        navPage.clickOnLoginButton();
        Assert.assertEquals(driver.getCurrentUrl(),
                baseUrl + "/login");
    }

    @Test(priority = 2, retryAnalyzer = RetryAnalyzer.class)
    public void checksInputTypes() {
        navPage.clickOnLoginButton();
        String attributeEmail = loginPage.getEmailInput().getAttribute("type");
        String attributePassword = loginPage.getPasswordInput().getAttribute("type");
        Assert.assertEquals(attributeEmail, "email", "The email field should have the value \"email\" in the \"type\" attribute.");
        Assert.assertEquals(attributePassword, "password", "The password field should have the value \"password\" in the \"type\" attribute.");

    }
    @Test (priority = 3, retryAnalyzer = RetryAnalyzer.class)
    public void displaysErrorsWhenUserDoesNotExist() {
        navPage.clickOnLoginButton();

        loginPage.getEmailInput().sendKeys("non-existing-user@gmail.com");
        loginPage.getPasswordInput().sendKeys("password123");

        loginPage.clickOnLoginButton();

        loginPage.waitForErrorPopupToBeVisible();

        String errorMessage = loginPage.getErrorMessage();
        Assert.assertTrue(errorMessage.contains("User does not exists"));

        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, baseUrl + "/login");
    }
    @Test (priority = 4, retryAnalyzer = RetryAnalyzer.class)
    public void displaysErrorsWhenPasswordIsWrong(){
        String email = "admin@admin.com";
        String password = "password123";
        navPage.clickOnLoginButton();

        loginPage.getEmailInput().sendKeys(email);
        loginPage.getPasswordInput().sendKeys(password);
        loginPage.clickOnLoginButton();
        loginPage.waitForErrorPopupToBeVisible();

        String errorMessage = loginPage.getErrorMessage();
        Assert.assertEquals(errorMessage, "Wrong password", "Message from popup should be contains \"Wrong password\"" );

        Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "/login", "Urls should be similar.");
    }
}
