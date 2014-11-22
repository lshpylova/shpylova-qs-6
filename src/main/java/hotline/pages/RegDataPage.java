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
    private static final By emailLink = By.xpath("//*[@name='email']");
    private static final By nickLink = By.name("nick");
    private static final By passwordLink = By.name("password");
    private static final By passwordRepeatLink = By.name("password2");
    private static final By okPopup = By.className("blue-button");
    private static final By availableEmailSelector = By.className("errors");
    private WebDriverWrapper driver;


    public RegDataPage(WebDriverWrapper driver) {
        this.driver = driver;
    }

    public void dataForReg(String email, String nick, String password, String password2) {
       Log4Test.start();
       Log4Test.info("Class RegDataPage. Method dataForReg()");
        driver.findElement(emailLink).sendKeys(email);
        driver.findElement(nickLink).sendKeys(nick);
        driver.findElement(passwordLink).sendKeys(password);
        driver.findElement(passwordRepeatLink).sendKeys(password2);
        Log4Test.info("You set the next data for registration: "+email+" "+nick+" "+password+" "+password2);

    }

    public void registerClick() {
        Log4Test.info("Class RegDataPage. Method registerClick()");
        driver.findElement(okPopup).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Log4Test.error("InterruptedException in Class RegDataPage.");
            Assert.fail("InterruptedException in Class RegDataPage.");
        }

    }

    public boolean emailIsUnavailable() {
        Log4Test.info("Class RegDataPage.Method emailIsUnavailable()");
        Log4Test.finish();
        return driver.findElement(availableEmailSelector).isDisplayed();


    }

}
