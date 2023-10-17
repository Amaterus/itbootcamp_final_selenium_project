package tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import retryAnalyzer.RetryAnalyzer;

import java.util.List;

public class AdminCitiesTests extends BasicTest{

    @Test(priority = 1, retryAnalyzer = RetryAnalyzer.class)
    public void visitsAdminCitiesPageAndListCities() throws InterruptedException {

        loginPage.autoLogin("admin@admin.com", "12345");

        navPage.clickOnAdminButton();

        citiesPage.clickOnCitiesButton();

        Assert.assertTrue(driver.getCurrentUrl().contains("/admin/cities"));
    }
}
