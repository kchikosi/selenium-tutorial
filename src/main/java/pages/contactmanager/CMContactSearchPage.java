package pages.contactmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CMContactSearchPage {
    //locators
    @FindBy(name = "ABContactSearch-ABContactSearchScreen-ContactSearchDV-GlobalContactNameInputSet-Name")
    private WebElement name;
    @FindBy(id = "ABContactSearch-ABContactSearchScreen-ContactSearchDV-SearchAndResetInputSet-SearchLinksInputSet-Search")
    private WebElement clickSearch;
    @FindBy(xpath = "//div[@id='gw-TabBarWidget--settings']/div/span")
    private WebElement clickSettingsDropDown;
    @FindBy(xpath = "//div[@id='TabBar-LogoutTabBarLink']/div/div[2]")
    private WebElement clickLogout;

    /**
     * driver passed in from login process
     * @param driver
     */
    public CMContactSearchPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    /**
     * set search criteria
     * @param name
     */
    public void setName(String name) {
        this.name.clear();
        this.name.sendKeys(name);
    }
    /**
     * submit search criteria
     */
    public void clickSearch() {
        this.clickSearch.click();
    }
    /**
     * settings dropdown
     */
    public void clickSettingsDropDown() {
        this.clickSettingsDropDown.click();
    }
    /**
     * logout
     */
    public void clickLogout() {
        this.clickLogout.click();
    }
}
