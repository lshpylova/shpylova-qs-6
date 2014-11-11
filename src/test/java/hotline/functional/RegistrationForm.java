package hotline.functional;
import actors.User;
import hotline.pages.WebDriverClass;
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
import utils.Log4Test;

/**
 * Created with IntelliJ IDEA.
 * User: shpylova-o
 * Date: 05.11.14
 * Time: 11:49
 * To change this template use File | Settings | File Templates.
 */
public class RegistrationForm extends WebDriverClass {


    public User user= new User();
    @DataProvider(name="testData1")
    public Object[][] testData() {
        return new Object[][] {
                {"http://hotline.ua",user, true, "Поздравляем! Вы успешно зарегистрировались на Hotline"},
                {"http://hotline.ua",user,false,"Извините, но такой e-mail уже занят"}
        };

    }

    @Test(dataProvider = "testData1")

   public static void registerTest(String siteUrl, User user,boolean positive, String check)
    {
      driver.get(siteUrl);
      FirstPage firstpage = new FirstPage(driver);
        if(positive) {
            firstpage.closeWin();
            firstpage.closeSelector();
        }
        firstpage.clickregbutton();
        RegDataPage regdata= new RegDataPage(driver);
        regdata.typeEmail(user.email);
        regdata.typeNick(user.nickname);
        regdata.typePassword(user.passwd);
        regdata.typePassword2(user.passwd);
        regdata.registerClick();

        WelcomePage wel = new WelcomePage(driver);
       if (positive==true){
           Assert.assertTrue(wel.welcometext()==true,"pass the registration");
          //  Assert.assertEquals(wel.welcometext(), check);
        }else{
        //    Assert.assertEquals(regdata.emailIsUnavailable(), check, "email is true");

           Assert.assertTrue(regdata.emailIsUnavailable()==true,"email is exist");

       }


            }
}
