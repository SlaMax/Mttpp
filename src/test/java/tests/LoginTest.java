package tests;

import base.BaseTest;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.HomePage;
import pages.LoginPage;
import static org.junit.jupiter.api.Assertions.*;

@Feature("Login Functionality")
@Story("User Form Authentication")
public class LoginTest extends BaseTest {
    private static final Logger logger = LoggerFactory.getLogger(LoginTest.class);

    @Test
    @DisplayName("Valid Login Test")
    @Description("Testira uspješnu prijavu sa validnim kredencijalima")
    @Severity(SeverityLevel.BLOCKER)
    public void testValidLogin() {
        logger.info("Počinjam test validne prijave");
        
        HomePage home = new HomePage(driver, wait);
        logger.debug("Navigiram na home page");
        home.navigateToFormAuthentication();
        
        LoginPage login = new LoginPage(driver, wait);
        logger.info("Unosim kredencijale: tomsmith");
        login.login("tomsmith", "SuperSecretPassword!");
        
        String message = login.getSuccessMessage();
        logger.info("Provjera uspješne poruke: {}", message);
        assertTrue(message.contains("You logged into a secure area!"));
        logger.info("Test validne prijave uspješan");
    }
}
