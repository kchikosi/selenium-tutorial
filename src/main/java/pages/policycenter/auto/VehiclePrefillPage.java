package pages.policycenter.auto;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * page object encapsulates vehicle prefill page
 */
public class VehiclePrefillPage extends  AutoPolicySubmissionPages {
    //locators
    @FindBy(xpath = "//*[@id='ViewPrefillReportVehiclePopup-ViewPrefilVehicleslReportsScreen-VehiclePrefillLV-0-_Checkbox']/input")
    private WebElement firstCheckbox;
    @FindBy(xpath = "//*[@id='ViewPrefillReportVehiclePopup-ViewPrefilVehicleslReportsScreen-AddVehiclesCheckboxButton']/div/div[2]")
    private WebElement addVehicles;

    public VehiclePrefillPage(WebDriver driver) {
        super(driver);
    }

    public void setFirstCheckbox() {
        this.firstCheckbox.click();
    }

    public void setAddVehicles() {
        this.addVehicles.click();
    }
}
