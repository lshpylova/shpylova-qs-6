package hotline.pages;

import org.openqa.selenium.By;
import org.testng.Assert;
import selenium.WebDriverWrapper;
import utils.Log4Test;

/**
 * Created by Lena on 08.11.2014.
 */
public class ComparePricesPage {
    private WebDriverWrapper driver;

   private final By compareSelector =By.xpath("//ul[contains(concat(' ', normalize-space(@class), ' '), ' catalog ')]/li[1]/div[1]/a");
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
           driver.findElement(compareSelector).click();

      }


}
