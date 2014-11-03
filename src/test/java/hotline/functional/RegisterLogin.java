package hotline.functional;

import hotline.user.HotUser;
import org.testng.Assert;
import org.testng.annotations.Test;
import hotline.pages.*;


/**
 * Created by Lena on 01.11.2014.
 */
public class RegisterLogin {
    @Test
    public void registerSingleUser( HotUser user){
        HomePageHotline homepage = new HomePageHotline();
        homepage.registrationClick();
        RegisterHotlinePage regpage = new RegisterHotlinePage();
        regpage.registration(user);
        regpage.confirmationEmailSent(user);
        EmailConfirmtionPage email = new EmailConfirmtionPage();

        if (email.getConfirmationEmail()==true) {
            Assert.assertTrue(email.getConfirmationEmail());
        }

    }
}
