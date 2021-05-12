package demo;

import environment.EnvironmentManager;
import environment.RunEnvironment;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class URLTest {
    @Before
    public void startBrowser() throws IOException {
        EnvironmentManager.initWebDriver();
    }

    @Test
    public void test_homeUrl() {
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
