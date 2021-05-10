package tests.demo;

import demo.FirstDemo;
import environment.EnvironmentManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FirstDemoTest {

    @Before
    public void setUp() throws Exception {
        EnvironmentManager.initWebDriver();
    }

    @Test
    public void test_firstDemo() {
        FirstDemo demo = new FirstDemo();
        demo.demo();
    }
    @After
    public void tearDown() throws Exception {
        EnvironmentManager.shutDownDriver();
    }
}