package TestNg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class UsingDataProvider {
    @DataProvider(name="googleData")
    public Object [][] getData(){
        return new Object[][]{
                {"Selenium"},
                {"Java"}
        };
    }

    @Test(dataProvider = "googleData")
    public void testing(String value){
        WebDriver driver = new EdgeDriver();
        driver.get("https://www.google.com/");
        driver.findElement(By.id("ti6dpd")).sendKeys(value);
    }
}
