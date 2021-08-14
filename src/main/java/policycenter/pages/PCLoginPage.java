package policycenter.pages;

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

    //locators
    @FindBy(name = "Login-LoginScreen-LoginDV-username")
    private WebElement username;
    @FindBy(name = "Login-LoginScreen-LoginDV-password")
    private WebElement password;
    @FindBy(id = "Login-LoginScreen-LoginDV-submit")
    private WebElement submitButton;

    public PCLoginPage(WebDriver driver) {
        this.driver = driver;
        driver.get(loginPageUrl);
        //initialize elements
        PageFactory.initElements(driver, this);
    }

    public void setUsername(String username) {
        this.username.clear();
        this.username.sendKeys(username);
    }

    public void setPassword(String password) {
        this.password.clear();
        this.password.sendKeys(password);
    }

    public void clickLogin() {
        this.submitButton.click();
    }

}
