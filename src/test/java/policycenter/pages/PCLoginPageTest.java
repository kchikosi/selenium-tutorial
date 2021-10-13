package policycenter.pages;

import environment.EnvironmentManager;
import environment.RunEnvironment;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.policycenter.PCHomePage;
import pages.policycenter.PCLoginPage;

import java.util.concurrent.TimeUnit;

public class PCLoginPageTest {
    private WebDriver driver;

    @Before
    public void setUp() throws Exception {
        EnvironmentManager.initWebDriver();
        driver = RunEnvironment.getWebDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void test_PCLogin() throws InterruptedException {
        PCLoginPage pcLoginPage = new PCLoginPage(driver);
        pcLoginPage.setByNamePassword("gw");
        pcLoginPage.setByNameUsername("su");
        pcLoginPage.byIdClickLogin();

        PCHomePage homePage = new PCHomePage(driver);
        Thread.sleep(5000);
        Assert.assertTrue(homePage.isPageOpened());

    }
    @After
    public void tearDown() {
        EnvironmentManager.shutDownDriver();
    }
}