package hotline.functional;

import hotline.pages.WebDriverClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import selenium.WebDriverWrapper;

/**
 * Created by Lena on 05.11.2014.
 */
public class FindProduct {

    private static final By NAMELINK = By.id("searchbox");
    private static final By CLICKBTN = By.id("doSearch");
    private WebDriverWrapper driver;

   public FindProduct(WebDriverWrapper driver)
    {
        this.driver = driver;
    }

    public void typeName(String name) throws InterruptedException {
        driver.findElement(NAMELINK).sendKeys(name);
        driver.findElement(CLICKBTN).click();
        Thread.sleep(5000);

    }


}
