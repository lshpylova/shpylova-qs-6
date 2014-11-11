package hotline.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import selenium.WebDriverFactory;
import selenium.WebDriverWrapper;
import utils.PropertyLoader;

/**
 * Created by Lena on 07.11.2014.
 */
public class WebDriverClass {
    public static WebDriverWrapper driver;

    @BeforeSuite
    public static void before() {

       driver= WebDriverFactory.initDriver(PropertyLoader.loadProperty("browser.name"));
    }


    @AfterSuite
    public void after()
    {
        if (driver != null)
            driver.quit();
    }
}
