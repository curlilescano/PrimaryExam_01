package framework;

import config.PropertiesFile;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

public class BaseTest {

    protected WebDriver driver;

    @BeforeClass
    public void BeforeSuite() throws IOException {
        String browserName = PropertiesFile.getProperty("browser");

        if (browserName.equalsIgnoreCase("chrome")) {

//            WebDriverManager.chromedriver().setup();
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\curli\\Downloads\\Automation\\Drivers\\chromedriver_1.exe");
            driver = new ChromeDriver();

        } else if (browserName.equalsIgnoreCase("firefox")) {

            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("edge")) {

            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
    }

//	@AfterClass
//	public void afterSuite() {
//		if(null != driver) {
//			driver.close();
////			driver.quit();
//		}
//	}

    public WebDriver getDriver() {
        return driver;
    }
}