package policycenter;

import environment.EnvironmentManager;
import environment.RunEnvironment;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import policycenter.pages.PCHomePage;
import policycenter.pages.PCLoginPage;

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
        pcLoginPage.setPassword("gw");
        pcLoginPage.setUsername("su");
        pcLoginPage.clickLogin();

        PCHomePage homePage = new PCHomePage(driver);
        Thread.sleep(5000);
        Assert.assertTrue(homePage.isPageOpened());

    }
    @After
    public void tearDown() throws Exception {
        EnvironmentManager.shutDownDriver();
    }
}