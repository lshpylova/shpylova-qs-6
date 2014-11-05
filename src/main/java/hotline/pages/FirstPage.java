
package hotline.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


/**
 * Created with IntelliJ IDEA.
 * User: shpylova-o
 * Date: 05.11.14
 * Time: 11:48
 * To change this template use File | Settings | File Templates.
 */


public class FirstPage {

    //  public String CLOSESELECTOR = "close";
    public String OKSELECTOR2 = "blue-button";
    public String REGISTERLINK = "reg";

    private WebDriver driver;

    public FirstPage(WebDriver driver) {
        this.driver = driver;
    }

    public void closeWin() {
        driver.findElement(By.className(OKSELECTOR2)).click();
    }

    public void clickregbutton() {
        driver.findElement(By.className(REGISTERLINK)).click();
    }
}