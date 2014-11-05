package hotline.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created with IntelliJ IDEA.
 * User: shpylova-o
 * Date: 04.11.14
 * Time: 18:02
 * To change this template use File | Settings | File Templates.
 */
public class RegDataPage {
    private WebDriver driver;


    public String EMAILRLINK = "email";
    public String TYPERLINK ="nick";
    public String PASSWORDRLINK = "password";
    public String PASSWORD2RLINK = "password2";
    public String OKSELECTOR2 = "blue-button";
    public String EMAILXPATH = "/html/body/div[6]/div[2]/div[1]/div/div[1]/div/form/div[1]/span";



    public RegDataPage(WebDriver driver) {
        this.driver = driver;
    }
    public void typeEmail(String email) {
        driver.findElement(By.name(EMAILRLINK)).sendKeys(email);
    }

    public void typeNick(String nick) {
        driver.findElement(By.name(TYPERLINK)).sendKeys(nick);
    }

    public void typePassword(String password) {
        driver.findElement(By.name(PASSWORDRLINK)).sendKeys(password);
    }


    public void typePassword2(String password2) {
        driver.findElement(By.name(PASSWORD2RLINK)).sendKeys(password2);
    }

    public void closeWin2() {
        driver.findElement(By.className(OKSELECTOR2)).click();

    }

    public String emailIsUnavailable(){
        return driver.findElement(By.xpath(EMAILXPATH)).getText();

    }
}
