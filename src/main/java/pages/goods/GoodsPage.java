package pages.goods;

import hotline.pages.WebDriverClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Lena on 05.11.2014.
 */
public class GoodsPage extends WebDriverClass {

    public String GOODSLINK="titl";
    public String GOODCLASSSLINK="sabj";

    public GoodsPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean result() {

        return  driver.findElement(By.className(GOODSLINK)).isDisplayed();
    }

    public boolean negativeResult(){
        return driver.findElement(By.className(GOODCLASSSLINK)).isDisplayed();
    }

}
