package TestNg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class UsingDataProvider {

    static WebDriver driver;

    @BeforeMethod
    public static void driverSetUp(){
        driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    @DataProvider(name="googleData")
    public Object [][] getData(){
        return new Object[][]{
                {"Selenium"},
                {"Java"}
        };
    }

    @Test(dataProvider = "googleData")
    public void testing(String value){
        driver.get("https://www.google.com/");
        driver.findElement(By.id("ti6dpd")).sendKeys(value);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println(e.getStackTrace());
        }
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        if (driver!=null) driver.quit();
    }
}
