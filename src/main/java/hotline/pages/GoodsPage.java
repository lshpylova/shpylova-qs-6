package hotline.pages;

import hotline.pages.WebDriverClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import selenium.WebDriverWrapper;
import utils.Log4Test;

/**
 * Created by Lena on 05.11.2014.
 */
public class GoodsPage  {

    public String GOODSLINK="titl";
    public String GOODCLASSSLINK="sabj";


   private WebDriverWrapper driver;

    public GoodsPage(WebDriverWrapper driver) {

        this.driver = driver;
    }

    public boolean result() {
        Log4Test.info("You found a product");
        return  driver.findElement(By.className(GOODSLINK)).isDisplayed();
    }

    public boolean negativeResult(){
        Log4Test.info("Your product is missed in site");
        return driver.findElement(By.className(GOODCLASSSLINK)).isDisplayed();
    }





}
