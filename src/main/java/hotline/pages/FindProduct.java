package hotline.pages;

/**
 * Created by Lena on 17.11.2014.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import selenium.WebDriverWrapper;
import utils.Log4Test;

/**
 * Created by Lena on 05.11.2014.
 */
public class FindProduct {

    private static final By typeNameForProduct = By.id("searchbox");
   // private static final By doSearchClick = By.id("doSearch");
    private final String DO_SEARCH_CCLICK=("doSearch");
    private WebDriverWrapper driver;

    public FindProduct(WebDriverWrapper driver) {
        this.driver = driver;
    }

    public void typeNameAndSearch(String name) throws InterruptedException {
        Log4Test.start();
        WebElement searchTypeField = driver.findElement(typeNameForProduct);
        searchTypeField.clear();
        searchTypeField.sendKeys(name);
        driver.findElement(By.id(String.format(DO_SEARCH_CCLICK,name))).click();
        Log4Test.info("You found the product with Brand "+name);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Assert.fail("Class FindProduct. Method typeNameAndSearch()");
        }

    }
}