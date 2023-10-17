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
}
