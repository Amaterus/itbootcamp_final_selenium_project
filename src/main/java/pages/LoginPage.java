package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage extends BasicPage {
    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getEmailInput() {
        return driver.findElement(By.name("email"));
    }

    public WebElement getPasswordInput() {
        return driver.findElement(By.name("password"));
    }
}
