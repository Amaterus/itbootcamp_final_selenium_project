package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
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
    @Test (priority = 3, retryAnalyzer = RetryAnalyzer.class)
    public void editProfile(){
        String email = "admin@admin.com";
        String password = "12345";
        String name = "Veljko Andjelkovic";
        String phone = "+38161283223";
        String city = "Bucaramanga";
        String country = "Srbija";
        String twitter = "https://twitter.com/profile/milan1232";
        String github = "https://github.com/amaterus";

        loginPage.autoLogin(email, password);
        wait.until(ExpectedConditions.urlToBe(baseUrl + "/home"));
        navPage.clickOnProfileButton();
        profilePage.replaceName(name);
        profilePage.replacePhone(phone);
        profilePage.replaceCity(city);
        profilePage.replaceCountry(country);
        profilePage.replaceTwitter(twitter);
        profilePage.replaceGitHub(github);
        profilePage.clickOnSaveButton();
        messagePopUpPage.waitUntilPopUpMessageForSuccessfulProfileUpdateIsVisible();
        Assert.assertTrue(messagePopUpPage.getTextFromPopUpMessageForSuccessfulProfileUpdate(), "Pop up message should be 'Profile saved successfuly'.");

        Assert.assertEquals(profilePage.getNameValue(), name, "Name input value should be " + name);
        Assert.assertEquals(profilePage.getPhoneValue(), phone, "Phone input value should be " + phone);
        Assert.assertEquals(profilePage.getCityValue(), city, "City input value should be " + city);
        Assert.assertEquals(profilePage.getCountryValue(), country, "Country input value should be " + country);
        Assert.assertEquals(profilePage.getTwitterValue(), twitter, "Twitter input value should be " + twitter);
        Assert.assertEquals(profilePage.getGitHubValue(), github, "GitHub input value should be " + github);

        navPage.clickOnLogoutButton();
    }
}
