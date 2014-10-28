package lesson3.task1;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

/**
 * Created by Lena on 27.10.2014.
 */
public class Test1 {
    int c;
    @BeforeSuite
   public void preConfiguration()
    {
        c=4;
    }
    @Test
  public void test2and2()
    {
        int a=2;
        int b=2;
        a=a+b;
        Assert.assertEquals(c,4);
    }
    @AfterClass
   public void doDelete()
    {
    c=5;
    }
}
