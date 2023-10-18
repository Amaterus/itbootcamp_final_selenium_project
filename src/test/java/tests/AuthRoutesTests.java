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

}
