package demo;

import environment.EnvironmentManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ModalPopupDemoTest {
    @Before
    public void setup() throws Exception {
        EnvironmentManager.initWebDriver();
    }

    @Test
    public void open_popup_test() {
        ModalPopupDemo popupDemo = new ModalPopupDemo();
        Assert.assertTrue(popupDemo.openPopup());
    }

    @After
    public void teardown() {
        EnvironmentManager.shutDownDriver();
    }
}
