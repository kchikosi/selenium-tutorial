package policycenter.pages;

import environment.EnvironmentManager;
import environment.RunEnvironment;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.policycenter.landing.PCHomePage;
import pages.policycenter.landing.PCLoginPage;

import java.util.concurrent.TimeUnit;

public class PCLoginPageTest {
    private WebDriver driver;

    @Before
    public void setup() throws Exception {
        EnvironmentManager.initWebDriver();
        driver = RunEnvironment.getWebDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void pc_login_test() throws InterruptedException {
        PCLoginPage pcLoginPage = new PCLoginPage(driver);

        pcLoginPage.setByXPathUsername("su");
        pcLoginPage.setByXPathPassword("gw");
        pcLoginPage.byXPathClickLogin();

        PCHomePage homePage = new PCHomePage(driver);
        Thread.sleep(5000);
        Assert.assertTrue(homePage.isPageOpened());

    }
    @After
    public void teardown() {
        EnvironmentManager.shutDownDriver();
    }
}