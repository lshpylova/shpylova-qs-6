package hotline.pages;

import hotline.pages.WebDriverClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import selenium.WebDriverWrapper;
import utils.Log4Test;

import java.util.List;

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
           Log4Test.info("@@@@@@@Begin the test.You click on the button Compare. Method clickButtonCompare()");

            driver.findElement(compareSelector).click();



       }


}
