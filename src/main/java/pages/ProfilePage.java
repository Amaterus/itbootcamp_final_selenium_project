package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ProfilePage extends BasicPage{
    public ProfilePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void clickOnProfileButton() {
        driver.findElement(By.cssSelector("a.btnProfile")).click();
    }
    public void verifyEmailFieldValue() {
        String emailFieldValue = driver.findElement(By.cssSelector("#email")).getAttribute("value");
        Assert.assertEquals(emailFieldValue, "admin@admin.com");
    }
}
