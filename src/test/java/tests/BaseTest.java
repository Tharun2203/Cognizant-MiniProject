package tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    public static WebDriver driver;

    @BeforeMethod
    public void launchBrowser() {
        ChromeOptions co = new ChromeOptions();
        co.addArguments("--disable-notifications");
        driver = new ChromeDriver(co);
        driver.manage().window().maximize();
        driver.get("https://www.trivago.in/");
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }
}