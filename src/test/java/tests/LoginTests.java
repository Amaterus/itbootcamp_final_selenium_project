package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import retryAnalyzer.RetryAnalyzer;

public class LoginTests extends BasicTest {
    @Test(priority = 1, retryAnalyzer = RetryAnalyzer.class)
    public void visitsTheHomePage(){
        navPage.clickOnLanguageButton();
        navPage.clickOnEnglishLanguage();
        navPage.clickOnLoginButton();
        Assert.assertEquals(driver.getCurrentUrl(),
                baseUrl + "/login");
    }
    @Test (priority = 2, retryAnalyzer = RetryAnalyzer.class)
    public void checksInputTypes(){
        navPage.clickOnLoginButton();
        String attributeEmail = loginPage.getEmailInput().getAttribute("type");
        String attributePassword =loginPage.getPasswordInput().getAttribute("type");
        Assert.assertEquals(attributeEmail, "email", "The password field should have the value \"email\" in the \"type\" attribute." );
        Assert.assertEquals(attributePassword, "password", "The password field should have the value \"password\" in the \"type\" attribute.");

    }
    }
