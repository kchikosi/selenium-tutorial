package pages.policycenter.auto;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * abstract class implementing commonly used methods
 */
public class AutoPolicySubmissionPages {
    //locators
    @FindBy(className = "gw-TitleBar--title")
    private WebElement pageTitle;
    @FindBy(xpath = "//div[@id='SubmissionWizard-Next']/div/div[2]")
    private WebElement next;
    @FindBy(xpath = "//*[@id='SubmissionWizard-LOBWizardStepGroup-LineWizardStepSet-PAVehiclesScreen-JobWizardToolbarButtonSet-Draft']/div/div[2]")
    private WebElement save;
    @FindBy(xpath = "//*[@id='SubmissionWizard-SubmissionWizard_PolicyReviewScreen-JobWizardToolbarButtonSet-QuoteOrReview']/div/div[2]")
    private WebElement quote;

    protected final WebDriver driver;
    protected final JavascriptExecutor js;
    protected final Actions actions;

    public AutoPolicySubmissionPages(WebDriver driver) {
        this.driver = driver;
        this.js = (JavascriptExecutor) driver;
        this.actions = new Actions(driver);
        PageFactory.initElements(this.driver, this);
    }

    public void setNext() {
        this.next.click();
    }

    public WebElement getNext() {
        return next;
    }

    public WebElement getSave() {
        return save;
    }

    public void setSave() {
        this.save.click();
    }

    public WebElement getQuote() {
        return quote;
    }

    public void setQuote() {
        this.quote.click();
    }

    public WebElement getPageTitle() {
        return pageTitle;
    }

    public boolean isPageOpened(String title) {
        return pageTitle.getText().contains(title);
    }

}
