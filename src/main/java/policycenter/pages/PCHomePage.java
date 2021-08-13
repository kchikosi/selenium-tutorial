package policycenter.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Page object encapsulates PC Home page
 */
public class PCHomePage {

    private final WebDriver driver;
    private By titleBy = By.className("gw-TitleBar--title");

    public PCHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getMessageText() {
        return driver.findElement(titleBy).getText();
    }
}
