package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
    public void replaceName(String name){
        getNameField().click();
        getNameField().sendKeys(Keys.chord(Keys.CONTROL, "a"), name);
    }
    public void replacePhone(String phone){
        getPhoneField().click();
        getPhoneField().sendKeys(Keys.chord(Keys.CONTROL, "a"), phone);
    }
    public void replaceCity(String city){

        getCityField().sendKeys(Keys.CONTROL + "a");
        getCityField().click();
        getCityField().sendKeys(Keys.chord(Keys.CONTROL, "a"), city);
    }
    public void replaceCountry(String country){
        getCountryField().click();
        getCountryField().sendKeys(Keys.chord(Keys.CONTROL, "a"), country);
    }
    public void replaceTwitter(String twitter){
        getTwitterField().click();
        getTwitterField().sendKeys(Keys.chord(Keys.CONTROL, "a"), twitter);
    }
    public void replaceGitHub(String github){

        getGitHubField().click();
        getGitHubField().sendKeys(Keys.chord(Keys.CONTROL, "a"), github);
    }
    public WebElement getSaveButton () {
        return driver.findElement(By.className("btnSave"));
    }
    public void clickOnSaveButton () {
        getSaveButton().click();
    }
    public WebElement getNameField(){
        return driver.findElement(By.id("name"));
    }
    public WebElement getCityField(){
        return driver.findElement(By.id("city"));
    }
    public WebElement getCountryField(){
        return driver.findElement(By.id("country"));
    }
    public WebElement getTwitterField(){
        return driver.findElement(By.id("urlTwitter"));
    }
    public WebElement getGitHubField(){
        return driver.findElement(By.id("urlGitHub"));
    }
    public WebElement getPhoneField(){
        return driver.findElement(By.id("phone"));
    }
    public WebElement getEmailField(){
        return driver.findElement(By.id("email"));
    }
    public String getNameValue() {
        return driver.findElement(By.id("name")).getAttribute("value");
    }

    public String getPhoneValue() {
        return driver.findElement(By.id("phone")).getAttribute("value");
    }

    public String getCityValue() {
        return driver.findElement(By.id("city")).getAttribute("value");
    }

    public String getCountryValue() {
        return driver.findElement(By.id("country")).getAttribute("value");
    }

    public String getTwitterValue() {
        return driver.findElement(By.id("urlTwitter")).getAttribute("value");
    }

    public String getGitHubValue() {
        return driver.findElement(By.id("urlGitHub")).getAttribute("value");
    }
}
