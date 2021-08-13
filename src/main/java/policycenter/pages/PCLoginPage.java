package policycenter.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 *  Page Object encapsulates Login page
 */
public class PCLoginPage {
    private final String loginPageUrl = "http://localhost:8180/pc/PolicyCenter.do";
    WebDriver driver;
    private By usernameBy = By.name("Login-LoginScreen-LoginDV-username");
    private By passwordBy = By.name("Login-LoginScreen-LoginDV-password");
    private By submitBy = By.id("Login-LoginScreen-LoginDV-submit");

    public PCLoginPage(WebDriver driver) {
        this.driver = driver;
        driver.navigate().to(this.loginPageUrl);
    }

    public PCHomePage loginValidUser(String username, String password) {
        driver.findElement(usernameBy).sendKeys(username);
        driver.findElement(passwordBy).sendKeys(password);
        driver.findElement(submitBy).click();
        return new PCHomePage(driver);
    }
}
