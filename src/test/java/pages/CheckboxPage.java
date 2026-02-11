package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckboxPage {
    private WebDriver driver;
    private WebDriverWait wait;
    
    private By checkbox1 = By.cssSelector("#checkboxes input:nth-child(1)");
    private By checkbox2 = By.cssSelector("#checkboxes input:nth-child(3)");

    public CheckboxPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void toggleCheckbox1() {
        driver.findElement(checkbox1).click();
    }

    public void toggleCheckbox2() {
        driver.findElement(checkbox2).click();
    }

    public boolean isCheckbox1Checked() {
        WebElement cb1 = driver.findElement(checkbox1);
        return cb1.isSelected();
    }

    public boolean isCheckbox2Checked() {
        WebElement cb2 = driver.findElement(checkbox2);
        return cb2.isSelected();
    }
}
