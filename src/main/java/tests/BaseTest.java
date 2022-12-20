package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.io.File;

public class BaseTest {

    public WebDriver driver = getDriver();

    private WebDriver getDriver() {
        setupDriver("firefox");
        //setupDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://www.demoblaze.com/");
        return driver;
    }

    @BeforeMethod()
    public void beforeMethod() {

    }

    private void setupDriver(String browserName) {
        switch(browserName) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + File.separator + "drivers" + File.separator + "chromedriver");
                driver = new ChromeDriver();
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + File.separator + "drivers" + File.separator + "geckodriver");
                driver = new FirefoxDriver();
                break;
            default:
                System.out.println("Web Driver was not found in directory");
        }
    }

    public void print(String text) {
        System.out.println(text);
    }

    @AfterMethod(lastTimeOnly = true)
    public void afterMethod() {
        //When Testing all cases, lastTimeOnly setting fails, so I'm commenting it
        //driver.quit();
    }
}
