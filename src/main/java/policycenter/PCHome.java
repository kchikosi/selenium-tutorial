package policycenter;

import environment.EnvironmentManager;
import environment.RunEnvironment;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class PCHome {
    public PCHome() throws IOException {
        EnvironmentManager.initWebDriver();
    }

    public String getHome() {
        WebDriver webDriver = RunEnvironment.getWebDriver();
        webDriver.manage().window().maximize();
        String homePage = "http://localhost:8180/pc/PolicyCenter.do";
        webDriver.get(homePage);
        return webDriver.getCurrentUrl();

    }
}
