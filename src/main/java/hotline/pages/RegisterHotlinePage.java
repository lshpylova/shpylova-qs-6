package hotline.pages;

import actors.User;
import hotline.user.HotUser;

/**
 * Created by Lena on 01.11.2014.
 */
public class RegisterHotlinePage {
    public void registration(HotUser hotuser){
        fillUserDataAndPush(hotuser);
           }

    private void fillUserDataAndPush(HotUser hotuser) {
        ValidationFields valfields= new ValidationFields();
        valfields.validationEmail("");
        valfields.validationPassword("");

    }
    public void confirmationEmailSent(HotUser hotuser){}

}