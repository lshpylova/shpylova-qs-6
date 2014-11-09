package compare.test;

import hotline.pages.WebDriverClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.comparePrices.ComparePricesMethods;
import sun.rmi.runtime.Log;
import testfunct.FindProduct;
import utils.Log4Test;

import java.util.List;

/**
 * Created by Lena on 08.11.2014.
 */
public class ComparePricesTest extends WebDriverClass {

    private static final By OKSELECTOR2 = By.className("blue-button");

    @DataProvider
    public Object[][] dataSearchProd() {
        return new Object[][]{
                new Object[]{"http://hotline.ua", "Rowenta"}

        };
    }

    @Test(dataProvider = "dataSearchProd")

    public static void productCompTest(String siteUrl, String name) throws InterruptedException {
        driver.get(siteUrl);
        Log4Test.info("You try to found an element in the site hotline.ua and see the prices");

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("close"))));
        driver.findElement(By.className("close")).click();
        driver.findElement(OKSELECTOR2).click();
        FindProduct find = new FindProduct(driver);
        find.typeName(name);
        ComparePricesMethods compare = new ComparePricesMethods(driver);
        compare.clickButtonCompare();
        List<WebElement> price=driver.findElements(By.className("orng"));
        if (price.size()>=2){
        Assert.assertEquals(price.size()>=2,true,"test pass");
        Thread.sleep(5000);}
        else {
            Log4Test.error("Your list consists with les then 2 price");
        }


    }


}
