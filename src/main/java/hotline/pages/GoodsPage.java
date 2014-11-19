package hotline.pages;

import org.openqa.selenium.By;
import selenium.WebDriverWrapper;
import utils.Log4Test;

/**
 * Created by Lena on 05.11.2014.
 */
public class GoodsPage  {

  private final By goodLink = By.className("search-result-page");
    private final By failLink = By.className("sabj");


   private WebDriverWrapper driver;

    public GoodsPage(WebDriverWrapper driver) {
        this.driver = driver;
    }

    public boolean findTheProductResult() {
        Log4Test.info("Class GoodsPage.Method findTheProductResult().You begin to found a product");
        return  driver.findElement(goodLink).isDisplayed();
    }

    public boolean findTheProductNegativeResult(){
        Log4Test.info("Class GoodsPage.Method findTheProductNegativeResult.You begin to found a product");
               return driver.findElement(failLink).isDisplayed();
    }





}
