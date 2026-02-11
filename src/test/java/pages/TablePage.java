package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class TablePage {
    private WebDriver driver;
    private WebDriverWait wait;
    
    private By table1LastNameHeader = By.xpath("//table[@id='table1']//th[1]");
    private By table1Rows = By.xpath("//table[@id='table1']//tbody/tr");

    public TablePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void clickLastNameHeader() {
        driver.findElement(table1LastNameHeader).click();
    }

    public List<WebElement> getTableRows() {
        return driver.findElements(table1Rows);
    }

    public String getFirstRowLastName() {
        return getTableRows().get(0).findElement(By.tagName("td")).getText();
    }

    public String getEmailFromRow(int rowIndex) {
        return getTableRows().get(rowIndex).findElements(By.tagName("td")).get(2).getText();
    }

    public String getDueFromRow(int rowIndex) {
        return getTableRows().get(rowIndex).findElements(By.tagName("td")).get(3).getText();
    }
}
