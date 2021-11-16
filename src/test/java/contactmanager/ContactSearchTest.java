package contactmanager;

import com.codoid.products.exception.FilloException;
import environment.EnvironmentManager;
import environment.PropertiesManager;
import environment.RunEnvironment;
import fillo.FilloHelper;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.contactmanager.CMContactSearchPage;
import pages.contactmanager.CMLoginPage;
import listener.WebEventListener;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class ContactSearchTest {
    private WebDriver driver;
    private EventFiringWebDriver eventFiringWebDriver;
    JavascriptExecutor js;

    @Before
    public void setup() throws IOException {
        EnvironmentManager.initWebDriver();
        driver = RunEnvironment.getWebDriver();
        eventFiringWebDriver = new EventFiringWebDriver(driver);
        WebEventListener eventListener = new WebEventListener();
        eventFiringWebDriver.register(eventListener);
        String filloDatasource = PropertiesManager.getValue("fillo.test.datasource");
        js = (JavascriptExecutor) driver;
    }

    @After
    public void teardown() {
        eventFiringWebDriver.close();
        driver.quit();
    }

    /**
     * login into contact manager application
     * enter search criteria, name only
     *
     * @throws InterruptedException
     */
    @Test
    public void contact_search_test() throws InterruptedException, FilloException, IOException {
        String query = "select * from testcases where testcaseid = 'TC003'";
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
        Thread.sleep(2000);
        CMContactSearchPage contactSearchPage = new CMContactSearchPage(eventFiringWebDriver);
        Optional<String> name = FilloHelper.getDataByColumnName(testSteps, "COMPANYNAME");
        contactSearchPage.setName(name.get());
        contactSearchPage.clickSearch();
        {
            WebDriverWait wait = new WebDriverWait(eventFiringWebDriver, 30);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("gw-ListView--UI--title")));
        }
        Thread.sleep(2000);
        contactSearchPage.clickSettingsDropDown();
        contactSearchPage.clickLogout();
        {
            WebDriverWait wait = new WebDriverWait(eventFiringWebDriver, 30);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Login-LoginScreen-LoginDV-1")));
        }
        Thread.sleep(2000);
    }
}