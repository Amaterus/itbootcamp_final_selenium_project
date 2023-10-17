package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SignupPage;
import retryAnalyzer.RetryAnalyzer;

public class SignupTests extends BasicTest{
    @Test(priority = 1, retryAnalyzer = RetryAnalyzer.class)
    public void visitsTheSignUpPage() throws InterruptedException {

        navPage.clickOnSignUpButton();
        Assert.assertEquals(driver.getCurrentUrl(),baseUrl + "/signup");
    }
    @Test(priority = 2, retryAnalyzer = RetryAnalyzer.class)
    public void checksInputTypes() throws InterruptedException {
        navPage.clickOnSignUpButton();

        wait
                .until(ExpectedConditions.titleContains("Signup - My Awesome App"));

        signupPage.checkEmailInputType();
        signupPage.checkPasswordInputType();
        signupPage.checkConfirmPassowordInputType();
    }
    @Test(priority = 3, retryAnalyzer = RetryAnalyzer.class)
    public void displaysErrorsWhenUserAlreadyExists() throws InterruptedException {
        navPage.clickOnSignUpButton();

        wait
                .until(ExpectedConditions.titleContains("Signup - My Awesome App"));

        signupPage.fillSignUpFormWithData("Another User", "admin@admin.com", "12345", "12345");

        signupPage.clickOnSignUpButton();

        wait
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div > div.v-snack__content")));


        WebElement errorMessage = driver.findElement(By.cssSelector("div > div.v-snack__content > ul > li"));
        Assert.assertTrue(errorMessage.getText().contains("E-mail already exists"));

        Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "/signup");
    }
    @Test(priority = 4, retryAnalyzer = RetryAnalyzer.class)
    public void signup() throws InterruptedException {
        navPage.clickOnSignUpButton();

        wait
                .until(ExpectedConditions.titleContains("Signup - My Awesome App"));

        signupPage.fillSignUpFormWithData("Veljko Andjelkovic", "veljko1@gmail.com", "12345", "12345");
        signupPage.clickOnSignUpButton();

        wait
                .until(ExpectedConditions.titleContains("Protected Home - My Awesome App"));

        Assert.assertEquals(messagePopUpPage.getVerifyPopupMessage(), "IMPORTANT: Verify your account");

        messagePopUpPage.clickOnCloseButton();
        navPage.clickOnLogoutButton();
    }
}
