package hotline.functional;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import hotline.pages.FirstPage;
import hotline.pages.RegDataPage;
import hotline.pages.WelcomePage;

/**
 * Created with IntelliJ IDEA.
 * User: shpylova-o
 * Date: 05.11.14
 * Time: 11:49
 * To change this template use File | Settings | File Templates.
 */
public class MainTestClass {

    public static WebDriver driver;

    @BeforeSuite
    public static void before() {
        driver = new FirefoxDriver();
    }

    @DataProvider
    public Object[][] dataForReg() {
        return new Object[][] {
                new Object[] {"http://hotline.ua","yyttrrh@gm.com","tedt","181920","181920", true, "Поздравляем! Вы успешно зарегистрировались на Hotline"},
                new Object[] {"http://hotline.ua", "lshpylova@gmail.com","Lshpylova", "gargantua1", "gargantua1", false,"Извините, но такой e-mail уже занят"},
        };
    }

    @Test(dataProvider = "dataForReg")
    public static void registerTest(String siteUrl, String email, String nick, String password, String password2,boolean test, String check)
    {
        driver.get(siteUrl);
        WebDriverWait wait = new WebDriverWait(driver, 10);

        FirstPage firstpage = new FirstPage(driver);
        if (test) {
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("close"))));
            firstpage.closeWin();
        }
        firstpage.clickregbutton();
        RegDataPage regdata= new RegDataPage(driver);
        regdata.typeEmail(email);
        regdata.typeNick(nick);
        regdata.typePassword(password);
        regdata.typePassword2(password2);
        regdata.closeWin2();
        WelcomePage wel = new WelcomePage(driver);

        if (test==true){
            Assert.assertEquals(wel.welcometext(), check);


        }else{

            Assert.assertEquals(regdata.emailIsUnavailable(), check);
        }


    }


    @AfterSuite
    public void after()
    {
        if (driver != null)
            driver.quit();
    }

}
