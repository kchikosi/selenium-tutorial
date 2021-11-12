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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.policycenter.auto.QualificationPage;
import pages.policycenter.landing.AccountSummaryPage;
import pages.policycenter.landing.NewSubmissionPage;
import pages.policycenter.landing.PCHomePage;
import pages.policycenter.landing.PCLoginPage;

import java.io.IOException;

public class NewAutoSubmissionTest {
    private EventFiringWebDriver eventFiringWebDriver;
    private Connection connection;
    private WebDriver driver;

    @Before
    public void setUp() throws IOException, FilloException {
        EnvironmentManager.initWebDriver();
        driver = RunEnvironment.getWebDriver();
        eventFiringWebDriver = new EventFiringWebDriver(driver);
        WebEventListener eventListener = new WebEventListener();
        eventFiringWebDriver.register(eventListener);
        String filloDatasource = PropertiesManager.getValue("fillo.test.datasource");
        connection = new Fillo().getConnection(filloDatasource);
    }
    @Test
    public void test_newAutoSubmission() throws InterruptedException {
        login();
        accountLookup("N001958703");
        NewSubmissionPage submissionPage = new NewSubmissionPage(eventFiringWebDriver);
        Assert.assertTrue(submissionPage.isPageOpened());
        submissionPage.personalAutoButtonClick();
        Thread.sleep(3000);
        /* qualification page */
        QualificationPage qualificationPage = new QualificationPage(eventFiringWebDriver);
        {
            WebDriverWait wait = new WebDriverWait(eventFiringWebDriver, 30);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='gw-TitleBar--title']")));
            Assert.assertTrue(qualificationPage.isPageOpened());
        }
        qualificationPage.setPermissionToOrderReport();
        qualificationPage.setSourceOfBusiness("Testing only - Non-Inquiry or Misc. Records");
        qualificationPage.setPreQualQuestionOne();
        qualificationPage.setPreQualQuestionTwo();
        qualificationPage.setPreQualQuestionThree();
        qualificationPage.setPreQualQuestionFour();
        qualificationPage.setPreQualQuestionFive();
//        qualificationPage.setNext();
        Thread.sleep(5000);
    }

    private void accountLookup(String accountNumber) throws InterruptedException {

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
        Thread.sleep(5000);
    }

    private void login() throws InterruptedException {
        PCLoginPage pcLoginPage = new PCLoginPage(eventFiringWebDriver);
        pcLoginPage.setByXPathUsername("su");
        pcLoginPage.setByXPathPassword("gw");
        pcLoginPage.byXPathClickLogin();
        PCHomePage homePage = new PCHomePage(eventFiringWebDriver);
        Thread.sleep(5000);
        Assert.assertTrue(homePage.isPageOpened());
    }

    @After
    public void tearDown() {
        connection.close();
        eventFiringWebDriver.close();
        driver.quit();
    }
}
