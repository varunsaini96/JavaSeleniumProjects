package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class NegativeUserNameTest {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.get("https://practicetestautomation.com/practice-test-login/");
        LoginPage negUser = new LoginPage(driver);
        negUser.enterUserName("incorrectUser");
        negUser.enterPassword("Password123");
        negUser.clickButton();
        if (driver.findElement(By.xpath("//div[@id='error' and text()='Your username is invalid!']")).getText().equals("Your username is invalid!")){
            System.out.println("You have entered wrong username.");
        }

        driver.quit();
    }
}
