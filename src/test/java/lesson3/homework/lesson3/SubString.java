package lesson3.homework.lesson3;

import hometask.lesson3.TestSubString;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Lena on 28.10.2014.
 */
public class SubString {
    public static WebDriver driver;

    @DataProvider
    public Object[][] filters() {
        return new Object[][]{
                new Object[]{"TestfileMy","Testmm","Test"}

        };
    }


    @BeforeSuite
    public void initEnv()
    {
        driver =new HtmlUnitDriver();
    }


    @Test(dataProvider = "filters")
    public void stringandsub(String fileName,String firstLine, String secondLine)
    {
        TestSubString test = new TestSubString();
        Assert.assertTrue(test.stringMatcher(firstLine,secondLine));
               System.out.println("Строка 1 содержит подстроку 2");
          }

    @Test(dataProvider = "filters")
public void savetofileanddelete(String fileName,String firstLine, String secondLine){
                   //Определяем файл
            File file = new File(fileName);

            try {
                //проверяем, что если файл не существует то создаем его
                if(!file.exists()){
                    file.createNewFile();
                }

                //PrintWriter обеспечит возможности записи в файл
                PrintWriter out = new PrintWriter(file.getAbsoluteFile());

                try {
                    //Записываем текст у файл
                    out.print(firstLine);
                    out.print(secondLine);
                } finally {
                    //После чего мы должны закрыть файл
                    //Иначе файл не запишется
                    out.close();
                }
            } catch(IOException e) {
                throw new RuntimeException(e);
            }


            boolean success = file.delete();
            if (!success){
                System.out.println("Deletion failed.");
                System.exit(0);
            }else{
                System.out.println("File deleted.");
            }

        }
    }


