package tests;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.AddRemovePage;
import static org.junit.jupiter.api.Assertions.*;

public class AddRemoveTest extends BaseTest {

    @Test
    public void testAddRemoveElements() {
        HomePage home = new HomePage(driver, wait);
        home.navigateToAddRemoveElements();
        
        AddRemovePage addRemove = new AddRemovePage(driver, wait);
        
        // Dodaj element
        int initialCount = addRemove.getDeleteButtonsCount();
        addRemove.clickAddElement();
        assertEquals(initialCount + 1, addRemove.getDeleteButtonsCount());
        
        // Ukloni element  
        addRemove.clickDeleteButton();
        assertEquals(initialCount, addRemove.getDeleteButtonsCount());
    }
}
