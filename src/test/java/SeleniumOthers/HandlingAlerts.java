package SeleniumOthers;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.edge.EdgeDriver;

public class HandlingAlerts {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://testautomationpractice.blogspot.com/");

        //accepting the alert
        driver.findElement(By.id("alertBtn")).click();
        Thread.sleep(2000);
        driver.switchTo().alert().accept();

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://testautomationpractice.blogspot.com/");

        //giving input to alert
        driver.findElement(By.id("promptBtn")).click();
        Alert alertBox = driver.switchTo().alert();
        alertBox.sendKeys("Tony Stark");
        Thread.sleep(2000);
        alertBox.accept();
    }

}
