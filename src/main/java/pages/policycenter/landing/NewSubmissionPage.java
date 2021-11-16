package pages.policycenter.landing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Page object encapsulates PC new submission page
 */
public class NewSubmissionPage {
    @FindBy(xpath = "//div[@class='gw-cell-inner']/div[@class='gw-multi-content-cell']/div[@id='NewSubmission-NewSubmissionScreen-ProductOffersDV-ProductSelectionLV-0-addSubmission']")
    private WebElement personalAutoButton;
    @FindBy(className = "gw-TitleBar--title")
    private WebElement pageTitle;

    public NewSubmissionPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void personalAutoButtonClick() {
        this.personalAutoButton.click();
    }

    public WebElement getPageTitle() {
        return pageTitle;
    }

    public boolean isPageOpened() {
        return pageTitle.getText().contains("New Submissions");
    }
}
