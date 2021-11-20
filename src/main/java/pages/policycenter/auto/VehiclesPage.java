package pages.policycenter.auto;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class VehiclesPage extends AutoPolicySubmissionPages {
    // locators
    @FindBy(xpath = "//*[@id='SubmissionWizard-LOBWizardStepGroup-LineWizardStepSet-PAVehiclesScreen-PAVehiclesPanelSet-VehiclesListDetailPanel_tb-CreateVehicleOptionsButton']/div[1]/div[2]")
    private WebElement createVehicle;

    @FindBy(xpath = "//*[@id='SubmissionWizard-LOBWizardStepGroup-LineWizardStepSet-PAVehiclesScreen-PAVehiclesPanelSet-VehiclesListDetailPanel_tb-CreateVehicleOptionsButton-CreateVehicleMenuInline']/div/div[2]")
    private WebElement createManual;

    @FindBy(xpath = "//*[@id='SubmissionWizard-LOBWizardStepGroup-LineWizardStepSet-PAVehiclesScreen-PAVehiclesPanelSet-VehiclesListDetailPanel_tb-CreateVehicleOptionsButton-CreateVehicleMenuPrefill']/div/div[2]")
    private WebElement createFromPrefill;

    @FindBy(xpath = "//*[@id='SubmissionWizard-LOBWizardStepGroup-LineWizardStepSet-PAVehiclesScreen-PAVehiclesPanelSet-VehiclesListDetailPanel-VehiclesDetailsCV-PersonalAuto_VehicleDV-BasicVehicleInfoExtInputSet-Vin_DV']/div/input")
    private WebElement vin;

    @FindBy(xpath = "//*[@id='SubmissionWizard-LOBWizardStepGroup-LineWizardStepSet-PAVehiclesScreen-PAVehiclesPanelSet-VehiclesListDetailPanel-VehiclesDetailsCV-VehicleDetailCardTab']/div")
    private WebElement vehicleDetailsCard;

    @FindBy(xpath = "//*[@id='SubmissionWizard-LOBWizardStepGroup-LineWizardStepSet-PAVehiclesScreen-PAVehiclesPanelSet-VehiclesListDetailPanel-VehiclesDetailsCV-PersonalAuto_VehicleDV-BasicVehicleInfoExtInputSet-Year_DV']/div[1]/input")
    private WebElement modelYear;

    @FindBy(xpath = "//*[@id='SubmissionWizard-LOBWizardStepGroup-LineWizardStepSet-PAVehiclesScreen-PAVehiclesPanelSet-VehiclesListDetailPanel-VehiclesDetailsCV-PersonalAuto_VehicleDV-PurchaseDate']/div/input")
    private WebElement purchaseDate;

    @FindBy(xpath = "//*[@id='SubmissionWizard-LOBWizardStepGroup-LineWizardStepSet-PAVehiclesScreen-PAVehiclesPanelSet-VehiclesListDetailPanel-VehiclesDetailsCV-PersonalAuto_VehicleDV-NewUsed']/div/div/select")
    private WebElement newUsed;

    @FindBy(xpath = "//*[@id='SubmissionWizard-LOBWizardStepGroup-LineWizardStepSet-PAVehiclesScreen-PAVehiclesPanelSet-VehiclesListDetailPanel-VehiclesDetailsCV-PersonalAuto_VehicleDV-PurchaseType']/div/div/select")
    private WebElement purchaseType;

    @FindBy(xpath = "//*[@id='SubmissionWizard-LOBWizardStepGroup-LineWizardStepSet-PAVehiclesScreen-PAVehiclesPanelSet-VehiclesListDetailPanel-VehiclesDetailsCV-PersonalAuto_VehicleDV-BasicVehicleInfoExtInputSet-Year_DV-Year_DVMenuIcon']/div[1]")
    private WebElement generateVehicleInformation;

    @FindBy(xpath = "//*[@id='SubmissionWizard-LOBWizardStepGroup-LineWizardStepSet-PAVehiclesScreen-PAVehiclesPanelSet-VehiclesListDetailPanel-VehiclesDetailsCV-PersonalAuto_VehicleDV-VehicleOwner']/div/div/select")
    private WebElement vehicleOwner;

    @FindBy(xpath = "//*[@id='SubmissionWizard-LOBWizardStepGroup-LineWizardStepSet-PAVehiclesScreen-PAVehiclesPanelSet-VehiclesListDetailPanel-VehiclesDetailsCV-PersonalAuto_VehicleDV-dailymiles_DV']/div/input")
    private WebElement dailyMiles;

    @FindBy(xpath = "//*[@id='SubmissionWizard-LOBWizardStepGroup-LineWizardStepSet-PAVehiclesScreen-PAVehiclesPanelSet-VehiclesListDetailPanel-VehiclesDetailsCV-PersonalAuto_VehicleDV-VehicleUseModifier']/div/div/select")
    private WebElement primaryUse;

    @FindBy(xpath = "//*[@id='SubmissionWizard-LOBWizardStepGroup-LineWizardStepSet-PAVehiclesScreen-PAVehiclesPanelSet-VehiclesListDetailPanel-VehiclesDetailsCV-PersonalAuto_VehicleDV-annualmiles_DV']/div/input")
    private WebElement annualMiles;

    @FindBy(xpath = "//*[@id='SubmissionWizard-LOBWizardStepGroup-LineWizardStepSet-PAVehiclesScreen-PAVehiclesPanelSet-VehiclesListDetailPanel-VehiclesDetailsCV-PersonalAuto_VehicleDV-CommercialUse_1']")
    private WebElement commercialUse;

    @FindBy(xpath = "//*[@id='SubmissionWizard-LOBWizardStepGroup-LineWizardStepSet-PAVehiclesScreen-PAVehiclesPanelSet-VehiclesListDetailPanel-VehiclesDetailsCV-PersonalAuto_VehicleDV-LoanedOrRented_1']")
    private WebElement loanedOrRented;

    @FindBy(xpath = "//*[@id='SubmissionWizard-LOBWizardStepGroup-LineWizardStepSet-PAVehiclesScreen-PAVehiclesPanelSet-VehiclesListDetailPanel-VehiclesDetailsCV-PersonalAuto_VehicleDV-Parking']/div/div/select")
    private WebElement parking;
    private final JavascriptExecutor js;


    public VehiclesPage(WebDriver driver) {
        super(driver);
        js = (JavascriptExecutor) driver;
    }

    public void setCreateVehicle() {
        createVehicle.click();
    }

    public void setCreateManual() {
        setCreateVehicle();
        actions.moveToElement(createManual).click().perform();
    }

    public void setCreateFromPrefill() {
        setCreateVehicle();
        actions.moveToElement(createFromPrefill).click().perform();
    }

    public WebElement getVehicleDetailsCard() {
        return vehicleDetailsCard;
    }

    public void setVin(String s) {
        vin.sendKeys(s);
    }

    public void setModelYear(String s) {
        //TODO: add code to allow vin information to be populated
        modelYear.sendKeys(s);
        modelYear.sendKeys(Keys.TAB);
    }

    public void setPurchaseDate(String s) {
        purchaseDate.sendKeys(s);
    }

    public void setNewUsed() {
        //TODO: add select option code
    }

    public WebElement getPurchaseDate() {
        return purchaseDate;
    }

    public WebElement getGenerateVehicleInformation() {
        return generateVehicleInformation;
    }

    public WebElement getNewUsed() {
        return newUsed;
    }

    public WebElement getPurchaseType() {
        return purchaseType;
    }

    public WebElement getVehicleOwner() {
        return vehicleOwner;
    }

    public WebElement getPrimaryUse() {
        return primaryUse;
    }

    public WebElement getParking() {
        return parking;
    }

    public String getSelectVehicleOwner(String s) {
        Select select = new Select(getVehicleOwner());
        select.selectByVisibleText(s);
        return select.getFirstSelectedOption().getText();
    }

    public String getSelectPrimaryUse(String s) {
        Select select = new Select(getPrimaryUse());
        select.selectByVisibleText(s);
        return select.getFirstSelectedOption().getText();
    }

    public void setCommercialUse() {
        this.commercialUse.click();
    }

    public void setLoanedOrRented() {
        this.loanedOrRented.click();
    }

    public String getSelectParking(String s) {
        Select select = new Select(getParking());
        select.selectByVisibleText(s);
        return select.getFirstSelectedOption().getText();
    }

    public void setAnnualMiles(String annualMiles) {
        String script = "arguments[0].setAttribute('value','" + annualMiles + "')";
        js.executeScript(script, getAnnualMiles());
    }

    public WebElement getAnnualMiles() {
        return annualMiles;
    }

    public WebElement getDailyMiles() {
        return dailyMiles;
    }

    public void setDailyMiles(String dailyMiles) {
        String js = "arguments[0].setAttribute('value','" + dailyMiles + "')";
        ((JavascriptExecutor) driver).executeScript(js, getDailyMiles());
    }

}
