package pages.contactmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CMNewUserContactPage {
    // navigation locators
    @FindBy(xpath = "//div[@id='ABContacts-ContactsMenuActions']/div")
    private WebElement menuActions;
    @FindBy(xpath = "//div[@id='ABContacts-ContactsMenuActions-NewContactPickerMenuItemSet-NewContactPickerMenuItemSet_NewPersonMenuItem']/div/div[2]")
    private WebElement newPerson;
    @FindBy(xpath = "//div[@id='ABContacts-ContactsMenuActions-NewContactPickerMenuItemSet-NewContactPickerMenuItemSet_NewPersonMenuItem-NewContactPickerMenuItemSet_UserContactMenuItem']/div/div[2]")
    private WebElement userContact;
    // input locators
    @FindBy(name = "NewContactPopup-ABContactDetailScreen-ContactBasicsDV-GlobalPersonNameInputSet-Prefix")
    private WebElement prefix;
    @FindBy(xpath = "//option[. = 'Mr.']")
    private WebElement prefixOption;
    @FindBy(name = "NewContactPopup-ABContactDetailScreen-ContactBasicsDV-GlobalPersonNameInputSet-FirstName")
    private WebElement firstName;
    @FindBy(name = "NewContactPopup-ABContactDetailScreen-ContactBasicsDV-GlobalPersonNameInputSet-LastName")
    private  WebElement lastName;
    @FindBy(name = "NewContactPopup-ABContactDetailScreen-ContactBasicsDV-GlobalPersonNameInputSet-Suffix")
    private WebElement suffix;
    @FindBy(xpath = "//option[. = 'Sr.']")
    private WebElement suffixOption;

    @FindBy(name = "NewContactPopup-ABContactDetailScreen-ContactBasicsDV-PrimaryAddressInputSet-AddressOwnerInputSet-globalAddressContainer-GlobalAddressInputSet-AddressLine1")
    private WebElement addressLineOne;
    @FindBy(name = "NewContactPopup-ABContactDetailScreen-ContactBasicsDV-PrimaryAddressInputSet-AddressOwnerInputSet-globalAddressContainer-GlobalAddressInputSet-City")
    private WebElement city;
    @FindBy(xpath = "//option[. = 'California']")
    private WebElement stateOption;
    @FindBy(name = "NewContactPopup-ABContactDetailScreen-ContactBasicsDV-PrimaryAddressInputSet-AddressOwnerInputSet-globalAddressContainer-GlobalAddressInputSet-PostalCode")
    private WebElement postalCode;
    @FindBy(name = "NewContactPopup-ABContactDetailScreen-ContactBasicsDV-PrimaryAddressInputSet-AddressOwnerInputSet-Address_AddressType")
    private WebElement addressType;
    @FindBy(xpath = "//option[. = 'Home']")
    private WebElement addressTypeOption;
    @FindBy(name = "NewContactPopup-ABContactDetailScreen-ContactBasicsDV-PrimaryAddressInputSet-AddressOwnerInputSet-Address_ValidUntil")
    private WebElement validUntil;
    @FindBy(name = "NewContactPopup-ABContactDetailScreen-ContactBasicsDV-ABUserContactBasicsInputSet-EmployeeNumber")
    private WebElement employeeNumber;
    @FindBy(xpath = "//div[@id='NewContactPopup-ABContactDetailScreen-ContactBasicsDV_tb-Update']/div/div[2]")
    private WebElement update;
    @FindBy(xpath = "//div[@id='gw-TabBarWidget--settings']/div/span")
    private WebElement settings;
    @FindBy(xpath = "//div[@id='TabBar-LogoutTabBarLink']/div/div[2]")
    private WebElement logout;



    public CMNewUserContactPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickLogout() {
        this.logout.click();
    }

    public void clickSettings() {
        this.settings.click();
    }

    public void clickUpdate() {
        this.update.click();
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber.sendKeys(employeeNumber);
    }

    public void setValidUntil(String validUntil) {
        this.validUntil.sendKeys(validUntil);
    }

    public void setAddressTypeOption() {
        this.addressTypeOption.click();
    }

    public void selectAddressTypeDropDown() {
        this.addressType.click();
    }

    public void setPostalCode(String postalCode) {
        this.postalCode.sendKeys(postalCode);
    }

    public void selectStateDropDown() {
        this.stateOption.click();
    }

    public void setCity(String city) {
        this.city.sendKeys(city);
    }

    public void setAddressLineOne(String address) {
        this.addressLineOne.sendKeys(address);
    }

    public void setSuffixOption() {
        this.suffixOption.click();
    }

    public void selectSuffixDropdown() {
        this.suffix.click();
    }

    public void setFirstName(String firstName) {
        this.firstName.sendKeys(firstName);
    }

    public void setLastName(String lastName) {
        this.lastName.sendKeys(lastName);
    }

    public void selectPrefixDropDown() {
        this.prefix.click();
    }

    public void setPrefixOption() {
        this.prefixOption.click();
    }
    /**
     * menu actions
     */
    public void clickMenuActions() {
        this.menuActions.click();
    }

    /**
     * new person
     */
    public void clickNewPerson() {
        this.newPerson.click();
    }

    /**
     * new user contact
     *
     * @return user contact option
     */
    public WebElement getUserContact() {
        return userContact;
    }
}
