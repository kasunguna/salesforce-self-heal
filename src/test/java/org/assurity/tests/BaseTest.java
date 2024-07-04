package org.assurity.tests;

import com.epam.healenium.SelfHealingDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {
    protected WebDriver driver;
    protected Properties properties;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\gunathilakek\\work\\healenium\\selenium\\chromedriver-win64\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver delegate = new ChromeDriver(options);
        driver = SelfHealingDriver.create(delegate);
        driver.manage().window().maximize();
        properties = new Properties();
        try {
            FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
