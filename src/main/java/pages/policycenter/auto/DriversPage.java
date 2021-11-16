package pages.policycenter.auto;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

/**
 * page object encapsulates driver's page
 */
public class DriversPage extends AutoPolicySubmissionPages {
    // locators
    @FindBy(xpath = "//div[@id='SubmissionWizard-LOBWizardStepGroup-LineWizardStepSet-PADriversScreen-PADriversPanelSet-DriversListDetailPanel-DriversLV_tb-AddDriver']/div[@class='gw-action--inner']/div[@class='gw-label']")
    private WebElement addDriver;

    @FindBy(xpath = "//div[@id='SubmissionWizard-LOBWizardStepGroup-LineWizardStepSet-PADriversScreen-PADriversPanelSet-DriversListDetailPanel-DriversLV_tb-AddDriver-AddExistingContact']/div[@class='gw-action--inner']/div[@class='gw-label']")
    private WebElement addExistingContact;

    @FindBy(xpath = "//div[@id='SubmissionWizard-LOBWizardStepGroup-LineWizardStepSet-PADriversScreen-PADriversPanelSet-DriversListDetailPanel-DriversLV_tb-AddDriver-AddExistingContact-0-UnassignedDriver']/div[@class='gw-action--inner gw-hasDivider']/div[@class='gw-label']")
    private WebElement firstUnassignedUser;

    @FindBy(xpath = "//td[@id='SubmissionWizard-LOBWizardStepGroup-LineWizardStepSet-PADriversScreen-PADriversPanelSet-DriversListDetailPanel-DriversLV-0-Name_Cell']")
    private WebElement driverListDetail;

    @FindBy(xpath = "//input[@name='SubmissionWizard-LOBWizardStepGroup-LineWizardStepSet-PADriversScreen-PADriversPanelSet-DriversListDetailPanel-DriverDetailsCV-PolicyContactDetailsDV-PolicyContactRoleNameInputSet-FirstName']")
    private WebElement firstNameInput;

    @FindBy(xpath = "//input[@name='SubmissionWizard-LOBWizardStepGroup-LineWizardStepSet-PADriversScreen-PADriversPanelSet-DriversListDetailPanel-DriverDetailsCV-PolicyContactDetailsDV-PolicyContactRoleNameInputSet-LastName']")
    private WebElement lastNameInput;

    @FindBy(xpath = "//select[@name='SubmissionWizard-LOBWizardStepGroup-LineWizardStepSet-PADriversScreen-PADriversPanelSet-DriversListDetailPanel-DriverDetailsCV-PolicyContactDetailsDV-PolicyContactRoleNameInputSet-salutation']")
    private WebElement salutation;

    @FindBy(xpath = "//input[@name='SubmissionWizard-LOBWizardStepGroup-LineWizardStepSet-PADriversScreen-PADriversPanelSet-DriversListDetailPanel-DriverDetailsCV-PolicyContactDetailsDV-PolicyContactRoleNameInputSet-DateOfBirth']")
    private WebElement dateOfBirth;

    @FindBy(xpath = "//select[@name='SubmissionWizard-LOBWizardStepGroup-LineWizardStepSet-PADriversScreen-PADriversPanelSet-DriversListDetailPanel-DriverDetailsCV-PolicyContactDetailsDV-PolicyContactRoleNameInputSet-addl_details-gender']")
    private WebElement gender;

    @FindBy(xpath = "//select[@name='SubmissionWizard-LOBWizardStepGroup-LineWizardStepSet-PADriversScreen-PADriversPanelSet-DriversListDetailPanel-DriverDetailsCV-PolicyContactDetailsDV-PolicyContactRoleNameInputSet-addl_details-MaritalStatus']")
    private WebElement maritalStatus;

    @FindBy(xpath = "//select[@name='SubmissionWizard-LOBWizardStepGroup-LineWizardStepSet-PADriversScreen-PADriversPanelSet-DriversListDetailPanel-DriverDetailsCV-PolicyContactDetailsDV-LicenseInputSet-LicenseType']")
    private WebElement licenceType;

    @FindBy(xpath = "//input[@name='SubmissionWizard-LOBWizardStepGroup-LineWizardStepSet-PADriversScreen-PADriversPanelSet-DriversListDetailPanel-DriverDetailsCV-PolicyContactDetailsDV-LicenseInputSet-LicenseDate']")
    private WebElement licenceDate;

    public DriversPage(WebDriver driver) {
        super(driver);
    }

    public void setAddDriver() {
        addDriver.click();
    }

    public void setAddExistingContact() {
        actions.moveToElement(addExistingContact).perform();
        actions.moveToElement(firstUnassignedUser).perform();
    }

    public void setFirstUnassignedUser() {
        actions.click(firstUnassignedUser).perform();
    }

    public WebElement getDriverListDetail() {
        return driverListDetail;
    }

    public WebElement getFirstNameInput() {
        return firstNameInput;
    }

    public WebElement getLastNameInput() {
        return lastNameInput;
    }

    public WebElement getSalutation() {
        return salutation;
    }

    /**
     * get selected option from salutation dropdown
     * @return string
     */
    public String getSelectedSalutation() {
        Select select = new Select(getSalutation());
        return select.getFirstSelectedOption().getText();
    }

    public WebElement getDateOfBirth() {
        return dateOfBirth;
    }

    public WebElement getGender() {
        return gender;
    }

    public WebElement getMaritalStatus() {
        return maritalStatus;
    }

    public WebElement getLicenceType() {
        return licenceType;
    }

    public WebElement getLicenceDate() {
        return licenceDate;
    }

    public String getSelectedGender() {
        Select select = new Select(getGender());
        return select.getFirstSelectedOption().getText();
    }

    public String getSelectedMaritalStatus() {
        Select select = new Select(getMaritalStatus());
        return select.getFirstSelectedOption().getText();
    }

    public String getSelectedLicenceType() {
        Select select = new Select(getLicenceType());
        return select.getFirstSelectedOption().getText();
    }
}
