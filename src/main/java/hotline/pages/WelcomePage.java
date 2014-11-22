
package hotline.pages;

import org.openqa.selenium.By;
import org.testng.Assert;
import selenium.WebDriverWrapper;
import utils.Log4Test;

/**
 * Created with IntelliJ IDEA.
 * User: shpylova-o
 * Date: 04.11.14
 * Time: 16:58
 * To change this template use File | Settings | File Templates.
 */
public class WelcomePage {
    private WebDriverWrapper driver;
    private static final By isRegistredLocator= By.className("registr-successful");
    public WelcomePage(WebDriverWrapper driver) {
       this.driver = driver;
   }


 public boolean welcomeText(){
         Log4Test.info("------Method welcomeText()");
         Log4Test.finish();
    return
             driver.findElement(isRegistredLocator).isDisplayed();
     }



}


