package policycenter;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import environment.EnvironmentManager;
import environment.PropertiesManager;
import environment.RunEnvironment;
import listener.WebEventListener;
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
import pages.policycenter.auto.DriversPage;
import pages.policycenter.auto.PolicyInfoPage;
import pages.policycenter.auto.QualificationPage;
import pages.policycenter.landing.AccountSummaryPage;
import pages.policycenter.landing.NewSubmissionPage;
import pages.policycenter.landing.PCHomePage;
import pages.policycenter.landing.PCLoginPage;

import java.io.IOException;

public class AutoSubmissionTest {
    private EventFiringWebDriver eventFiringWebDriver;
    private Connection connection;
    private WebDriver driver;
    JavascriptExecutor js;

    @Before
    public void setup() throws IOException, FilloException {
        EnvironmentManager.initWebDriver();
        driver = RunEnvironment.getWebDriver();
        eventFiringWebDriver = new EventFiringWebDriver(driver);
        WebEventListener eventListener = new WebEventListener();
        eventFiringWebDriver.register(eventListener);
        String filloDatasource = PropertiesManager.getValue("fillo.test.datasource");
        connection = new Fillo().getConnection(filloDatasource);
        js = eventFiringWebDriver;
    }
    @Test
    public void new_auto_submission_test() throws InterruptedException {
        login();
        account_lookup("N001958703");
        start_submission();
        enter_qualification_info();
        enter_policy_info();
        /* add drivers */
        DriversPage driversPage = new DriversPage(eventFiringWebDriver);
        {
            WebDriverWait wait = new WebDriverWait(eventFiringWebDriver, 30);
            wait.until(ExpectedConditions.visibilityOf(driversPage.getPageTitle()));
            Assert.assertTrue(driversPage.isPageOpened("Drivers"));
        }
        driversPage.setAddDriver();
        Thread.sleep(5000);
        driversPage.setAddExistingContact();
        Thread.sleep(5000);
        driversPage.setFirstUnassignedUser();
        Thread.sleep(5000);
//        driversPage.setNext();
    }

    private void enter_policy_info() throws InterruptedException {
        PolicyInfoPage policyInfoPage = new PolicyInfoPage(eventFiringWebDriver);
        {
            WebDriverWait wait = new WebDriverWait(eventFiringWebDriver, 30);
            wait.until(ExpectedConditions.visibilityOf(policyInfoPage.getPageTitle()));
            Assert.assertTrue(policyInfoPage.isPageOpened("Policy Info"));
            policyInfoPage.setNext();
        }
        Thread.sleep(5000);
    }

    private void enter_qualification_info() throws InterruptedException {
        /* qualification page */
        QualificationPage qualificationPage = new QualificationPage(eventFiringWebDriver);
        {
            WebDriverWait wait = new WebDriverWait(eventFiringWebDriver, 120);
            wait.until(ExpectedConditions.visibilityOf(qualificationPage.getPageTitle()));
            Assert.assertTrue(qualificationPage.isPageOpened("Qualification"));
        }
        qualificationPage.setPermissionToOrderReport();
        qualificationPage.setSourceOfBusiness("Testing");
        qualificationPage.setPreQualQuestionOne();
        qualificationPage.setPreQualQuestionTwo();
        qualificationPage.setPreQualQuestionThree();
        qualificationPage.setPreQualQuestionFour();
        qualificationPage.setPreQualQuestionFive();
        qualificationPage.setNext();
        Thread.sleep(5000);
    }

    private void start_submission() throws InterruptedException {
        NewSubmissionPage submissionPage = new NewSubmissionPage(eventFiringWebDriver);
        {
            WebDriverWait wait = new WebDriverWait(eventFiringWebDriver, 10);
            wait.until(ExpectedConditions.visibilityOf(submissionPage.getPageTitle()));
            Assert.assertTrue(submissionPage.isPageOpened());
        }
        submissionPage.personalAutoButtonClick();
        Thread.sleep(5000);
    }

    private void account_lookup(String accountNumber) throws InterruptedException {

        AccountSummaryPage accountSummaryPage = new AccountSummaryPage(eventFiringWebDriver);
        accountSummaryPage.accountTabClick();
        accountSummaryPage.setAccountNumber(accountNumber);
        accountSummaryPage.accountNumberSearchButtonClick();
        {
            WebDriverWait wait = new WebDriverWait(eventFiringWebDriver, 30);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".gw-focus > .gw-label")));
            Assert.assertTrue(accountSummaryPage.isPageOpened());
        }
        accountSummaryPage.newSubmissionButtonClick();
        Thread.sleep(3000);
    }

    private void login() throws InterruptedException {
        PCLoginPage pcLoginPage = new PCLoginPage(eventFiringWebDriver);
        pcLoginPage.setByXPathUsername("su");
        pcLoginPage.setByXPathPassword("gw");
        pcLoginPage.byXPathClickLogin();
        PCHomePage homePage = new PCHomePage(eventFiringWebDriver);
//        Thread.sleep(5000);
        {
            WebDriverWait wait = new WebDriverWait(eventFiringWebDriver, 5);
            wait.until(ExpectedConditions.visibilityOf(homePage.getPageTitle()));
            Assert.assertTrue(homePage.isPageOpened());
        }
    }

    @After
    public void teardown() {
        connection.close();
        eventFiringWebDriver.close();
        driver.quit();
    }
}
