package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;
import pages.MessagePopUpPage;
import pages.NavPage;
import pages.SignupPage;


import java.time.Duration;

public abstract class BasicTest {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected String baseUrl = "https://vue-demo.daniel-avellaneda.com";
    protected NavPage navPage;
    protected LoginPage loginPage;
    protected SignupPage signupPage;
    protected MessagePopUpPage messagePopUpPage;

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

    }
    @BeforeMethod
    public void beforMethod(){
        driver.navigate().to(baseUrl);
    }
    @AfterMethod
    public void afterMethod () {
        driver.manage().deleteAllCookies();
    }
    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
