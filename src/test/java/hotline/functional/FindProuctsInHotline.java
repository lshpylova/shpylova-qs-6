package hotline.functional;

import hotline.pages.FindProduct;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import hotline.pages.GoodsPage;
import utils.Log4Test;

/**
 * Created by Lena on 05.11.2014.
 */
public class FindProuctsInHotline extends AbstractWebDriver {

    @DataProvider(name ="ForSearchingProduct")
    public Object[][] dataForSearching() {
        return new Object[][]{
                new Object[]{"http://hotline.ua", "Rowenta",true},
                new Object[]{"http://hotline.ua", "Rowenta1", false}

        };
    }


    @Test(dataProvider = "ForSearchingProduct")
    public static void productTest(String siteUrl, String name, boolean test) throws InterruptedException {
        driver.get(siteUrl);
        FindProduct find = new FindProduct(driver);
        find.typeNameAndSearch(name);
        GoodsPage goods = new GoodsPage(driver);
        if (test==true) {
            Log4Test.info("----Begin to find am product with method goods.findTheProductResult()");
            Assert.assertTrue(goods.findTheProductResult(), "Test failed. Class FindProductInHotline. Method findTheProductResult()");
            Log4Test.info("----Test finished");
        }else{

            Log4Test.info("****Begin to find am product with method findTheProductNegativeResult()");
            Assert.assertTrue(goods.findTheProductNegativeResult(), "Test failed.  Class FindProductInHotline. findTheProductNegativeResult() ");
            Log4Test.info("****Test finished");
        }

        }


 }







