package tests;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.TablePage;
import pages.DragDropPage;
import static org.junit.jupiter.api.Assertions.*;

public class TableTests extends BaseTest {

    @Test
    public void testTableRowCount() {
        HomePage home = new HomePage(driver, wait);
        home.navigateToTables();
        
        TablePage table = new TablePage(driver, wait);
        assertEquals(4, table.getTableRows().size(), "Table1 should have 4 rows");
    }

    @Test
    public void testFirstRowData() {
        HomePage home = new HomePage(driver, wait);
        home.navigateToTables();
        
        TablePage table = new TablePage(driver, wait);
        String firstLastName = table.getFirstRowLastName();
        assertTrue(firstLastName.equals("Smith") || firstLastName.equals("Conway"), 
                   "First row should be Smith or Conway");
    }

    @Test
    public void testEmailExtraction() {
        HomePage home = new HomePage(driver, wait);
        home.navigateToTables();
        
        TablePage table = new TablePage(driver, wait);
        String emailRow0 = table.getEmailFromRow(0);
        assertTrue(emailRow0.contains("@"), "Email should contain @");
    }

    @Test
    public void testDueAmountExtraction() {
        HomePage home = new HomePage(driver, wait);
        home.navigateToTables();
        
        TablePage table = new TablePage(driver, wait);
        String dueRow1 = table.getDueFromRow(1);
        assertTrue(dueRow1.contains("$"), "Due amount should contain $");
    }

    @Test
    public void testTableSorting() {
        HomePage home = new HomePage(driver, wait);
        home.navigateToTables();
        
        TablePage table = new TablePage(driver, wait);
        String initialFirstName = table.getFirstRowLastName();
        table.clickLastNameHeader();
        
        
        String newFirstName = table.getFirstRowLastName();
        assertNotEquals(initialFirstName, newFirstName, "Table should sort after click");
    }

    @Test
    public void testDragDrop() {
        HomePage home = new HomePage(driver, wait);
        home.navigateToDragDrop();
        
        DragDropPage dragDrop = new DragDropPage(driver, wait);
        String initialSourceText = dragDrop.getSourceText();
        dragDrop.dragSourceToTarget();
        String newSourceText = dragDrop.getSourceText();
        
        assertNotEquals(initialSourceText, newSourceText, "Drag and drop should change elements");
    }
   /*  @Test
    public void testTableRowCount_FAIL() {
        HomePage home = new HomePage(driver, wait);
        home.navigateToTables();
        
        TablePage table = new TablePage(driver, wait);
        assertEquals(5, table.getTableRows().size(), "Table1 should have 5 rows (FAIL test)");
    }*/
}
