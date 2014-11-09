package pages.comparePrices;

import hotline.pages.WebDriverClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Lena on 08.11.2014.
 */
public class ComparePricesMethods extends WebDriverClass {

    public ComparePricesMethods(WebDriver driver)
    {
        this.driver = driver;
    }

    public void clickButtonCompare(){
        driver.findElement(By.className("but-box")).click();
    }
}
