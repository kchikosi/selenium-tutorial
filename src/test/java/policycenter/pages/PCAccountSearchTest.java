package policycenter.pages;

import environment.EnvironmentManager;
import environment.RunEnvironment;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class PCAccountSearchTest {
    private WebDriver driver;

    @Before
    public void setUp() throws Exception {
        EnvironmentManager.initWebDriver();
        driver = RunEnvironment.getWebDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void test_PCAccountSearch() throws InterruptedException {
        PCLoginPage pcLoginPage = new PCLoginPage(driver);
        pcLoginPage.setByXPathUsername("su");
        pcLoginPage.setByXPathPassword("gw");
        pcLoginPage.byXPathClickLogin();
        {
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id=\'TabBar-AccountTab\']/div/div[2]")));
        }
        PCSummaryPage summaryPage = new PCSummaryPage(driver);
        Assert.assertTrue(summaryPage.isPageOpened());

        summaryPage.accountTabClick();
        summaryPage.setAccountNumber("N001958701");
        summaryPage.accountNumberSearchButtonClick();
        Thread.sleep(20000);
        PCAccountPage accountPage = new PCAccountPage(driver);
        Assert.assertTrue(accountPage.isPageOpened());
        //TODO: validate field values match account number
    }
    @After
    public void tearDown() {
        EnvironmentManager.shutDownDriver();
    }
}