package pages.policycenter.landing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Page object encapsulates PC Home page
 */
public class PCHomePage {

    //locators
    @FindBy(className = "gw-TitleBar--title")
    private WebElement pageTitle;

    public PCHomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public WebElement getPageTitle() {
        return pageTitle;
    }

    public boolean isPageOpened() {
        return pageTitle.getText().contains("My Summary");
    }
}
