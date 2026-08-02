package TestNg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UserLoginTesting {
    WebDriver driver;
    LoginPage page;

    @BeforeMethod
    public void openingBrowser(){
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://practicetestautomation.com/practice-test-login/");
        page = new LoginPage(driver);
    }
    @Test
    public void login(){
        page.enterUserName("student");
        page.enterPassword("Password123");
        page.clickButton();
        Assert.assertEquals(
                driver.getCurrentUrl(),
                "https://practicetestautomation.com/logged-in-successfully/"
        );

        Assert.assertEquals(
                driver.findElement(By.xpath("//a[text()='Log out']")).getText(),
                "Log out"
        );

        System.out.println("Positive Login Test Passed.");
    }
    @Test
    public void verifyInvalidUser() {
        page.enterUserName("incorrectUser");
        page.enterPassword("Password123");
        page.clickButton();
        Assert.assertEquals(
                driver.findElement(By.id("error")).getText(),
                "Your username is invalid!"
        );

        System.out.println("Negative Login Test Passed.");
    }

    @AfterMethod
    public void close(){
        System.out.println("Closing Browser.");
        driver.quit();
    }

}
