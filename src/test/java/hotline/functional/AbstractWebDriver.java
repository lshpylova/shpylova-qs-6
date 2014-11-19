package hotline.functional;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import selenium.WebDriverFactory;
import selenium.WebDriverWrapper;
import utils.PropertyLoader;
import utils.ScreenShotMaker;

import java.io.File;
import java.io.IOException;

/**
 * Created by Lena on 07.11.2014.
 */
public class AbstractWebDriver {
    public static WebDriverWrapper driver;

    @BeforeSuite
    public static void before() {

       driver= WebDriverFactory.initDriver(PropertyLoader.loadProperty("browser.name"));

    }

   @AfterMethod(alwaysRun=true)
    public void catchExceptions(ITestResult testResult, String scrName, String screenShotSubDirectory) throws Exception{
              if (testResult.getStatus() == ITestResult.FAILURE) {
            System.out.println(testResult.getStatus());
        //    ScreenShotMaker.clearScreenShotSubDirectory(screenShotSubDirectory);
            ScreenShotMaker maker =new ScreenShotMaker(driver);
            maker.takeScreenShot(scrName);
                }
    }

    @AfterSuite
    public void after()
    {
        if (driver != null)
            driver.quit();
    }
}
