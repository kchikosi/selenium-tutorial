package policycenter;

import environment.EnvironmentManager;
import environment.RunEnvironment;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class PCLogin {
    public PCLogin() throws IOException {
        EnvironmentManager.initWebDriver();
    }

    public String login() {
        WebDriver webDriver = RunEnvironment.getWebDriver();
        webDriver.manage().window().maximize();
        String homePage = "http://localhost:8180/pc/PolicyCenter.do";
        webDriver.get(homePage);
        return webDriver.getCurrentUrl();

    }
}
