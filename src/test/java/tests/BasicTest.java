package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.*;


import java.io.File;
import java.io.IOException;
import java.time.Duration;

public abstract class BasicTest {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected String baseUrl = "https://vue-demo.daniel-avellaneda.com";
    protected NavPage navPage;
    protected LoginPage loginPage;
    protected SignupPage signupPage;
    protected MessagePopUpPage messagePopUpPage;
    protected CitiesPage citiesPage;
    protected ProfilePage profilePage;
    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        navPage = new NavPage(driver, wait);
        loginPage = new LoginPage(driver, wait);
        signupPage = new SignupPage(driver, wait);
        messagePopUpPage = new MessagePopUpPage(driver, wait);
        citiesPage = new CitiesPage(driver, wait);
        profilePage = new ProfilePage(driver, wait);
    }
    @BeforeMethod
    public void beforMethod(){
        driver.navigate().to(baseUrl);
    }
    @AfterMethod
    public void afterMethod(ITestResult result) {
        driver.manage().deleteAllCookies();

        if (ITestResult.FAILURE == result.getStatus()) {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(screenshot, new File("screenshots/" + result.getName() + ".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
