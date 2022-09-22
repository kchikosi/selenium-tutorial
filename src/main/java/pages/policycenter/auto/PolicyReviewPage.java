package pages.policycenter.auto;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PolicyReviewPage  extends  AutoPolicySubmissionPages {
    //locators
    @FindBy(xpath = "//*[@id='SubmissionWizard-SubmissionWizard_PolicyReviewScreen-JobWizardToolbarButtonSet-EvalRisk']/div/div[2]")
    private WebElement evaluateRisk;

    public PolicyReviewPage(WebDriver driver) {
        super(driver);
    }

    public void setEvaluateRisk() {
        this.evaluateRisk.click();
    }
}
