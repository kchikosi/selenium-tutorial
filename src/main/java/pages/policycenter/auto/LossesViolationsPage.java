package pages.policycenter.auto;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LossesViolationsPage extends AutoPolicySubmissionPages {
    //locators
    @FindBy(xpath = "//*[@id='SubmissionWizard-LOBWizardStepGroup-LineWizardStepSet-PALossesViolationsExtScreen-PALossesViolationsExtPanelSet-AnyBIPIPQualifiedClaims_0']")
    private WebElement lossViolationsYes;
    @FindBy(xpath = "//*[@id='SubmissionWizard-LOBWizardStepGroup-LineWizardStepSet-PALossesViolationsExtScreen-PALossesViolationsExtPanelSet-HasLossesSubmission_1']")
    private WebElement lossViolationsNo;
    @FindBy(xpath = "//*[@id='SubmissionWizard-LOBWizardStepGroup-LineWizardStepSet-PALossesViolationsExtScreen-PALossesViolationsExtPanelSet-LossesCardTab']/div")
    private WebElement lossesCard;


    public LossesViolationsPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getLossViolationsYes() {
        return lossViolationsYes;
    }

    public void setLossViolationsYes() {
        this.lossViolationsYes.click();
    }

    public WebElement getLossViolationsNo() {
        return lossViolationsNo;
    }

    public void setLossViolationsNo() {
        this.lossViolationsNo.click();
    }

    public WebElement getLossesCard() {
        return lossesCard;
    }

    public void setLossesCard() {
        this.lossesCard.click();
    }
}

