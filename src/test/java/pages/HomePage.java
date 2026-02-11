package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;
    private By formAuthLink = By.linkText("Form Authentication");

    public HomePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void navigateToFormAuthentication() {
        driver.navigate().to("https://the-internet.herokuapp.com/");
        driver.findElement(formAuthLink).click();
    }
    public void navigateToAddRemoveElements() {
        driver.navigate().to("https://the-internet.herokuapp.com/");
        driver.findElement(By.partialLinkText("Add/Remove")).click();
    }

    public void navigateToCheckboxes() {
        driver.navigate().to("https://the-internet.herokuapp.com/");
        driver.findElement(By.linkText("Checkboxes")).click();
    }

    public void navigateToDropdown() {
        driver.navigate().to("https://the-internet.herokuapp.com/");
        driver.findElement(By.linkText("Dropdown")).click();
    }

    public void navigateToTables() {
        driver.navigate().to("https://the-internet.herokuapp.com/");
        driver.findElement(By.partialLinkText("Data Table")).click();
    }

    public void navigateToDragDrop() {
        driver.navigate().to("https://the-internet.herokuapp.com/");
        driver.findElement(By.linkText("Drag and Drop")).click();
    }
}