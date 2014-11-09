
package hotline.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created with IntelliJ IDEA.
 * User: shpylova-o
 * Date: 04.11.14
 * Time: 16:58
 * To change this template use File | Settings | File Templates.
 */
public class WelcomePage extends WebDriverClass{

    //  public static String FIRSTNAME = "first_name";
    public static String XPATHWELCOME = "/html/body/div[6]/div[2]/div[1]/div/div[1]/div[2]/h1";

    public WelcomePage(WebDriver driver) {
        this.driver = driver;
    }

    public String welcometext(){

        return
                driver.findElement(By.xpath(XPATHWELCOME)).getText();
    }



}


