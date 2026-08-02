package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class PositiveLoginTest {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.get("https://practicetestautomation.com/practice-test-login/");
        LoginPage p = new LoginPage(driver);
        p.enterUserName("student");
        p.enterPassword("Password123");
        p.clickButton();
        if(driver.getCurrentUrl().equals("https://practicetestautomation.com/logged-in-successfully/")){
            System.out.println("Verified the URL.");
        }
        if(driver.findElement(By.xpath("//a[text()='Log out']")).getText().equals("Log out")){
            System.out.println("Verified the button Log out.");
        }

        System.out.println("Congratulations, you have successfully logged in the page.");

        driver.quit();
    }
}
