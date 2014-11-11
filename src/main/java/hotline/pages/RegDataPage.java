package hotline.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import selenium.WebDriverWrapper;
import utils.Log4Test;

/**
 * Created with IntelliJ IDEA.
 * User: shpylova-o
 * Date: 04.11.14
 * Time: 18:02
 * To change this template use File | Settings | File Templates.
 */
public class RegDataPage {
     private static final By EMAILRLINK = By.name("email");
    private static final By TYPERLINK =By.name("nick");
    private static final By PASSWORDRLINK =By.name("password");
    private static final By PASSWORD2RLINK =By.name("password2");
    private static final By OKSELECTOR2 = By.className("blue-button");

    private static final By EMAILXPATH = By.xpath("/html/body/div[6]/div[2]/div[1]/div/div[1]/div/form/div[1]/span");
    private WebDriverWrapper driver;


   public RegDataPage(WebDriverWrapper driver) {
       this.driver = driver;
   }

    public void typeEmail(String email) {
        driver.findElement(EMAILRLINK).sendKeys(email);
    }

    public void typeNick(String nick) {
        driver.findElement(TYPERLINK).sendKeys(nick);
    }

    public void typePassword(String password) {
        driver.findElement(PASSWORDRLINK).sendKeys(password);
    }


    public void typePassword2(String password2) {

        driver.findElement(PASSWORD2RLINK).sendKeys(password2);
    }

    public void registerClick() {
        driver.findElement(OKSELECTOR2).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Log4Test.error("InterruptedException in RegisterPage.registerNewUser()");
            Assert.fail("InterruptedException in RegisterPage.registerNewUser()");
        }

       }

  //  public String emailIsUnavailable(){
     //   return driver.findElement(EMAILXPATH).getText();

   // }

    public boolean emailIsUnavailable(){
          return driver.findElement(EMAILXPATH).isDisplayed();

    }


}
