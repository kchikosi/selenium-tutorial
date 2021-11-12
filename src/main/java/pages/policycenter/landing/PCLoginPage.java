package pages.policycenter.landing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 *  Policy Center Page Object encapsulates Login page
 */
public class PCLoginPage {
    private static final String loginPageUrl = "http://localhost:8180/pc/PolicyCenter.do";

    //locators by xpath
    @FindBy(xpath = "//input[@name='Login-LoginScreen-LoginDV-username']")
    private WebElement byXPathUsername;
    @FindBy(xpath = "//input[@name='Login-LoginScreen-LoginDV-password']")
    private WebElement byXPathPassword;
    @FindBy(xpath = "//div[@id='Login-LoginScreen-LoginDV-submit']/div/div[2]")
    private WebElement byXPathSubmitButton;

    public PCLoginPage(WebDriver driver) {
        driver.get(loginPageUrl);
        //initialize elements
        PageFactory.initElements(driver, this);
    }

    public void setByXPathPassword(String password) {
        this.byXPathPassword.clear();
        this.byXPathPassword.sendKeys(password);
    }

    public void setByXPathUsername(String username) {
        this.byXPathUsername.clear();
        this.byXPathUsername.sendKeys(username);
    }

    public void byXPathClickLogin() {this.byXPathSubmitButton.click();}

}
