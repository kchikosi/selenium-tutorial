package pages.policycenter.auto;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

/**
 * page object encapsulates driver's page
 */
public class DriversPage extends AutoPolicySubmissionPages {
    // locators
    @FindBy(xpath = "//div[@id='SubmissionWizard-LOBWizardStepGroup-LineWizardStepSet-PADriversScreen-PADriversPanelSet-DriversListDetailPanel-DriversLV_tb-AddDriver']/div[@class='gw-action--inner']/div[@class='gw-label']")
    private WebElement addDriver;
    @FindBy(xpath = "//div[@id='SubmissionWizard-LOBWizardStepGroup-LineWizardStepSet-PADriversScreen-PADriversPanelSet-DriversListDetailPanel-DriversLV_tb-AddDriver-AddExistingContact']")
    private WebElement addExistingContact;
    @FindBy(xpath = "//div[@id='SubmissionWizard-LOBWizardStepGroup-LineWizardStepSet-PADriversScreen-PADriversPanelSet-DriversListDetailPanel-DriversLV_tb-AddDriver-AddExistingContact-0-UnassignedDriver']")
    private WebElement firstUnassignedUser;

    private JavascriptExecutor js = (JavascriptExecutor) driver;

    public DriversPage(WebDriver driver) {
        super(driver);
    }

    public void setAddDriver() {
        addDriver.click();
    }

    public void setAddExistingContact() {
        Actions actions = new Actions(driver);
        actions.clickAndHold(addExistingContact).perform();
    }

    public void setFirstUnassignedUser() {
        Actions actions = new Actions(driver);
        actions.moveToElement(firstUnassignedUser).click().perform();
    }
}
