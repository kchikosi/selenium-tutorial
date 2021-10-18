package contactmanager;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
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
import seleniumtestframework.listener.WebEventListener;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class ContactSearchTest {
    private WebDriver driver;
    private EventFiringWebDriver eventFiringWebDriver;
    private Connection connection;
    private Map<String, Object> vars;
    JavascriptExecutor js;

    @Before
    public void setUp() throws IOException, FilloException {
        EnvironmentManager.initWebDriver();
        driver = RunEnvironment.getWebDriver();
        eventFiringWebDriver = new EventFiringWebDriver(driver);
        WebEventListener eventListener = new WebEventListener();
        eventFiringWebDriver.register(eventListener);
        String filloDatasource = PropertiesManager.getValue("fillo.test.datasource");
        connection = new Fillo().getConnection(filloDatasource);
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
    }

    @After
    public void tearDown() {
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
    public void contactSearch_test() throws InterruptedException, FilloException, IOException {
        String query = "select * from testcases where testcaseid = 'TC003'";
        List<Map<String, String>> testSteps = FilloHelper.getStepsList(query);
        Optional<String> user = FilloHelper.getDataByColumnName(testSteps, "USERNAME");
        Optional<String> passwd = FilloHelper.getDataByColumnName(testSteps, "PASSWORD");

        CMLoginPage cmLoginPage = new CMLoginPage(eventFiringWebDriver);
        cmLoginPage.setUsername(user.get());
        cmLoginPage.setPassword(passwd.get());
        cmLoginPage.loginSubmit();
        {
            WebDriverWait wait = new WebDriverWait(eventFiringWebDriver, 30);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("gw-TitleBar--title")));
        }
        Assert.assertTrue(cmLoginPage.isPageOpened());
        js.executeScript("alert('logged in successfully');");
        Thread.sleep(4000);
        CMContactSearchPage contactSearchPage = new CMContactSearchPage(eventFiringWebDriver);
        Optional<String> name = FilloHelper.getDataByColumnName(testSteps, "COMPANYNAME");
        contactSearchPage.setName(name.get());
        contactSearchPage.clickSearch();
        {
            WebDriverWait wait = new WebDriverWait(eventFiringWebDriver, 30);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("gw-ListView--UI--title")));
        }

        contactSearchPage.clickSettingsDropDown();
        contactSearchPage.clickLogout();
        {
            WebDriverWait wait = new WebDriverWait(eventFiringWebDriver, 30);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Login-LoginScreen-LoginDV-1")));
        }
//        Thread.sleep(5000);
    }
}