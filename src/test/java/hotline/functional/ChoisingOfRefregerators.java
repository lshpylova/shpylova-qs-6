package hotline.functional;

import hotline.pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by Lena on 12.11.2014.
 */
public class ChoisingOfRefregerators extends WebDriverClass {

      @DataProvider(name ="link")
    public Object[][] linkforsite() {
        return new Object[][] {
                new Object[] {"http://hotline.ua"}
        };
    }

    @Test(dataProvider = "link")
    public void findAProduct(String siteUrl) {
        driver.get(siteUrl);
     //   WebDriverWait wait = new WebDriverWait(driver, 10);
        FirstPage firstpage = new FirstPage(driver);
     //   wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("close"))));
      //  firstpage.closeWin();
      //  firstpage.closeSelector();

        CatalogPage catalogelement = new CatalogPage(driver);
        catalogelement.openRefrgiratorsPage();
        SortByTypeAndPrices sort = new SortByTypeAndPrices(driver);
        sort.openAndSort();
          try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(isFirstPriceLowerThanSecond(catalogelement.getAllprices()) && isProductsTheSame(catalogelement.getAllProductNames(),"SMEG"),
        "Test will pass if first price is lower than second and First two Products have same Brands");

    }


    public boolean isFirstPriceLowerThanSecond(List <WebElement> list){
        if(Integer.parseInt(list.get(0).getText().substring(0,6).replaceAll(" ",""))<Integer.parseInt(list.get(1).getText().substring(0,6).replaceAll(" ",""))) {
            return true;
        }else{
            return false;
        }
    }
    public boolean isProductsTheSame(List <WebElement> list,String brandName){
        if(list.get(0).getText().contains(brandName)&&list.get(1).getText().contains(brandName)){
            return true;
        }else{
            return false;
        }
    }

}
