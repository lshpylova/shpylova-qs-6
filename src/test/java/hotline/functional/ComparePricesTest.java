package hotline.functional;

import hotline.pages.ComparePricesPage;
import hotline.pages.FindProduct;
import hotline.pages.WebDriverClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.Log4Test;

import java.util.List;

/**
 * Created by Lena on 08.11.2014.
 */
public class ComparePricesTest extends WebDriverClass {

    @DataProvider(name="SearchProd")
    public Object[][] dataSearchProd() {
        return new Object[][]{
                new Object[]{"http://hotline.ua", "Rowenta"},
                };
    }

    @Test(dataProvider = "SearchProd")

    public static void productCompTest(String siteUrl, String name) throws InterruptedException {
        driver.get(siteUrl);
        FindProduct find = new FindProduct(driver);
        find.typeNameAndSearch(name);
        ComparePricesPage compare = new ComparePricesPage(driver);
        compare.clickButtonCompare();
         List<WebElement> price=driver.findElements(By.className("orng"));
        Assert.assertEquals(price.size()>=2,true,"Page has more then 2 prices for product");
        Log4Test.info("@@@@@@Test 'ComparePricesTest' is finished");
    }


}
