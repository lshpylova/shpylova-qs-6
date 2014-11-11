package selenium;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.Assert;

/**
 * Created by Lena on 10.11.2014.
 */
public class WebDriverFactory {
    public static final String FIREFOX="firefox";
    public static final String HTMLUNIT="htmlunit";

    public static WebDriverWrapper initDriver (String driverName){
        WebDriverWrapper driverWrapper =null;
        if (driverName.equalsIgnoreCase(FIREFOX))
            driverWrapper = new WebDriverWrapper(new FirefoxDriver());
        else if (driverName.equalsIgnoreCase((HTMLUNIT)))
            driverWrapper =new WebDriverWrapper(new HtmlUnitDriver());
        else
        Assert.fail("invalid configuration");

        driverWrapper.manage().deleteAllCookies();
        driverWrapper.manage().window().maximize();
        return driverWrapper;

    }
}
