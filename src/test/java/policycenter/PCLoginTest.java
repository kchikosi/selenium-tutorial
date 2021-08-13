package policycenter;

import environment.EnvironmentManager;
import environment.RunEnvironment;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import policycenter.pages.PCHomePage;
import policycenter.pages.PCLoginPage;

import static org.junit.Assert.assertEquals;

public class PCLoginTest {
    /**
     * Initialize web driver
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        EnvironmentManager.initWebDriver();
    }

    /**
     * Invoke Login page
     * Enter username and password
     * Verify in landing page and close
     * @throws InterruptedException
     */
    @Test
    public void test_PCLogin() throws InterruptedException {
        WebDriver driver = RunEnvironment.getWebDriver();
        PCLoginPage pcLoginPage = new PCLoginPage(driver);
        PCHomePage pcHomePage = pcLoginPage.loginValidUser("su", "gw");
        Thread.sleep(1000);
        assertEquals("Error", pcHomePage.getMessageText(), "My Summary");
    }

    /**
     * Close browser
     * @throws InterruptedException
     */
    @After
    public void tearDown() throws InterruptedException {
        EnvironmentManager.shutDownDriver();
    }
}
