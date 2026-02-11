package base;

import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class CrossBrowserExtension implements BeforeEachCallback {
    @Override
    public void beforeEach(ExtensionContext context) {
        String browser = System.getProperty("browser", "chrome");
        
        Object testInstance = context.getRequiredTestInstance();
        if (testInstance instanceof BaseTest) {
            ((BaseTest) testInstance).setBrowser(browser);
        }
    }
}
