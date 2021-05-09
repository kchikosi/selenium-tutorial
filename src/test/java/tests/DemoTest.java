package tests;

import environment.EnvironmentManager;
import environment.RunEnvironment;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

public class DemoTest {
    @Before
    public void startBrowser() {
        EnvironmentManager.initWebDriver();
    }

    @Test
    public void demo() {
        WebDriver driver = RunEnvironment.getWebDriver();
        driver.get("http://www.google.com");
        String homeUrl = driver.getCurrentUrl();
        assertEquals(homeUrl, "https://www.google.com/?gws_rd=ssl");
    }

    @After
    public void tearDown() {
        EnvironmentManager.shutDownDriver();
    }

}
