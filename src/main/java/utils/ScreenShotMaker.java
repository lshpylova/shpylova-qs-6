package utils;

/**
 * Created by Lena on 19.11.2014.
 */
        import org.apache.commons.io.FileUtils;
        import org.openqa.selenium.OutputType;
        import org.openqa.selenium.TakesScreenshot;
        import org.openqa.selenium.remote.Augmenter;
        import selenium.WebDriverWrapper;

        import java.io.File;
        import java.io.IOException;

/**
 * Created by bionic on 11/17/14.
 */
public class ScreenShotMaker {
    protected WebDriverWrapper driver;
    private static String screenShotDirectory;

    public static void clearScreenShotSubDirectory(String screenShotSubDirectory)
    {
        File scrSubDir = new File(PropertyLoader.loadProperty("project.dir"),(new File(screenShotDirectory,screenShotSubDirectory)).toString());

        if (scrSubDir.exists()) {
            try {
                FileUtils.cleanDirectory(scrSubDir);
            } catch (IOException e) {

            }
        }
    }

    public ScreenShotMaker(WebDriverWrapper driver)
    {
        this.driver = driver ;
        screenShotDirectory = PropertyLoader.loadProperty("screenshot.folder");
        File scrDir = new File (screenShotDirectory);
        if (!scrDir.exists())
            scrDir.mkdirs();
    }

    public void takeScreenShot(String scrName)
    {
        String scrFormat = PropertyLoader.loadProperty("screenshot.format");
        try {
            Augmenter augmenter = new Augmenter();
            File scrFile = ((TakesScreenshot)augmenter.augment(driver)).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File(screenShotDirectory + scrName + scrFormat));
        }
        catch (Exception e)
        {

        }
    }
}
