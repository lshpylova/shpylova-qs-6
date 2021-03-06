package hotline.pages;

import org.openqa.selenium.By;
import selenium.WebDriverWrapper;
import utils.Log4Test;


/**
 * Created by Lena on 16.11.2014.
 */
public class SortByTypeAndPrices  {
    private static final By SortElement = By.xpath("//a[@href='http://hotline.ua/bt/holodilniki/10634/?sort=0']");
    private static final By OpenElement = By.className("ddopener");
    private WebDriverWrapper driver;

    public SortByTypeAndPrices(WebDriverWrapper driver) {
        this.driver = driver;
    }

    public void openAndSort() {
    driver.findElement(OpenElement).click();
    driver.findElement(SortElement).click();
    Log4Test.info("You sort the elements by prices- pass");
}
}
