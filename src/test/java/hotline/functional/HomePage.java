package hotline.functional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import hotline.pages.RegPage;

public class HomePage {

    public static WebDriver driver;
    public static String FIRSTNAME = "first_name";



    @BeforeSuite
    public static void before() {
        driver = new FirefoxDriver();
    }

    @DataProvider
    public Object[][] filters() {
        return new Object[][] {
                new Object[] {"http://hotline.ua"},
        };
    }

    @Test(dataProvider = "filters")
    public static void registerTest(String siteUrl)
    {
        driver.get(siteUrl);
        WebDriverWait wait = new WebDriverWait(driver, 1000);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("close"))));
        RegPage r = new RegPage(driver);
        r.closeWin();
        r.clickregbutton();
        r.typeEmail("hardstorm@bigm.net");
        r.typeNick("Hardstorm");
        r.typePassword("181920");
        r.typePassword2("181920");
        r.closeWin();
        try{
            Assert.assertTrue(driver.findElement(By.name(FIRSTNAME)).isDisplayed(), "Register failed.");
        } catch (Exception ex) {
            System.out.println("емейл уже существует");

        }

    }

    @AfterSuite
    public void after()
    {
        if (driver != null)
            driver.quit();
    }

}

