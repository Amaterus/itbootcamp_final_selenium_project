package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ProfilePage extends BasicPage{
    public ProfilePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public void verifyEmailFieldValue() {
        String emailFieldValue = driver.findElement(By.cssSelector("#email")).getAttribute("value");
        Assert.assertEquals(emailFieldValue, "admin@admin.com");
    }
    public void verifyAttribute(String fieldId, String attribute, String expectedValue) {
        WebElement element = driver.findElement(By.id(fieldId));
        String actualValue = element.getAttribute(attribute);
        Assert.assertEquals(actualValue, expectedValue);
    }
}
