package lesson3.task2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by Lena on 27.10.2014.
 */
public class ProductionFilter {
    public static WebDriver driver;

    @DataProvider
    public Object[][] filters() {
        return new Object[][]{
                new Object[]{"http://testng.org/doc/index.html", "Support"},
                new Object[]{"http://google.com", "Почта"},
                new Object[]{"http://testng.org", "Click for more details."},
        };
        }

    @BeforeSuite
    public void initEnv()
    {
        driver =new HtmlUnitDriver();
    }


    @Test (dataProvider = "filters")
    public void numberOfFilteredElemantsTest(String siteUrl, String element)
    {
        driver.get(siteUrl);
        driver.findElements(By.linkText(element));
        Assert.assertTrue(driver.findElements(By.linkText(element)).size()>0);
    }

    @AfterSuite
    public void shutEnv()
    {
        if (driver != null)
            driver.quit();
    }
}