package policycenter.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 *  Page Object encapsulates Login page
 */
public class PCLoginPage {
    private static final String loginPageUrl = "http://localhost:8180/pc/PolicyCenter.do";
    private final WebDriver driver;

    //locators by name-id
    @FindBy(name = "Login-LoginScreen-LoginDV-username")
    private WebElement byNameUsername;
    @FindBy(name = "Login-LoginScreen-LoginDV-password")
    private WebElement byNamePassword;
    @FindBy(id = "Login-LoginScreen-LoginDV-submit")
    private WebElement byIdSubmitButton;

    //locators by xpath
    @FindBy(xpath = "//input[@name=\'Login-LoginScreen-LoginDV-username\']")
    private WebElement byXPathUsername;
    @FindBy(xpath = "//input[@name=\'Login-LoginScreen-LoginDV-password\']")
    private WebElement byXPathPassword;
    @FindBy(xpath = "//div[@id=\'Login-LoginScreen-LoginDV-submit\']/div/div[2]")
    private WebElement byXPathSubmitButton;




    public PCLoginPage(WebDriver driver) {
        this.driver = driver;
        driver.get(loginPageUrl);
        //initialize elements
        PageFactory.initElements(driver, this);
    }

    public void setByNameUsername(String username) {
        this.byNameUsername.clear();
        this.byNameUsername.sendKeys(username);
    }

    public void setByNamePassword(String password) {
        this.byNamePassword.clear();
        this.byNamePassword.sendKeys(password);
    }

    public void setByXPathPassword(String password) {
        this.byXPathPassword.clear();
        this.byXPathPassword.sendKeys(password);
    }

    public void setByXPathUsername(String username) {
        this.byXPathUsername.clear();
        this.byXPathUsername.sendKeys(username);
    }

    public void byIdClickLogin() {
        this.byIdSubmitButton.click();
    }

    public void byXPathClickLogin() {this.byXPathSubmitButton.click();}
}
