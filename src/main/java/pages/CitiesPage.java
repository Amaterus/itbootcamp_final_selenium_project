package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Collection;
import java.util.List;

public class CitiesPage extends BasicPage {
    public CitiesPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void clickOnCitiesButton() {
        driver.findElement(By.cssSelector("a.btnAdminCities")).click();
    }

    public void clickOnNewItemButton() {
        driver.findElement(By.className("btnNewItem")).click();
    }

    public void waitForCreateEditCityDialogToAppear() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#app > div.v-dialog__content.v-dialog__content--active > div > div")));
    }

    public WebElement getCityInputField() {
        return driver.findElement(By.cssSelector("#name"));
    }

    public void enterCityName(String cityName) {
        WebElement cityInputField = driver.findElement(By.cssSelector("#name"));
        cityInputField.sendKeys(cityName);
    }

    public void clickOnSaveButton() {
        driver.findElement(By.cssSelector("div.v-card__actions > button.btnSave")).click();
    }

    public String getMessagePopupText() {
        WebElement messagePopup = driver.findElement(By.cssSelector(".success .v-snack__content"));
        return messagePopup.getText();
    }
}
