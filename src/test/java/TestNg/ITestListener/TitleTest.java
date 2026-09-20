package TestNg.ITestListener;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(MyListener.class)
public class TitleTest {
    public static WebDriver driver;

    @Test
    public void googleTitleTest(){
        driver = new EdgeDriver();
        driver.get("https://www.google.com/");

        String title = driver.getTitle();

        Assert.assertEquals(title,"Googlei");
    }

    @AfterMethod
    public void browserClose(){
        if (driver!=null) driver.quit();
    }
}
