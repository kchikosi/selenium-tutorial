package demo;

import environment.RunEnvironment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class ModalPopupDemo {
    private static final Logger logger = LogManager.getLogger(RunEnvironment.class);

    public boolean openPopup() {
        try {
            WebDriver driver = RunEnvironment.getWebDriver();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            driver.navigate().to("C:\\Users\\A035776\\Documents\\dev\\selenium-tutorial\\web\\ModalPopup.html");
            driver.findElement(By.id("myBtn")).click();
            logger.info(driver.findElement(By.tagName("body")).getText());
            driver.findElement(By.id("userid")).sendKeys("testuser");
            driver.findElement(By.id("password")).sendKeys("testpass");
        } catch (Exception e) {
            logger.error("Error in openPopup() " + e.getClass(), e.toString());
            return false;
        }
        return true;
    }
}
