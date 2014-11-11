
package hotline.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import selenium.WebDriverWrapper;
import utils.Log4Test;


/**
 * Created with IntelliJ IDEA.
 * User: shpylova-o
 * Date: 05.11.14
 * Time: 11:48
 * To change this template use File | Settings | File Templates.
 */


public class FirstPage

{
    private static final By CLOSESELECTOR = By.className("close");
    private static final By OKSELECTOR2 = By.className("blue-button");
    private static final By REGISTERLINK = By.className("reg");

    private WebDriverWrapper driver;

    public FirstPage(WebDriverWrapper driver) {
        this.driver = driver;
    }

    public void closeSelector() {
        driver.findElement(CLOSESELECTOR).click();
    }

    public void closeWin() {
        driver.findElement(OKSELECTOR2).click();
    }

    public void clickregbutton() {
        Log4Test.info("You click on the button registration");
        driver.findElement(REGISTERLINK).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Log4Test.error("InterruptedException in HomePage.reg()");
            Assert.fail("InterruptedException in HomePage.reg()");
        }
    }
}