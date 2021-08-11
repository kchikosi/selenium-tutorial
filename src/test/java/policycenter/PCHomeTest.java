package policycenter;

import environment.EnvironmentManager;
import environment.RunEnvironment;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class PCHomeTest {
    @Before
    public void setUp() throws Exception {
        EnvironmentManager.initWebDriver();
    }

    @Test
    public void test_home() throws IOException {
        PCHome pcHome = new PCHome();
        String loginUrl = pcHome.getHome();
        String homePage = "http://localhost:8180/pc/PolicyCenter.do";
        assertEquals("Unable to open URL " + homePage, loginUrl, homePage);
    }

    @Test
    public void test_username_password() throws IOException, InterruptedException {
        PCHome pcHome = new PCHome();
        WebDriver driver = RunEnvironment.getWebDriver();
        driver.navigate().to(pcHome.getHome());
        driver.findElement(By.name("Login-LoginScreen-LoginDV-username")).sendKeys("testuser");
        driver.findElement(By.name("Login-LoginScreen-LoginDV-password")).sendKeys("testpasswd");
        driver.findElement(By.id("Login-LoginScreen-LoginDV-submit")).click();
        driver.manage().window().fullscreen();
        Thread.sleep(60000);
    }

    @After
    public void tearDown() throws InterruptedException {
        EnvironmentManager.shutDownDriver();
    }
}