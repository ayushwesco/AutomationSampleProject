package com.wescodist.automation.sample;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.URL;


public class SampleTest {

    WebDriver driver;
    String appURL = "https://www.ishalife.com/in/";
    @Parameters({"browser"})
    @BeforeClass
    public void OpenUrl(String browser)
    {
        if(browser.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            options.setCapability(ChromeOptions.CAPABILITY, options);
            options.setCapability("browserName", "chrome");
            options.setCapability("acceptSslCerts", "true");
            options.setCapability("javascriptEnabled","true");
            DesiredCapabilities cap = DesiredCapabilities.chrome();
            options.merge(cap);
            try {
                driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if (browser.equalsIgnoreCase("firefox")) {
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--start-maximized");
            options.setCapability(ChromeOptions.CAPABILITY, options);
            options.setCapability("browserName", "firefox");
            options.setCapability("acceptSslCerts", "true");
            options.setCapability("javascriptEnabled","true");
            DesiredCapabilities cap = DesiredCapabilities.firefox();
            options.merge(cap);

            try {
                driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if (browser.equalsIgnoreCase("localchrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\E305178\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
    }
    @Test
    public void testSample1() {
        System.out.println("Testing");
    }

    @Test
    public void testLoginPage() {
        driver.get(appURL);
    }

    @AfterTest
    public void CleanBrowser() {
        driver.quit();
        driver = null;
    }

}
