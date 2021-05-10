package demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstDemo {

    public void demo() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\A035776\\Documents\\Development\\AMICA Dev\\Selenium\\SeleniumWebDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.google.com");
    }
}
