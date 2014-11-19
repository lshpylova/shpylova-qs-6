package hotline.functional;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by Lena on 19.11.2014.
 */
public class GridExample {
    @Test
            public void gridTest() {
        DesiredCapabilities capability = DesiredCapabilities.firefox();
        WebDriver driver = null;
        try{
            driver = new RemoteWebDriver(new URL("http://localhost:9999/wd/hub"),capability);
        }catch (MalformedURLException e){
            e.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://hotline.ua");

    }

}
