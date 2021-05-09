import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\A035776\\Documents\\Development\\AMICA Dev\\Selenium\\SeleniumWebDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.google.com");
    }
}
