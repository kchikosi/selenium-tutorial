package contactmanager;
// Generated by Selenium IDE

import com.codoid.products.exception.FilloException;
import environment.EnvironmentManager;
import environment.RunEnvironment;
import fillo.FilloHelper;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.contactmanager.CMLoginPage;
import pages.contactmanager.CMNewUserContactPage;
import listener.WebEventListener;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

//TODO: add Fillo framework
public class AddNewContactTest {
    private WebDriver driver;
    private EventFiringWebDriver eventFiringWebDriver;
    JavascriptExecutor js;
    @Before
    public void setUp() throws IOException {
        EnvironmentManager.initWebDriver();
        driver = RunEnvironment.getWebDriver();
        eventFiringWebDriver = new EventFiringWebDriver(driver);
        WebEventListener eventListener = new WebEventListener();
        eventFiringWebDriver.register(eventListener);
        js = eventFiringWebDriver;
    }
    @After
    public void tearDown() {
        eventFiringWebDriver.close();
        driver.quit();
    }

    /**
     * add new contact to Contact manager
     */
    @Test
    public void addNewContact_test() throws FilloException, IOException, InterruptedException {
        String query = "select * from testcases where testcaseid = 'ADD_NEW_CONTACT'";
        List<Map<String, String>> testSteps = FilloHelper.getStepsList(query);
        Optional<String> user = FilloHelper.getDataByColumnName(testSteps, "USERNAME");
        Optional<String> passwd = FilloHelper.getDataByColumnName(testSteps, "PASSWORD");

        CMLoginPage cmLoginPage = new CMLoginPage(eventFiringWebDriver);
        cmLoginPage.setUsername(user.orElse(null));
        cmLoginPage.setPassword(passwd.orElse(null));
        cmLoginPage.loginSubmit();
        {
            WebDriverWait wait = new WebDriverWait(eventFiringWebDriver, 30);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("gw-TitleBar--title")));
        }
        Assert.assertTrue(cmLoginPage.isPageOpened());
        Thread.sleep(4000);
        CMNewUserContactPage userContact = new CMNewUserContactPage(eventFiringWebDriver);
        userContact.clickMenuActions();
        userContact.clickNewPerson();
        {
            WebElement element = eventFiringWebDriver.findElement(By.cssSelector(".gw-focus > .gw-label"));
            Actions builder = new Actions(eventFiringWebDriver);
            builder.doubleClick(element).perform();
        }
        // use JavascriptExecutor to resolve ElementNotInteractableException
        js.executeScript("arguments[0].click();", userContact.getUserContact());
        {
            WebDriverWait wait = new WebDriverWait(eventFiringWebDriver, 30);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("NewContactPopup-ABContactDetailScreen-ContactBasicsDV-GlobalPersonNameInputSet-Prefix")));
        }
        userContact.selectPrefixDropDown();
        userContact.setPrefixOption();
        userContact.setFirstName("Jim");
        userContact.setLastName("Brown");
        userContact.selectSuffixDropdown();
        userContact.setSuffixOption();
        userContact.setAddressLineOne("794 Mcallister St");
        userContact.setCity("San Francisco");
        userContact.selectStateDropDown();
        userContact.setPostalCode("94102-####");
        userContact.selectAddressTypeDropDown();
        userContact.setAddressTypeOption();
        userContact.setValidUntil("10/31/2021");
        userContact.setEmployeeNumber("333-333-3333");
        userContact.clickUpdate();
        userContact.clickSettings();
        userContact.clickLogout();
        Thread.sleep(3000);
    }
}
