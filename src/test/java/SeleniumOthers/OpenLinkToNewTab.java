package SeleniumOthers;

import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class OpenLinkToNewTab {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://testautomationpractice.blogspot.com/");

        WebElement blog = driver.findElement(By.linkText("Blog"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,3000)");
        Thread.sleep(3000);

//        By using keys.chord
//        String tab = Keys.chord(Keys.CONTROL,Keys.RETURN);
//        blog.sendKeys(tab);

//        By using actions class
        Actions actions = new Actions(driver);
        actions.moveToElement(blog)
                .keyDown(Keys.CONTROL)
                .click()
                .keyUp(Keys.CONTROL)
                .perform();
    }
}
