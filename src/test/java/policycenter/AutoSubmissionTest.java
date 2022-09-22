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
import org.openqa.selenium.*;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.policycenter.auto.*;
import pages.policycenter.landing.AccountSummaryPage;
import pages.policycenter.landing.NewSubmissionPage;
import pages.policycenter.landing.PCHomePage;
import pages.policycenter.landing.PCLoginPage;

import java.io.IOException;

public class AutoSubmissionTest {
    JavascriptExecutor js;
    private EventFiringWebDriver eventFiringWebDriver;
    private Connection connection;
    private WebDriver driver;

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
        //TODO: remove hard-coding with Fillo
        account_lookup("N001958703");
        start_submission();
        enter_qualification_info();
        enter_policy_info();
        add_drivers();
        create_vehicle_from_prefill();
        enter_loss_violations();
        enter_rating_inputs();
        /* SxS quoting */
        SxSQuotingPage sxsQuotingPage = new SxSQuotingPage(eventFiringWebDriver);
        {
            WebDriverWait wait = new WebDriverWait(eventFiringWebDriver, 120);
            wait.until(ExpectedConditions.visibilityOf(sxsQuotingPage.getPageTitle()));
            //TODO: remove hard-coding with Fillo
            Assert.assertTrue(sxsQuotingPage.isPageOpened("SxS Quoting"));
        }
        //TODO: save draft before next
        sxsQuotingPage.setNext();
        /* risk analysis */
        RiskAnalysisPage riskAnalysisPage = new RiskAnalysisPage(eventFiringWebDriver);
        {
            WebDriverWait wait = new WebDriverWait(eventFiringWebDriver, 120);
            wait.until(ExpectedConditions.visibilityOf(riskAnalysisPage.getPageTitle()));
            //TODO: remove hard-coding with Fillo
            Assert.assertTrue(riskAnalysisPage.isPageOpened("Risk Analysis"));
        }
        riskAnalysisPage.setNext();
        Thread.sleep(3000);
        /* policy review */
        PolicyReviewPage policyReviewPage = new PolicyReviewPage(eventFiringWebDriver);
        {
            WebDriverWait wait = new WebDriverWait(eventFiringWebDriver, 120);
            wait.until(ExpectedConditions.visibilityOf(policyReviewPage.getPageTitle()));
            //TODO: remove hard-coding with Fillo
            Assert.assertTrue(policyReviewPage.isPageOpened("Policy Review"));
        }
        /* click evaluate risk, hit alert button */
        policyReviewPage.setEvaluateRisk();
        eventFiringWebDriver.switchTo().alert().accept();
        /* try to quote */
        policyReviewPage.setQuote();
        Thread.sleep(3000);


    }

    private void enter_rating_inputs() {
        /* rating inputs page */
        RatingsInputPage ratingsInputPage = new RatingsInputPage(eventFiringWebDriver);
        {
            WebDriverWait wait = new WebDriverWait(eventFiringWebDriver, 120);
            wait.until(ExpectedConditions.visibilityOf(ratingsInputPage.getPageTitle()));
            //TODO: remove hard-coding with Fillo
            Assert.assertTrue(ratingsInputPage.isPageOpened("Rating Inputs"));
        }
        //TODO: remove hard-coding with Fillo
        ratingsInputPage.getSelectedLifePolicyCount("0");
        ratingsInputPage.getSelectedHomeOwnership("No");
        ratingsInputPage.getSelectedFurnishedAutos("0");
        ratingsInputPage.setHasOtherVehiclesNo();
        ratingsInputPage.setHasPriorPolicyNo();
        ratingsInputPage.setPaidInFullDiscountNo();
        ratingsInputPage.seteDiscountNo();
        ratingsInputPage.setAutoPayDiscountNo();
        //TODO: add assertions and save before next
        ratingsInputPage.setNext();
    }

    private void enter_loss_violations() throws InterruptedException {
        /* qualification page */
        LossesViolationsPage lossesViolationsPage = new LossesViolationsPage(eventFiringWebDriver);
        {
            WebDriverWait wait = new WebDriverWait(eventFiringWebDriver, 120);
            wait.until(ExpectedConditions.visibilityOf(lossesViolationsPage.getPageTitle()));
            //TODO: remove hard-coding with Fillo
            Assert.assertTrue(lossesViolationsPage.isPageOpened("Losses/Violations"));
        }
        lossesViolationsPage.setLossViolationsNo();
        lossesViolationsPage.setNext();
        Thread.sleep(5000);
    }

    private void create_vehicle_from_prefill() throws InterruptedException {
        /* add vehicle from prefill */
        VehiclesPage vehiclesPage = new VehiclesPage(eventFiringWebDriver);
        {
            WebDriverWait wait = new WebDriverWait(eventFiringWebDriver, 50);
            wait.until(ExpectedConditions.visibilityOf(vehiclesPage.getPageTitle()));
            //TODO: remove hard-coding with Fillo
            Assert.assertTrue(vehiclesPage.isPageOpened("Vehicles"));
        }
        vehiclesPage.setCreateFromPrefill();
        Thread.sleep(5000);
        VehiclePrefillPage vehiclePrefillPage = new VehiclePrefillPage(eventFiringWebDriver);
        {
            WebDriverWait wait = new WebDriverWait(eventFiringWebDriver, 30);
            wait.until(ExpectedConditions.visibilityOf(vehiclePrefillPage.getPageTitle()));
            //TODO: remove hard-coding with Fillo
            Assert.assertTrue(vehiclePrefillPage.isPageOpened("View Vehicle Prefill Data"));
        }
        vehiclePrefillPage.setFirstCheckbox();
        vehiclePrefillPage.setAddVehicles();
        {
            WebDriverWait wait = new WebDriverWait(eventFiringWebDriver, 50);
            wait.until(ExpectedConditions.visibilityOf(vehiclesPage.getVehicleDetailsCard()));
        }

        vehiclesPage.getSelectBodyType("OTHER");

        {
            WebDriverWait wait = new WebDriverWait(eventFiringWebDriver, 30);
            wait.until(ExpectedConditions.visibilityOf(vehiclesPage.getSymbol()));
            vehiclesPage.setSymbol("F");
            vehiclesPage.getSelectAntiLockBrakes("No anti-lock brakes");
            vehiclesPage.getSelectAntiTheft("No anti-theft");
            Thread.sleep(3000);
            {
//                WebDriverWait wait = new WebDriverWait(eventFiringWebDriver,30);
                wait.until(ExpectedConditions.elementToBeClickable(vehiclesPage.getElectronicStabilityControlNo()));
                vehiclesPage.setElectronicStabilityControlNo();
            }
            vehiclesPage.getSelectPassiveRestraint("None");
            vehiclesPage.getSelectFwdCollisionWarningSystem("None");
        }

        vehiclesPage.getSelectNewUsed("Used");

        //needs to be clicked twice
        while (!vehiclesPage.getCommercialUseNo().isSelected()) {
            vehiclesPage.setCommercialUse();
        }

        vehiclesPage.setLoanedOrRentedNo();

        vehiclesPage.getSelectParking("Garaged");
        vehiclesPage.getSelectPrimaryUse("Other");
        vehiclesPage.getSelectVehicleOwner("Mr. Jim Brown");

        {
            WebDriverWait wait = new WebDriverWait(eventFiringWebDriver,30);
            wait.until(ExpectedConditions.elementToBeClickable(vehiclesPage.getDailyMiles()));
            vehiclesPage.getDailyMiles().sendKeys("24");
            vehiclesPage.getDailyMiles().sendKeys(Keys.TAB);
        }
        {
            WebDriverWait wait = new WebDriverWait(eventFiringWebDriver,30);
            wait.until(ExpectedConditions.elementToBeClickable(vehiclesPage.getAnnualMiles()));
        }

        if (!vehiclesPage.getVehicleOwner().getText().contains("Jim")) {
            vehiclesPage.getSelectVehicleOwner("Mr. Jim Brown");
        }
        /* try to save, some data gets lost during save */
        vehiclesPage.setSave();
        /* check select fields are present */
        Assert.assertTrue(vehiclesPage.getVehicleOwner().getText().contains("Jim"));
        Assert.assertTrue(vehiclesPage.getParking().getText().contains("Garaged"));
        Assert.assertTrue(vehiclesPage.getPrimaryUse().getText().contains("Other"));
        Assert.assertTrue(vehiclesPage.getPurchaseType().getText().contains("Purchased"));
        Assert.assertTrue(vehiclesPage.getNewUsed().getText().contains("Used"));
        Assert.assertTrue(vehiclesPage.getAntiLockBrakes().getText().contains("No "));
        Assert.assertTrue(vehiclesPage.getAntiTheft().getText().contains("No "));
        /* check radio buttons are selected */
        Assert.assertTrue(vehiclesPage.getElectronicStabilityControlNo().isSelected());
        Assert.assertTrue(vehiclesPage.getCommercialUseNo().isSelected());
        Assert.assertTrue(vehiclesPage.getLoanedOrRentedNo().isSelected());



        try {
            vehiclesPage.setNext();
        } catch (ElementClickInterceptedException e) {
            js.executeScript("arguments[0].click();", vehiclesPage.getNext());
        }
        Thread.sleep(3000);
    }

    /**
     * enter driver details
     *
     * @throws InterruptedException
     */
    private void add_drivers() throws InterruptedException {
        DriversPage driversPage = new DriversPage(eventFiringWebDriver);
        {
            WebDriverWait wait = new WebDriverWait(eventFiringWebDriver, 30);
            wait.until(ExpectedConditions.visibilityOf(driversPage.getPageTitle()));
            //TODO: remove hard-coding with Fillo
            Assert.assertTrue(driversPage.isPageOpened("Drivers"));
        }
        driversPage.setAddDriver();
        driversPage.setAddExistingContact();
        driversPage.setFirstUnassignedUser();
        {
            WebDriverWait wait = new WebDriverWait(eventFiringWebDriver, 120);
            wait.until(ExpectedConditions.visibilityOf(driversPage.getDriverListDetail()));
        }
        /* validate required fields before continuing to next page */
        //TODO: remove hard-coding with Fillo
        //TODO: add not null assertions for generic testing
        Assert.assertTrue(driversPage.getFirstNameInput().getAttribute("value").contains("Jim"));
        Assert.assertTrue(driversPage.getLastNameInput().getAttribute("value").contains("Brown"));
        Assert.assertTrue(driversPage.getSelectedSalutation().contains("Mr."));
        Assert.assertTrue(driversPage.getDateOfBirth().getAttribute("value").equals("12/05/1965"));
        Assert.assertTrue(driversPage.getSelectedGender().contains("Male"));
        Assert.assertTrue(driversPage.getSelectedMaritalStatus().contains("Married"));
        Assert.assertTrue(driversPage.getSelectedLicenceType().contains("United States"));
        Assert.assertTrue(driversPage.getLicenceDate().getAttribute("value").equals("01/01/1982"));
        driversPage.setNext();
        Thread.sleep(5000);
    }

    /**
     * enter policy info details
     *
     * @throws InterruptedException
     */
    private void enter_policy_info() throws InterruptedException {
        PolicyInfoPage policyInfoPage = new PolicyInfoPage(eventFiringWebDriver);
        {
            WebDriverWait wait = new WebDriverWait(eventFiringWebDriver, 30);
            wait.until(ExpectedConditions.visibilityOf(policyInfoPage.getPageTitle()));
            //TODO: remove hard-coding with Fillo
            Assert.assertTrue(policyInfoPage.isPageOpened("Policy Info"));
            policyInfoPage.setNext();
        }
        Thread.sleep(5000);
    }

    /**
     * enter qualification details
     *
     * @throws InterruptedException
     */
    private void enter_qualification_info() throws InterruptedException {
        /* qualification page */
        QualificationPage qualificationPage = new QualificationPage(eventFiringWebDriver);
        {
            WebDriverWait wait = new WebDriverWait(eventFiringWebDriver, 120);
            wait.until(ExpectedConditions.visibilityOf(qualificationPage.getPageTitle()));
            //TODO: remove hard-coding with Fillo
            Assert.assertTrue(qualificationPage.isPageOpened("Qualification"));
        }
        qualificationPage.setPermissionToOrderReport();
        //TODO: remove hard-coding with Fillo
        qualificationPage.setSourceOfBusiness("Testing");
        qualificationPage.setPreQualQuestionOne();
        qualificationPage.setPreQualQuestionTwo();
        qualificationPage.setPreQualQuestionThree();
        qualificationPage.setPreQualQuestionFour();
        qualificationPage.setPreQualQuestionFive();
        qualificationPage.setNext();
        Thread.sleep(5000);
    }

    /**
     * start a new auto submission
     *
     * @throws InterruptedException
     */
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

    /**
     * account search by account number
     *
     * @param accountNumber
     * @throws InterruptedException
     */
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

    /**
     * log in page
     */
    private void login() {
        PCLoginPage pcLoginPage = new PCLoginPage(eventFiringWebDriver);
        //TODO: remove hard-coding with Fillo
        pcLoginPage.setByXPathUsername("su");
        pcLoginPage.setByXPathPassword("gw");
        pcLoginPage.byXPathClickLogin();
        PCHomePage homePage = new PCHomePage(eventFiringWebDriver);
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
