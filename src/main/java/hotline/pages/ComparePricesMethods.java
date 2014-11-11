package hotline.pages;

import hotline.pages.WebDriverClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import selenium.WebDriverWrapper;
import utils.Log4Test;

/**
 * Created by Lena on 08.11.2014.
 */
public class ComparePricesMethods  {
    private WebDriverWrapper driver;
    private final By compareSelector = By.className("but-box");

    public ComparePricesMethods(WebDriverWrapper driver)
    {
       this.driver = driver;
    }

       public void clickButtonCompare(){
           Log4Test.info("You click on the button Compare");
        driver.findElement(compareSelector).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Assert.assertFalse(false, "Error in threa.sleep ,comparePrices()");
        }
    }


}
