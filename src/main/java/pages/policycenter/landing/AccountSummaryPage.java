package pages.policycenter.landing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Page object encapsulates PC AccountSummary page
 */
public class AccountSummaryPage {

    //locators
    @FindBy(xpath = "//div[@id='TabBar-AccountTab']/div[3]/div")
    private WebElement accountTab;
    @FindBy(xpath = "//input[@name='TabBar-AccountTab-AccountTab_AccountNumberSearchItem']")
    private WebElement accountNumber;
    @FindBy(xpath = "//div[@id='TabBar-AccountTab-AccountTab_AccountNumberSearchItem_Button']/span")
    private WebElement accountNumberSearchButton;
    @FindBy(className = "gw-TitleBar--title")
    private WebElement pageTitle;
    @FindBy(xpath = "//div[@id='AccountFile_Summary-AccountSummaryDashboard-OpenPolicyTransactionsAccountListViewTile-NewSubmission']/div[@class='gw-action--inner gw-hasDivider']/div[@class='gw-label']")
    private WebElement newSubmissionButton;

    public AccountSummaryPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void accountTabClick() {
        this.accountTab.click();
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber.clear();
        this.accountNumber.sendKeys(accountNumber);
    }

    public void accountNumberSearchButtonClick() {
        this.accountNumberSearchButton.click();
    }

    public void newSubmissionButtonClick() {
        this.newSubmissionButton.click();
    }

    public boolean isPageOpened() {
        return pageTitle.getText().contains("Account Summary:");
    }
}
