package demo;

import environment.EnvironmentManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ModalPopupDemoTest {
    @Before
    public void setUp() throws Exception {
        EnvironmentManager.initWebDriver();
    }

    @Test
    public void test_openPopup() {
        ModalPopupDemo popupDemo = new ModalPopupDemo();
        Assert.assertTrue(popupDemo.openPopup());
    }

    @After
    public void tearDown() {
        EnvironmentManager.shutDownDriver();
    }
}
