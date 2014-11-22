package hotline.pages;

/**
 * Created by Lena on 17.11.2014.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import selenium.WebDriverWrapper;

/**
 * Created by Lena on 05.11.2014.
 */
public class FailFindProduct {

    private static final By typeNameForProduct = By.id("searchbox");
    private static final By doSearchClick = By.id("1doSearch");
    private WebDriverWrapper driver;


    public FailFindProduct(WebDriverWrapper driver) {
        this.driver = driver;
    }

    public void typeNameAndSearch(String name) throws InterruptedException {
       driver.findElement(typeNameForProduct).sendKeys(name);
       driver.findElement(doSearchClick).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
          Assert.fail("Class FindProduct. Method typeNameAndSearch()");

        }

    }
}