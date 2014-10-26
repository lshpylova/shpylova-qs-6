package simple;

import org.testng.Assert;
import org.testng.annotations.Test;
import test2.Mainjava;

/**
 * Created by Lena on 22.10.2014.
 */

public class FirstTest {
    @Test
    public void firstTest(){
        Mainjava q= new Mainjava();
        int s=q.Test1(4,7);
        Assert.assertEquals(s,11);
    }
}
