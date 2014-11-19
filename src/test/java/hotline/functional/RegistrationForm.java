package hotline.functional;
import actors.User;
import org.testng.Assert;
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
public class RegistrationForm extends AbstractWebDriver {


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
        regdata.dataForReg(user.email,user.nickname,user.passwd,user.passwd);
        regdata.registerClick();
        WelcomePage wel = new WelcomePage(driver);
       if (positive==true){
           Assert.assertTrue(wel.welcomeText()==true," Welcome Page.class. Test was failed with welcomeTest() method");
           Log4Test.info("Welcome Page.class. Test was passed with welcomeTest() method.");

        }else{
           Assert.assertTrue(regdata.emailIsUnavailable()==true,"RegDaraPage.class. Test was failed with emailIsUnacailable() method");
           Log4Test.info("RegDaraPage.class. Test was passed with emailIsUnacailable() method.");


       }


         }
}
