package seleniumtestframework.testbase;

import com.codoid.products.exception.FilloException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

public class TestBase {
    private static final Logger log = LogManager.getLogger(TestBase.class);
    protected static WebDriverWait driverWait = null; //TODO: add driver

    public TestBase() throws IOException, FilloException {
    }

    public static void sendKeys(WebElement element, String s) {
        try {
            driverWait.until(ExpectedConditions.visibilityOf(element));
            element.clear();
            element.sendKeys(s);
        } catch (NoSuchElementException e) {
            log.error("Error in send keys", e);
        }
    }

    public static void clickElement(WebElement element) {
        driverWait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }
}
