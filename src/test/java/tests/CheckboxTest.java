package tests;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.CheckboxPage;
import static org.junit.jupiter.api.Assertions.*;

public class CheckboxTest extends BaseTest {

    @Test
    public void testCheckboxToggle() {
        HomePage home = new HomePage(driver, wait);
        home.navigateToCheckboxes();
        
        CheckboxPage checkbox = new CheckboxPage(driver, wait);
        
        // Checkbox 1: unchecked -> checked
        assertFalse(checkbox.isCheckbox1Checked(), "Checkbox 1 should be unchecked initially");
        checkbox.toggleCheckbox1();
        assertTrue(checkbox.isCheckbox1Checked(), "Checkbox 1 should be checked");
        
        // Checkbox 2: checked -> unchecked  
        assertTrue(checkbox.isCheckbox2Checked(), "Checkbox 2 should be checked initially");
        checkbox.toggleCheckbox2();
        assertFalse(checkbox.isCheckbox2Checked(), "Checkbox 2 should be unchecked");
    }
}
