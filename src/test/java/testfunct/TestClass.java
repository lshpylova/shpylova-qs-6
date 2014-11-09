package testfunct;

import hotline.pages.FirstPage;
import hotline.pages.WebDriverClass;
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
import pages.goods.GoodsPage;
import utils.Log4Test;

/**
 * Created by Lena on 05.11.2014.
 */
public class TestClass extends WebDriverClass {
    private static final By OKSELECTOR2 = By.className("blue-button");

    @DataProvider
    public Object[][] dataForProd() {
        return new Object[][]{
                new Object[]{"http://hotline.ua", "Rowenta",true},
                new Object[]{"http://hotline.ua", "Rowenta1", false}

        };
    }


    @Test(dataProvider = "dataForProd", priority = 1)

    public static void productPositiveTest(String siteUrl, String name, boolean test) throws InterruptedException {
        if (test) {
            Log4Test.info("You try to found an element in the site hotline.ua");
        }
        else{
            Log4Test.info("You try to found an element,which not exist in the site hotline.ua");
        }

        driver.get(siteUrl);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        if (test) {
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("close"))));
            driver.findElement(By.className("close")).click();
            driver.findElement(OKSELECTOR2).click();
        }
        FindProduct find = new FindProduct(driver);
        find.typeName(name);
        GoodsPage goods = new GoodsPage(driver);
        if (test==true) {
            Assert.assertTrue(goods.result(), "product was found");
         //   Thread.sleep(30);

        }else{
            Assert.assertTrue(goods.negativeResult(), "product wasn't found");
          //  Log4Test.error("Test was faild");
        }

        Thread.sleep(5000);



    }


 }







