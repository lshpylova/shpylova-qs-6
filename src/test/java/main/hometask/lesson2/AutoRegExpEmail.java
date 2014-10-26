package main.hometask.lesson2;

import hometask.lesson2.RegexpoForEmail;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by Lena on 26.10.2014.
 */

public class AutoRegExpEmail {
    private RegexpoForEmail regexpoForEmail;

    @BeforeClass
    public void initData() {
       regexpoForEmail = new RegexpoForEmail();
    }

    @DataProvider
    public Object[][] ValidEmailProvider() {
        return new Object[][] {
                {
                        new String[] {
                                "alex@yandex.ru",
                                "alex-27@yandex.com",
                                "alex.27@yandex.com",
                                "alex111@devcolibri.com",
                                "alex.100@devcolibri.com.ua",
                                "alex@1.com",
                                "alex@gmail.com.com",
                                "alex+27@gmail.com",
                                "alex-27@yandex-test.com"
                        }
                }
        };
    }

    @DataProvider
    public Object[][] InvalidEmailProvider() {
        return new Object[][] {
                {
                        new String[] {
                                "devcolibri",
                                "alex@.com.ua",
                                "alex123@gmail.a",
                                "alex123@.com",
                                "alex123@.com.com",
                                ".alex@devcolibri.com",
                                "alex()*@gmail.com",
                                "alex@%*.com",
                                "alex..2013@gmail.com",
                                "alex.@gmail.com",
                                "alex@devcolibri@gmail.com",
                                "alex@gmail.com.1ua"
                        }
                }
        };
    }

    @Test(dataProvider = "ValidEmailProvider")
    public void ValidEmailTest(String[] Email) {

        for (String temp : Email) {
            boolean valid = regexpoForEmail.validate(temp);
            System.out.println("Email: " + temp + " -> " + valid);
            Assert.assertEquals(valid, true);
        }


    }

    @Test(dataProvider = "InvalidEmailProvider", dependsOnMethods = "ValidEmailTest")
    public void InValidEmailTest(String[] Email) {

        for (String temp : Email) {
            boolean valid = regexpoForEmail.validate(temp);
            System.out.println("Email: " + temp + " -> " + valid);
            Assert.assertEquals(valid, false);
        }
    }

}
