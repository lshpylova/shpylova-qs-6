package hometask.lesson3;

import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Lena on 29.10.2014.
 */
public class TestSubString {

    public boolean stringMatcher(String str1,String str2){
      return  (str1.indexOf(str2) != -1);
    }



}
