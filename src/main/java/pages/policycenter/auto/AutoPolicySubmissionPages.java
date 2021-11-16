package pages.policycenter.auto;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

    protected final WebDriver driver;
    protected final JavascriptExecutor js;

    public AutoPolicySubmissionPages(WebDriver driver) {
        this.driver = driver;
        this.js = (JavascriptExecutor) driver;
        PageFactory.initElements(this.driver, this);
    }

    public void setNext() {
        this.next.click();
    }

    public WebElement getPageTitle() {
        return pageTitle;
    }

    public boolean isPageOpened(String title) {
        return pageTitle.getText().contains(title);
    }

}
