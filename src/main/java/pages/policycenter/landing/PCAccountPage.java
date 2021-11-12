package pages.policycenter.landing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Page object encapsulates PC AccountSummary page
 */
public class PCAccountPage {

    //locators
    @FindBy(className = "gw-TitleBar--title")
    private WebElement pageTitle;

    public PCAccountPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public boolean isPageOpened() {
        return pageTitle.getText().contains("Account Summary:");
    }
}
