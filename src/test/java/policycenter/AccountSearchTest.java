package policycenter;
// Generated by Selenium IDE

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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import policycenter.pages.AccountSummaryPage;
import policycenter.pages.PCLoginPage;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class AccountSearchTest {
    private WebDriver driver;
    private Connection connection;

    @Before
    public void setUp() throws IOException, FilloException {
        EnvironmentManager.initWebDriver();
        driver = RunEnvironment.getWebDriver();
        String filloDatasource = PropertiesManager.getValue("fillo.test.datasource");
        connection = new Fillo().getConnection(filloDatasource);
    }

    @After
    public void tearDown() {
        connection.close();
        driver.quit();
    }

    /**
     * Read from Excel file and executes based on data
     * @throws FilloException is thrown
     */
    @Test
    public void test_accountSearch_TC002() throws FilloException, IOException {
        String query = "select * from testcases where testcaseid = 'TC002'";
        List<Map<String, String>> testStepsList = FilloHelper.getStepsList(query);

        //get values from a helper method
        Optional<String> user = FilloHelper.getDataByColumnName(testStepsList, "USERNAME");
        Optional<String> passwd = FilloHelper.getDataByColumnName(testStepsList, "PASSWORD");

        PCLoginPage pcLoginPage = new PCLoginPage(driver);
        // orElse used in case there is no data
        //TODO: fix this mess
        pcLoginPage.setByXPathUsername(user.orElseThrow());
        pcLoginPage.setByXPathPassword(passwd.orElseThrow());
        pcLoginPage.byXPathClickLogin();
        {
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='TabBar-AccountTab']/div/div[2]")));
        }

        AccountSummaryPage accountSummaryPage = new AccountSummaryPage(driver);
        accountSummaryPage.accountTabClick();
        Optional<String> accountNumber = FilloHelper.getDataByColumnName(testStepsList, "ACCOUNTNUMBER");
        accountSummaryPage.setAccountNumber(accountNumber.orElseThrow());
        accountSummaryPage.accountNumberSearchButtonClick();
        {
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".gw-focus > .gw-label")));
            Assert.assertTrue(accountSummaryPage.isPageOpened());
        }
        //logout
        driver.findElement(By.cssSelector(".gw-focus > .gw-label")).click();

    }

}

