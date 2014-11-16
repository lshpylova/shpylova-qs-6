package hotline.pages;

import org.openqa.selenium.By;
import selenium.WebDriverWrapper;

/**
 * Created by Lena on 12.11.2014.
 */
public class ListOfRefrig extends WebDriverClass{
    private static final By LinkLG = By.cssSelector("['href*=\"/bt/holodilniki/627/']");
    private WebDriverWrapper driver;

    public void clickOnTypeLg(){

        driver.findElement(LinkLG).click();
    }
}
