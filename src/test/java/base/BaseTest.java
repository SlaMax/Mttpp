package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

@ExtendWith(CrossBrowserExtension.class)
public class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected String browser = "chrome"; // Default
    protected boolean useGrid = false; // Za Grid testiranje
    protected String gridURL = "http://localhost:4444"; // Selenium Grid Hub URL
    private static final Logger logger = LoggerFactory.getLogger(BaseTest.class);

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    public void setUseGrid(boolean useGrid) {
        this.useGrid = useGrid;
    }

    @BeforeEach
    public void setUp() {
        logger.info("Setup pokrenut za browser: {}, Grid: {}", browser, useGrid);
        
        if (useGrid) {
            initializeGridDriver();
        } else {
            initializeLocalDriver();
        }
        
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        Allure.parameter("Browser", browser);
        Allure.parameter("ExecutionType", useGrid ? "Remote (Grid)" : "Local");
        logger.info("WebDriver uspješno inicijaliziran");
    }

    /**
     * Inicijalizira lokalni WebDriver
     */
    private void initializeLocalDriver() {
        switch (browser.toLowerCase()) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                driver = new FirefoxDriver(firefoxOptions);
                logger.info("Firefox driver inicijaliziran (LOCAL)");
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                driver = new EdgeDriver(edgeOptions);
                logger.info("Edge driver inicijaliziran (LOCAL)");
                break;
            case "chrome":
            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                driver = new ChromeDriver(chromeOptions);
                logger.info("Chrome driver inicijaliziran (LOCAL)");
                break;
        }
    }

    /**
     * Inicijalizira RemoteWebDriver za Selenium Grid
     */
    private void initializeGridDriver() {
        try {
            URL hubURL = new URL(gridURL);
            
            switch (browser.toLowerCase()) {
                case "firefox":
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    driver = new RemoteWebDriver(hubURL, firefoxOptions);
                    logger.info("Firefox driver inicijaliziran na Grid-u: {}", gridURL);
                    break;
                case "edge":
                    EdgeOptions edgeOptions = new EdgeOptions();
                    driver = new RemoteWebDriver(hubURL, edgeOptions);
                    logger.info("Edge driver inicijaliziran na Grid-u: {}", gridURL);
                    break;
                case "chrome":
                default:
                    ChromeOptions chromeOptions = new ChromeOptions();
                    driver = new RemoteWebDriver(hubURL, chromeOptions);
                    logger.info("Chrome driver inicijaliziran na Grid-u: {}", gridURL);
                    break;
            }
        } catch (MalformedURLException e) {
            logger.error("Greška pri konektovanju na Selenium Grid: {}", gridURL, e);
            throw new RuntimeException("Nije moguće konektovati na Selenium Grid", e);
        }
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            // Pravi screenshot pri neuspjehu
            takeScreenshot("test-execution");
            driver.quit();
            logger.info("WebDriver ugašen");
        }
    }

    /**
     * Pravi screenshot i dodaje ga u Allure report
     */
    protected void takeScreenshot(String name) {
        try {
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            byte[] screenshotAs = screenshot.getScreenshotAs(OutputType.BYTES);
            Allure.addAttachment(name, "image/png", new ByteArrayInputStream(screenshotAs), "png");
            logger.debug("Screenshot dodan: {}", name);
        } catch (Exception e) {
            logger.error("Greška pri pravljenju screenshot-a", e);
        }
    }
}
