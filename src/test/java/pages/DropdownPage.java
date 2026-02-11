package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;

public class DropdownPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private By dropdown = By.id("dropdown");

    public DropdownPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void selectOption(String optionText) {
        WebElement dropdownElement = wait.until(d -> driver.findElement(dropdown));
        Select select = new Select(dropdownElement);
        select.selectByVisibleText(optionText);
    }

    public String getSelectedOption() {
        WebElement dropdownElement = driver.findElement(dropdown);
        Select select = new Select(dropdownElement);
        return select.getFirstSelectedOption().getText();
    }
}
