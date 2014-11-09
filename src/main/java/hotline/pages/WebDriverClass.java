package hotline.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

/**
 * Created by Lena on 07.11.2014.
 */
public class WebDriverClass {
    public static WebDriver driver;

    @BeforeSuite
    public static void before() {
        driver = new FirefoxDriver();
    }


    @AfterSuite
    public void after()
    {
        if (driver != null)
            driver.quit();
    }
}
