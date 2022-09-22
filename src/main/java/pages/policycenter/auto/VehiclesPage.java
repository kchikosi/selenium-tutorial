package pages.policycenter.auto;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class VehiclesPage extends AutoPolicySubmissionPages {
    private final JavascriptExecutor js;
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
    @FindBy(xpath = "//*[@id='SubmissionWizard-LOBWizardStepGroup-LineWizardStepSet-PAVehiclesScreen-PAVehiclesPanelSet-VehiclesListDetailPanel-VehiclesDetailsCV-PersonalAuto_VehicleDV-BasicVehicleInfoExtInputSet-BodyType_DV']/div/div/select")
    private WebElement bodyType;
    @FindBy(xpath = "//*[@id='SubmissionWizard-LOBWizardStepGroup-LineWizardStepSet-PAVehiclesScreen-PAVehiclesPanelSet-VehiclesListDetailPanel-VehiclesDetailsCV-PersonalAuto_VehicleDV-AntiLockBrakesIter-0-TypeKeyModifier']/div/div/select")
    private WebElement antiLockBrakes;
    @FindBy(xpath = "//*[@id='SubmissionWizard-LOBWizardStepGroup-LineWizardStepSet-PAVehiclesScreen-PAVehiclesPanelSet-VehiclesListDetailPanel-VehiclesDetailsCV-PersonalAuto_VehicleDV-PassiveRestraintIter-0-TypeKeyModifier']/div/div/select")
    private WebElement passiveRestraint;
    @FindBy(xpath = "//*[@id='SubmissionWizard-LOBWizardStepGroup-LineWizardStepSet-PAVehiclesScreen-PAVehiclesPanelSet-VehiclesListDetailPanel-VehiclesDetailsCV-PersonalAuto_VehicleDV-AntiTheftIter-0-AntiTheftModifier']/div/div/select")
    private WebElement antiTheft;
    @FindBy(xpath = "//*[@id='SubmissionWizard-LOBWizardStepGroup-LineWizardStepSet-PAVehiclesScreen-PAVehiclesPanelSet-VehiclesListDetailPanel-VehiclesDetailsCV-PersonalAuto_VehicleDV-ElectronicStabilityControlIter-0-BooleanModifier_1']")
    private WebElement electronicStabilityControlNo;
    @FindBy(xpath = "//*[@id='SubmissionWizard-LOBWizardStepGroup-LineWizardStepSet-PAVehiclesScreen-PAVehiclesPanelSet-VehiclesListDetailPanel-VehiclesDetailsCV-PersonalAuto_VehicleDV-ElectronicStabilityControlIter-0-BooleanModifier_0']")
    private WebElement electronicStabilityControlYes;
    @FindBy(xpath = "//*[@id='SubmissionWizard-LOBWizardStepGroup-LineWizardStepSet-PAVehiclesScreen-PAVehiclesPanelSet-VehiclesListDetailPanel-VehiclesDetailsCV-PersonalAuto_VehicleDV-BasicVehicleInfoExtInputSet-VehicleSymbol']/div/input")
    private WebElement symbol;
    @FindBy(xpath = "//*[@id='SubmissionWizard-LOBWizardStepGroup-LineWizardStepSet-PAVehiclesScreen-PAVehiclesPanelSet-VehiclesListDetailPanel-VehiclesDetailsCV-PersonalAuto_VehicleDV-FwdCollWarnSysIter-0-TypeKeyModifier']/div/div/select")
    private WebElement fwdCollisionWarningSystem;
    @FindBy(xpath = "//*[@id='SubmissionWizard-LOBWizardStepGroup-LineWizardStepSet-PAVehiclesScreen-PAVehiclesPanelSet-VehiclesListDetailPanel-VehiclesDetailsCV-PersonalAuto_VehicleDV-CostNew_DV']/div/input")
    private WebElement cost;
    @FindBy(xpath = "//*[@id='SubmissionWizard-LOBWizardStepGroup-LineWizardStepSet-PAVehiclesScreen-PAVehiclesPanelSet-VehiclesListDetailPanel-VehiclesDetailsCV-PersonalAuto_VehicleDV-MSRP']/div/input")
    private WebElement msrp;
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
    private WebElement commercialUseNo;
    @FindBy(xpath = "//*[@id='SubmissionWizard-LOBWizardStepGroup-LineWizardStepSet-PAVehiclesScreen-PAVehiclesPanelSet-VehiclesListDetailPanel-VehiclesDetailsCV-PersonalAuto_VehicleDV-LoanedOrRented_1']")
    private WebElement loanedOrRentedNo;
    @FindBy(xpath = "//*[@id='SubmissionWizard-LOBWizardStepGroup-LineWizardStepSet-PAVehiclesScreen-PAVehiclesPanelSet-VehiclesListDetailPanel-VehiclesDetailsCV-PersonalAuto_VehicleDV-Parking']/div/div/select")
    private WebElement parking;


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

    public void setNewUsed() {
        //TODO: add select option code
    }

    public WebElement getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(String s) {
        purchaseDate.sendKeys(s);
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
        this.commercialUseNo.click();
    }

    public void setLoanedOrRentedNo() {
        this.loanedOrRentedNo.click();
    }

    public WebElement getLoanedOrRentedNo() {
        return loanedOrRentedNo;
    }

    public String getSelectParking(String s) {
        Select select = new Select(getParking());
        select.selectByVisibleText(s);
        return select.getFirstSelectedOption().getText();
    }

    public WebElement getAnnualMiles() {
        return annualMiles;
    }

    public void setAnnualMiles(String annualMiles) {
        String script = "arguments[0].setAttribute('value','" + annualMiles + "')";
        js.executeScript(script, getAnnualMiles());
    }

    public WebElement getDailyMiles() {
        return dailyMiles;
    }

    public void setDailyMiles(String dailyMiles) {
        String js = "arguments[0].setAttribute('value','" + dailyMiles + "')";
        ((JavascriptExecutor) driver).executeScript(js, getDailyMiles());
    }

    public WebElement getBodyType() {
        return bodyType;
    }

    public String getSelectBodyType(String s) {
        Select select = new Select(getBodyType());
        select.selectByVisibleText(s);
        return select.getFirstSelectedOption().getText();
    }

    public String getSelectNewUsed(String s) {
        Select select = new Select(getNewUsed());
        select.selectByVisibleText(s);
        return select.getFirstSelectedOption().getText();
    }

    public void setCost(String cost) {
        this.cost.sendKeys(cost);
    }

    public void setMsrp(String msrp) {
        this.msrp.sendKeys(msrp);
    }

    public WebElement getAntiLockBrakes() {
        return antiLockBrakes;
    }

    public WebElement getPassiveRestraint() {
        return passiveRestraint;
    }

    public WebElement getAntiTheft() {
        return antiTheft;
    }

    public WebElement getFwdCollisionWarningSystem() {
        return fwdCollisionWarningSystem;
    }

    public String getSelectAntiLockBrakes(String s) {
        Select select = new Select(getAntiLockBrakes());
        select.selectByVisibleText(s);
        return select.getFirstSelectedOption().getText();
    }

    public String getSelectPassiveRestraint(String s) {
        Select select = new Select(getPassiveRestraint());
        select.selectByVisibleText(s);
        return select.getFirstSelectedOption().getText();
    }

    public String getSelectAntiTheft(String s) {
        Select select = new Select(getAntiTheft());
        select.selectByVisibleText(s);
        return select.getFirstSelectedOption().getText();
    }

    public String getSelectFwdCollisionWarningSystem(String s) {
        Select select = new Select(getFwdCollisionWarningSystem());
        select.selectByVisibleText(s);
        return select.getFirstSelectedOption().getText();
    }

    public void setElectronicStabilityControlYes() {
        this.electronicStabilityControlYes.click();
    }

    public void setElectronicStabilityControlNo() {
        this.electronicStabilityControlNo.click();
    }

    public WebElement getCommercialUseNo() {
        return commercialUseNo;
    }

    public WebElement getSymbol() {
        return symbol;
    }

    public void setSymbol(String s) {
        this.symbol.sendKeys(s);
    }

    public WebElement getElectronicStabilityControlNo() {
        return electronicStabilityControlNo;
    }
}
