package demo;

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
        FirstDemo firstDemo = new FirstDemo();
        firstDemo.demo();
    }

    @After
    public void tearDown() {
        EnvironmentManager.shutDownDriver();
    }
}