package demo;

import environment.EnvironmentManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class URLDemoTest {

    @Before
    public void setup() throws Exception {
        EnvironmentManager.initWebDriver();
    }

    @Test
    public void first_demo_test() {
        URLDemo URLDemo = new URLDemo();
        URLDemo.goToUrl();
    }

    @After
    public void teardown() {
        EnvironmentManager.shutDownDriver();
    }
}