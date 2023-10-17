package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage extends BasicPage {
    protected NavPage navPage;
    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        navPage = new NavPage(driver, wait);
    }

    public WebElement getEmailInput() {
        return driver.findElement(By.name("email"));
    }

    public WebElement getPasswordInput() {
        return driver.findElement(By.name("password"));
    }

    public void clickOnLoginButton() {
        driver.findElement(By.cssSelector("div.flex.text-xs-center.mt-5.mb-3 > button")).click();
    }
    public void autoLogin(String email, String password){
        navPage.clickOnLoginButton();
        getEmailInput().sendKeys(email);
        getPasswordInput().sendKeys(password);
        clickOnLoginButton();
    }
}
