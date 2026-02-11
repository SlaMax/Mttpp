package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DragDropPage {
    private WebDriver driver;
    private WebDriverWait wait;
    
    private By sourceElement = By.id("column-a");
    private By targetElement = By.id("column-b");

    public DragDropPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public String getSourceText() {
        return driver.findElement(sourceElement).getText();
    }

    public void dragSourceToTarget() {
        WebElement source = driver.findElement(sourceElement);
        WebElement target = driver.findElement(targetElement);
        
        Actions actions = new Actions(driver);
        actions.dragAndDrop(source, target).perform();
    }
}
