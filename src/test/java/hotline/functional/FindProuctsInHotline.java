package hotline.functional;

import hotline.pages.WebDriverClass;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import hotline.pages.GoodsPage;

/**
 * Created by Lena on 05.11.2014.
 */
public class FindProuctsInHotline extends WebDriverClass {
    private static final By OKSELECTOR2 = By.className("blue-button");

    @DataProvider(name ="ForSearching")
    public Object[][] dataForSearching() {
        return new Object[][]{
                new Object[]{"http://hotline.ua", "Rowenta",true},
                new Object[]{"http://hotline.ua", "Rowenta1", false}

        };
    }


    @Test(dataProvider = "ForSearching")
    public static void productTest(String siteUrl, String name, boolean test) throws InterruptedException {
        driver.get(siteUrl);

     /*   if (test) {
           WebDriverWait wait = new WebDriverWait(driver, 40);
           wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("close"))));
           driver.findElement(By.className("close")).click();
           driver.findElement(OKSELECTOR2).click();
        }
*/

        FindProduct find = new FindProduct(driver);
        find.typeName(name);
        GoodsPage goods = new GoodsPage(driver);
        if (test==true) {
            Assert.assertTrue(goods.result(), "product was found");


        }else{
            Assert.assertTrue(goods.negativeResult(), "product wasn't found");
          //  Log4Test.error("Test was faild");
        }

    //   Thread.sleep(5000);

    }


 }







