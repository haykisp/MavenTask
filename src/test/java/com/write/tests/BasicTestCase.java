package com.write.tests;


/*
    this Class defines basics for Test Cases
   P.S. every test method starts in new clear browser
 */

import com.write.com.write.utils.ConfigProperties;
import com.write.data.UserData;
import com.write.pages.HomePage;
import com.write.pages.LoginPage;
import com.write.pages.MailPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;


public abstract class BasicTestCase {

    protected static WebDriver driver;
    protected LoginPage loginPage;
    protected HomePage homePage;
    protected MailPage mailPage;

    public UserData haykisp = new UserData("haykisp_test", "~Test1234");


    @BeforeMethod
    // The following method executing before every Test Method
    protected void initWebPage() {
        if (ConfigProperties.getProperty("browser").equals("chrome")) {                                                     // Applying browser type from config.properties
            System.setProperty("webdriver.chrome.driver", ConfigProperties.getProperty("chrome.browser"));                  // Setup chrome browser path
            driver = new ChromeDriver();                                                                                    // Open Chrome browser
        } else if (ConfigProperties.getProperty("browser").equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", ConfigProperties.getProperty("firefox.browser"));                  // Setup firefox browser path
            DesiredCapabilities cap = DesiredCapabilities.firefox();                                                        // Setup Desired Capabilities for firefox browser
            cap.setCapability("marionette", true);
            cap.setBrowserName("firefox");
            driver = new FirefoxDriver(cap);                                                                                // Open Firefox browser
        }
        driver.manage().timeouts().implicitlyWait(Long.parseLong(ConfigProperties.getProperty("imp.wait")), TimeUnit.SECONDS);  // Setup Implicitly Wait for webdriver from config.properties
        loginPage = new LoginPage(driver);
        loginPage.open();
    }

    @AfterMethod
    // The following method executing after every Test method
    public void afterMetod() {
        driver.quit();                                                                                                      // closing browser
    }


}
