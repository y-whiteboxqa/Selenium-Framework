package com.ebank.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import com.ebank.util.TestUtil;
import com.ebank.util.WebEventListener;

public class TestBase {

    public static WebDriver driver;
    public static Properties prop;
    public static EventFiringWebDriver e_driver;
    public static WebEventListener eventListener;

    public TestBase() {

        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream("/Users/yamuna/eclipse-workspace/EbankFramework/src/main/java/com/ebank/config/config.properties");
            prop.load(ip);

        } catch (FileNotFoundException e) {
            System.out.println("Exception caught" + e);
        } catch (IOException e) {
            System.out.println("Exception caught" + e);
        }

    }

    public static void initialization(String browser) {

        //String browserName = prop.getProperty("browser");

        if (browser.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "/Users/yamuna/Downloads/chromedriver");
            driver = new ChromeDriver();
        } else if (browser.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", "/Users/yamuna/Downloads/geckodriver");
            driver = new FirefoxDriver();
       
        }

        
        e_driver = new EventFiringWebDriver(driver);
        
        // now create object of EventListenerHandler to register it with EventFiringWebDriver
        eventListener = new WebEventListener();
        e_driver.register(eventListener);
        driver = e_driver;
        
        
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        // Timeout value variables created in TestUtil class, in case if the page takes
        // more time to load we can change there
        driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

        driver.get(prop.getProperty("url"));
    }

}
