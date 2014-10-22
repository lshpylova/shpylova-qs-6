package simple;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Lena on 22.10.2014.
 */

public class FirstTest {
    @Test
    public void firstTest(){
        System.out.print("new print");
        Assert.assertTrue(true);
    }
}
