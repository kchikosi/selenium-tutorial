package pages.claimcenter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 *  Policy Center Page Object encapsulates Login page
 */
public class CCLoginPage {
    private static final String loginPageUrl = "http://localhost:8080/cc/ClaimCenter.do";

    //locators by xpath
    @FindBy(xpath = "//input[@id='Login:LoginScreen:LoginDV:username-inputEl']")
    private WebElement byXPathUsername;
    @FindBy(xpath = "//input[@id='Login:LoginScreen:LoginDV:password-inputEl']" )
    private WebElement byXPathPassword;
    @FindBy(xpath = "//span[@id='Login:LoginScreen:LoginDV:submit-btnInnerEl']")
    private WebElement byXPathSubmitButton;

    public CCLoginPage(WebDriver driver) {
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
