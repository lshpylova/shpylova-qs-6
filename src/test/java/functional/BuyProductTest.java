package functional;

import actors.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasketPage;
import pages.Homepage;
import pages.LoginPage;
import utils.Log4Test;

import java.util.HashMap;

/**
 * Created by Lena on 29.10.2014.
 */
public class BuyProductTest {
    @Test
    public void buySingleProduct(HashMap<String,Double> product, User user){
        Log4Test.info("You try to buy a product in site hotline.ua");

        Homepage homepage = new Homepage();
        homepage.addToBasket(product);
        homepage.openBasket();
        BasketPage basketPage=new BasketPage();
        basketPage.buy();
        if (basketPage.isBuySuccess()) {
            LoginPage loginPage = new LoginPage();
            loginPage.login(user);
        }
        Assert.assertTrue(basketPage.isBuySuccess());


    }
}
