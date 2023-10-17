package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SignupPage extends BasicPage{
    public SignupPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public void checkEmailInputType() {
        WebElement emailInputField = driver.findElement(By.name("email"));
        Assert.assertEquals(emailInputField.getAttribute("type"), "email");
    }
    public void checkPasswordInputType() {
        WebElement passwordInputField = driver.findElement(By.name("password"));
        Assert.assertEquals(passwordInputField.getAttribute("type"), "password");
    }
    public void checkConfirmPassowordInputType() {
        WebElement confirmPasswordInputField = driver.findElement(By.name("confirmPassword"));
        Assert.assertEquals(confirmPasswordInputField.getAttribute("type"), "password");
    }
    public WebElement getNameField() {
        return driver.findElement(By.name("name"));
    }
    public WebElement getEmailField() {
        return driver.findElement(By.name("email"));
    }
    public WebElement getPasswordField() {
        return driver.findElement(By.name("password"));
    }
    public WebElement getConfirmPasswordField() {
        return driver.findElement(By.name("confirmPassword"));
    }

    public void fillSignUpFormWithData(String name, String email,String password,String confirmPassword) {
        getNameField().sendKeys(name);
        getEmailField().sendKeys(email);
        getPasswordField().sendKeys(password);
        getConfirmPasswordField().sendKeys(confirmPassword);
    }

    public void clickOnSignUpButton() {
        driver.findElement(By.cssSelector("div > div.flex.text-xs-center.mt-5 > button")).click();
    }
}
