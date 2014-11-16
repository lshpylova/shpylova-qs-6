package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.*;
import utils.PropertyLoader;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Created by Lena on 10.11.2014.
 */
public class WebDriverWrapper implements WebDriver {
    private static WebDriver driver;
    public static final int Time_To_Wait=Integer.valueOf(PropertyLoader.loadProperty("selenium.max.timeout"));

    public static WebDriver getOriginalDriver(){
        return driver;
    }

    public WebDriverWrapper(WebDriver driver){
        this.driver=driver;

    }

    @Override
    public void get(String s) {
        driver.get(s);

    }

    @Override
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    @Override
    public String getTitle() {
        return driver.getTitle();
    }

    @Override
    public List<WebElement> findElements(By by) {
        return driver.findElements(by);
    }

    @Override
    public WebElement findElement(By by){
        WebDriverWait wait =new WebDriverWait(driver,Time_To_Wait);
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
        return driver.findElement(by);
    }

    @Override
    public String getPageSource() {
        return driver.getPageSource();
    }

    @Override
    public void close() {
        driver.close();

    }

    @Override
    public void quit() {
        driver.quit();

    }

    @Override
    public Set<String> getWindowHandles() {
        return driver.getWindowHandles();
    }

    @Override
    public String getWindowHandle() {
        return driver.getWindowHandle();
    }

    @Override
    public TargetLocator switchTo() {
        return driver.switchTo();
    }

    @Override
    public Navigation navigate() {
        return driver.navigate();
    }

    @Override
    public Options manage() {
        return driver.manage();
    }

    public void mouseMoveToElement(By by) {
        if (driver instanceof RemoteWebDriver) {
            new Actions(driver).moveToElement(findElement(by)).perform();
        } else {
            throw new UnsupportedOperationException("Unsupported action for " + driver.getClass());
        }
    }
}
