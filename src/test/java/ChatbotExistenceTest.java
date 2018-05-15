import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ChatbotExistenceTest {
    WebDriver driver;

    @Parameters("browser")

    @BeforeMethod
    public void beforeTest(String browser) {

        if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver");
            driver = new ChromeDriver();
        } else {
            throw new IllegalArgumentException("The Browser Type is Undefined");
        }
    }

    @Test
    public void titleChatPOL() {

        driver.navigate().to("http://localhost:3006/");

        Assert.assertTrue("title should start with ChatPOL",
                driver.getTitle().startsWith("ChatPOL"));

        driver.close();
        driver.quit();
    }

    @Test
    public void chatExistence() {

        driver.navigate().to("http://localhost:3006/");

        Assert.assertTrue("checking if chat window exists",
                driver.findElements(By.className("content")).size() != 0);

        driver.close();
        driver.quit();
    }

    @Test
    public void footerExistence() {

        driver.navigate().to("http://localhost:3006/");

        Assert.assertTrue("checking if chat footer exists",
                driver.findElements(By.className("footer")).size() != 0);

        driver.close();
        driver.quit();
    }
}
