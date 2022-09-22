package pages.policycenter.auto;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class RatingsInputPage extends AutoPolicySubmissionPages {
    //locators
    @FindBy(xpath = "//*[@id='SubmissionWizard-LOBWizardStepGroup-LineWizardStepSet-PARatingInputsExtScreen-PARatingInputsExtPanelSet-PARatingInputsExtDV-PAMultiLineInputSet-LifeMultiLineDiscount']/div/div/select")
    private  WebElement lifePolicyCount;
    @FindBy(xpath = "//*[@id='SubmissionWizard-LOBWizardStepGroup-LineWizardStepSet-PARatingInputsExtScreen-PARatingInputsExtPanelSet-PARatingInputsExtDV-PAMiscellaneousInputSet-FurnishedAutos']/div/div/select")
    private WebElement furnishedAutos;

    @FindBy(xpath = "//*[@id='SubmissionWizard-LOBWizardStepGroup-LineWizardStepSet-PARatingInputsExtScreen-PARatingInputsExtPanelSet-PARatingInputsExtDV-PAMiscellaneousInputSet-OtherMotorVeh_1']")
    private WebElement hasOtherVehiclesNo;

    @FindBy(xpath = "//*[@id='SubmissionWizard-LOBWizardStepGroup-LineWizardStepSet-PARatingInputsExtScreen-PARatingInputsExtPanelSet-PARatingInputsExtCV-PriorPolicy30Days_1']")
    private WebElement hasPriorPolicyNo;

    @FindBy(xpath = "//*[@id='SubmissionWizard-LOBWizardStepGroup-LineWizardStepSet-PARatingInputsExtScreen-PARatingInputsExtPanelSet-PARatingInputsExtDV-PABillingDiscountsInputSet-PaidInFullIter-0-BooleanModifier_1']")
    private WebElement paidInFullDiscountNo;

    @FindBy(xpath = "//*[@id='SubmissionWizard-LOBWizardStepGroup-LineWizardStepSet-PARatingInputsExtScreen-PARatingInputsExtPanelSet-PARatingInputsExtDV-PABillingDiscountsInputSet-AllElecDiscIter-0-BooleanModifier_1']")
    private WebElement eDiscountNo;

    @FindBy(xpath = "//*[@id='SubmissionWizard-LOBWizardStepGroup-LineWizardStepSet-PARatingInputsExtScreen-PARatingInputsExtPanelSet-PARatingInputsExtDV-PABillingDiscountsInputSet-AutoPayDiscIter-0-BooleanModifier_1']")
    private WebElement autoPayDiscountNo;

    @FindBy(xpath = "//*[@id='SubmissionWizard-LOBWizardStepGroup-LineWizardStepSet-PARatingInputsExtScreen-PARatingInputsExtPanelSet-PARatingInputsExtDV-PAMultiLineInputSet-HomeownershipDiscountMod']/div/div/select")
    private WebElement homeOwnership;

    public RatingsInputPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getFurnishedAutos() {
        return furnishedAutos;
    }

    public void setFurnishedAutos(WebElement furnishedAutos) {
        this.furnishedAutos = furnishedAutos;
    }

    public void setHasOtherVehiclesNo() {
        this.hasOtherVehiclesNo.click();
    }

    public void setHasPriorPolicyNo() {
        this.hasPriorPolicyNo.click();
    }

    public void setPaidInFullDiscountNo() {
        this.paidInFullDiscountNo.click();
    }

    public void seteDiscountNo() {
        this.eDiscountNo.click();
    }

    public void setAutoPayDiscountNo() {
        this.autoPayDiscountNo.click();
    }

    public WebElement getLifePolicyCount() {
        return lifePolicyCount;
    }

    public void setLifePolicyCount(WebElement lifePolicyCount) {
        this.lifePolicyCount = lifePolicyCount;
    }

    public WebElement getHomeOwnership() {
        return homeOwnership;
    }

    public void setHomeOwnership(WebElement homeOwnership) {
        this.homeOwnership = homeOwnership;
    }

    public String getSelectedFurnishedAutos(String s) {
        Select select = new Select(getFurnishedAutos());
        select.selectByVisibleText(s);
        return select.getFirstSelectedOption().getText();
    }

    public String getSelectedLifePolicyCount(String s) {
        Select select = new Select(getLifePolicyCount());
        select.selectByVisibleText(s);
        return select.getFirstSelectedOption().getText();
    }

    public String getSelectedHomeOwnership(String s) {
        Select select = new Select(getHomeOwnership());
        select.selectByVisibleText(s);
        return select.getFirstSelectedOption().getText();
    }
}
