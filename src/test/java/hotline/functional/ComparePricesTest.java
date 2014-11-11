package hotline.functional;

import hotline.pages.WebDriverClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import hotline.pages.ComparePricesMethods;
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
        find.typeName(name);
        ComparePricesMethods compare = new ComparePricesMethods(driver);
        compare.clickButtonCompare();
        List<WebElement> price=driver.findElements(By.className("orng"));
        if (price.size()>=2){
        Assert.assertEquals(price.size()>=2,true,"test pass");
         }
        else {
            Log4Test.error("Your list consists with les then 2 price");
        }


    }


}
