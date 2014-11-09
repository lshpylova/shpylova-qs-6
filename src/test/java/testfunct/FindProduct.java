package testfunct;

import hotline.pages.WebDriverClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Lena on 05.11.2014.
 */
public class FindProduct extends WebDriverClass{

    private static final By NAMELINK = By.id("searchbox");
    private static final By CLICKBTN = By.id("doSearch");

    public FindProduct(WebDriver driver)
    {
        this.driver = driver;
    }

    public void typeName(String name) throws InterruptedException {
        driver.findElement(NAMELINK).sendKeys(name);
        driver.findElement(CLICKBTN).click();
        Thread.sleep(5000);

    }


}
