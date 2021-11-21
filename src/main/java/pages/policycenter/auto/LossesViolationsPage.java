package pages.policycenter.auto;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LossesViolationsPage extends AutoPolicySubmissionPages {
    //locators
    @FindBy(xpath = "//*[@id='SubmissionWizard-LOBWizardStepGroup-LineWizardStepSet-PALossesViolationsExtScreen-PALossesViolationsExtPanelSet-HasLossesSubmission_1']")
    private WebElement lossViolations;

    @FindBy(xpath = "//*[@id='SubmissionWizard-LOBWizardStepGroup-LineWizardStepSet-PALossesViolationsExtScreen-PALossesViolationsExtPanelSet-LossesCardTab']/div")
    private WebElement lossesCard;

    public LossesViolationsPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getLossViolations() {
        return lossViolations;
    }

    public void setLossViolations() {
        this.lossViolations.click();
    }

    public WebElement getLossesCard() {
        return lossesCard;
    }

}

