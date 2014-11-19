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
    //private final By compareSelector = By.className("but-box");
   private final By compareSelector =By.xpath("//ul[contains(concat(' ', normalize-space(@class), ' '), ' catalog ')]/li[1]/div[1]/a");
   // private final By compareButton=By.xpath("//a[@href='/bt-feny-stajlery/rowenta-cf-4132/?tab=2']");
  // private final By compareSelector =By.xpath("/html/body/div[6]/div[2]/div[2]/div/div[1]/table/tbody/tr/td[2]/ul/li[1]/div[1]/a");

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
             driver.findElement(By.className("ddopener")).click();
             driver.findElement(By.xpath("//a[@href='http://hotline.ua/sr/?q=Rowenta&sort=1']")).click() ;
           try {
               Thread.sleep(5000);
           } catch (InterruptedException e) {
               Log4Test.error("InterruptedException in ComparePricesPage");
               Assert.fail("InterruptedException in ComparePricesPage");
           }
           driver.findElement(By.xpath("//a[@href='/bt-aksessuary-dlya-pylesosov/slon-r-03-c-ii/?tab=2']")).click();





       }


}
