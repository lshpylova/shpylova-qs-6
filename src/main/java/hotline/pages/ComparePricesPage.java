package hotline.pages;

import hotline.pages.WebDriverClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import selenium.WebDriverWrapper;
import utils.Log4Test;

/**
 * Created by Lena on 08.11.2014.
 */
public class ComparePricesPage {
    private WebDriverWrapper driver;
    private final By compareSelector = By.className("but-box");
   // private final By compareButton=By.xpath("//a[@href='/bt-feny-stajlery/rowenta-cf-4132/?tab=2']");

    public ComparePricesPage(WebDriverWrapper driver)
    {
       this.driver = driver;
    }

       public void clickButtonCompare(){

           try {
               Thread.sleep(5000);
              } catch (InterruptedException e) {
               Assert.assertFalse(false, "Error in threa.sleep ,clickButtonCompare()");
           }
           Log4Test.info("@@@@@@@Begin the test.You click on the button Compare. Method clickButtonCompare()");
           WebElement element =  driver.findElement(compareSelector);
           (new WebDriverWait(driver, 50))
                   .until(ExpectedConditions.visibilityOf(element));

           driver.findElement(compareSelector).click();



       }


}
