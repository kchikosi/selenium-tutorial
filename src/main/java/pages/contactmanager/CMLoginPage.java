package pages.contactmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Contact Manager Login page object
 */
public class CMLoginPage {
    //locators
    @FindBy(name = "Login-LoginScreen-LoginDV-username")
    private WebElement username;
    @FindBy(name = "Login-LoginScreen-LoginDV-password")
    private WebElement password;
    @FindBy(xpath = "//div[@id='Login-LoginScreen-LoginDV-submit']/div/div[2]")
    private WebElement submitButton;
    @FindBy(className = "gw-TitleBar--title")
    private WebElement pageTitle;

    public CMLoginPage(WebDriver driver) {
        String loginPageUrl = "http://localhost:8880/ab/ContactManager.do";
        driver.get(loginPageUrl);
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

    public void loginSubmit() {
        this.submitButton.click();
    }

    public boolean isPageOpened() {
        return pageTitle.getText().contains("Search");
    }
}
