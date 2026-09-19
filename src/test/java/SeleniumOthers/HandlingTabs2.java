package SeleniumOthers;

import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class HandlingTabs2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://testautomationpractice.blogspot.com/");

        WebElement newTab = driver.findElement(By.xpath("//button[text()='New Tab']"));
        newTab.click();

        Thread.sleep(2000);

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.google.com/");
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.youtube.com/");

        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.facebook.com/");

        Set<String> set = driver.getWindowHandles();
        List<String> tabs = new ArrayList<>(set);
        String practice = tabs.get(0);
        String practiceNewTab = tabs.get(1);
        String google = tabs.get(2);
        String youtube = tabs.get(3);
        String facebook = tabs.get(4);

        driver.switchTo().window(practice);
        System.out.println(driver.getTitle());

        Thread.sleep(2000);

        driver.switchTo().window(practiceNewTab);
        System.out.println(driver.getTitle());

        Thread.sleep(2000);

        driver.switchTo().window(google);
        System.out.println(driver.getTitle());

        Thread.sleep(2000);

        driver.switchTo().window(youtube);
        System.out.println(driver.getTitle());

        Thread.sleep(2000);

        driver.switchTo().window(facebook);
        System.out.println(driver.getTitle());

    }
}