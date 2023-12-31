package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import retryAnalyzer.RetryAnalyzer;

public class AuthRoutesTests extends BasicTest{
    @Test(priority = 1, retryAnalyzer = RetryAnalyzer.class)
    public void visitsHomePage() throws InterruptedException {

        driver.get(baseUrl + "/home");
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "/login", "Current url should be " + baseUrl + "/login");
    }
    @Test(priority = 2, retryAnalyzer = RetryAnalyzer.class)
    public void visitsProfilePage() throws InterruptedException {
        driver.get(baseUrl + "/profile");
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "/login", "Current url should be " + baseUrl + "/login");
    }
    @Test(priority = 3, retryAnalyzer = RetryAnalyzer.class)
    public void forbidVisitsToAdminCitiesUrlIfNotAuthenticated() throws InterruptedException {
        driver.get(baseUrl + "/admin/cities");
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "/login", "Current url should be " + baseUrl + "/login");
    }
    @Test(priority = 4, retryAnalyzer = RetryAnalyzer.class)
    public void forbidVisitsToAdminUsersUrlIfNotAuthenticated() throws InterruptedException {
        driver.get(baseUrl + "/admin/users");
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "/login", "Current url should be " + baseUrl + "/login");
    }
}
