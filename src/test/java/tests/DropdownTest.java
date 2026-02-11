package tests;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.DropdownPage;
import static org.junit.jupiter.api.Assertions.*;

public class DropdownTest extends BaseTest {

    @Test
    public void testDropdownSelectOption1() {
        HomePage home = new HomePage(driver, wait);
        home.navigateToDropdown();
        
        DropdownPage dropdown = new DropdownPage(driver, wait);
        
        dropdown.selectOption("Option 1");
        assertEquals("Option 1", dropdown.getSelectedOption());
    }
}
