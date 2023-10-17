package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Collection;

public class MessagePopUpPage extends BasicPage {
    public MessagePopUpPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public void waitForErrorPopupToBeVisible() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.v-snack__content")));
    }

    public String getErrorMessage() {
        WebElement errorElement = driver.findElement(By.cssSelector("div > div.v-snack__content > ul > li"));
        return errorElement.getText();
    }
    public WebElement getCloseButton () {
        return driver.findElement(By.cssSelector(".v-card__actions button"));
    }
    public void clickOnCloseButton () {
        getCloseButton().click();
    }
    public String getVerifyPopupMessage(){
        WebElement verifyPopupText = driver.findElement(By.cssSelector(".black--text.dlgVerifyAccount"));
        return verifyPopupText.getText();
    }

    public void waitForMessagePopupToBeVisible() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div")));
    }

    public String getMessagePopupText() {
        WebElement messagePopup = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]"));
        return messagePopup.getText();
    }
}
