import org.junit.Assert;
/*import org.junit.Test;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;*/
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.ie.InternetExplorerDriver;

import org.testng.annotations.AfterClass;

import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeClass;

import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Parameters;

import org.testng.annotations.Test;

public class ChatbotExistenceTest {
    WebDriver driver;

    @Parameters("browser")// this annotation is used to insert browser parameter from TestNG xml

    @BeforeMethod
    public void beforeTest(String browser)
    {

        if (browser.equalsIgnoreCase("firefox"))
        {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("chrome"))
        {
            System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver");
            driver = new ChromeDriver();
        }
        else
        {
            throw new IllegalArgumentException("The Browser Type is Undefined");
        }
        driver.get("https://accounts.google.com/ServiceLogin?sacu=1 &scc=1&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&ss=1&ltmpl=default&rm=false");
    }


    @Test
    public void titleChatPOL(){


//        System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\chromedriver_win32\\chromedriver.exe");
//        WebDriver driver = new ChromeDriver();

        driver.navigate().to("http://localhost:3006/");

        Assert.assertTrue("title should start with ChatPOL",
                driver.getTitle().startsWith("ChatPOL"));

        driver.close();
        driver.quit();
    }
    @Test
    public void chatExistence()    {
/*        System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();*/

        driver.navigate().to("http://localhost:3006/");

        Assert.assertTrue("checking if chat window exists",
                driver.findElements( By.className("content")).size() != 0);

        driver.close();
        driver.quit();
    }

    @Test
    public void footerExistence(){
/*        System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();*/

        driver.navigate().to("http://localhost:3006/");

        Assert.assertTrue("checking if chat footer exists",
                driver.findElements( By.className("footer")).size() != 0);


        driver.close();
        driver.quit();
    }
}
