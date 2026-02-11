package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class AddRemovePage {
    private WebDriver driver;
    private WebDriverWait wait;
    
    // Točan locator za Add button (samo jedan)
    private By addButton = By.xpath("//button[text()='Add Element']");
    // Delete buttons se dinamički generiraju
    private By deleteButton = By.xpath("//button[contains(text(),'Delete')]");

    public AddRemovePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void clickAddElement() {
        driver.findElement(addButton).click();
    }

    public void clickDeleteButton() {
        List<WebElement> deleteBtns = driver.findElements(deleteButton);
        if (!deleteBtns.isEmpty()) {
            deleteBtns.get(0).click();  // Prvi Delete button
        }
    }

    public int getDeleteButtonsCount() {
        return driver.findElements(deleteButton).size();
    }
}
