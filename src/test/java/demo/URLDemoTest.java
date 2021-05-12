package demo;

import environment.EnvironmentManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class URLDemoTest {

    @Before
    public void setUp() throws Exception {
        EnvironmentManager.initWebDriver();
    }

    @Test
    public void test_firstDemo() {
        URLDemo URLDemo = new URLDemo();
        URLDemo.goToUrl();
    }

    @After
    public void tearDown() {
        EnvironmentManager.shutDownDriver();
    }
}