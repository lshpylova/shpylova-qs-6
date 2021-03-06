package hotline.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import selenium.WebDriverWrapper;
import utils.Log4Test;
import java.awt.*;
import java.util.List;


/**
 * Created by Lena on 12.11.2014.
 */
public class CatalogPage  {
    private static final By Techniks = By.id("lv-1-548");
    private static final By LinkRefrigirators = By.cssSelector("[href*='/bt/holodilniki/']");
    private final By getAllPrices = By.className("orng");
    private final By getAllNames = By.xpath("//div[@class='title-box']/h3/a");
    //private final By LinkSMEG=By.xpath("//*[@id='filters']//a[contains(text(),'SMEG')]");
    private final String LinkSMEG=("//*[@id='filters']//a[contains(text(),'SMEG')]");
    private WebDriverWrapper driver;
    public CatalogPage(WebDriverWrapper driver) {
        this.driver = driver;
    }

    public void openRefrgiratorsPage(String productName) {
        Log4Test.start();
        Actions actions = new Actions(WebDriverWrapper.getOriginalDriver());
        actions.moveToElement(driver.findElement(Techniks)).perform();
        sleep(2);
        driver.findElement(LinkRefrigirators).click();
        sleep(2);
        driver.findElement(By.className("op_all")).click();
        moveMouseDown();

        ((JavascriptExecutor)driver.getOriginalDriver()).executeScript("arguments[0].setAttribute(arguments[1], arguments[2]);",
                driver.findElement(By.className("jspPane")), "style", "padding: 0px 20px 0px 0px; width: 185px; top: -742px;");
                driver.findElement(By.xpath(String.format(LinkSMEG,productName))).click();
                  Log4Test.info("You found the product with Brand "+ productName);
                    //  driver.findElement(By.xpath("//*[@id='filters']//a[contains(text(),'West')]")).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Log4Test.finish();
    }


    public void moveMouseDown()
    {
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        robot.setAutoDelay(900);
        robot.mouseWheel(-10);
    }



    public void sleep(int second){

    try {
        Thread.sleep(second*1000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    }

    public List getAllprices(){
        return driver.findElements(getAllPrices);
    }
    public List getAllProductNames(){
        return driver.findElements(getAllNames);
    }
    }


