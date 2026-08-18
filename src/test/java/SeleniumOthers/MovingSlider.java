package SeleniumOthers;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class MovingSlider {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://testautomationpractice.blogspot.com/");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1200)");

        WebElement initialPoint = driver.findElement(By.xpath("//span[@style='left: 15%;']"));
        WebElement endPoint = driver.findElement(By.xpath("//span[@style='left: 60%;']"));

        System.out.println("Location of the initial Point of slider: " + initialPoint.getLocation());
        System.out.println("Location of the end Point of slider: " + endPoint.getLocation());

        //Actions is a class
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(initialPoint,50,0).perform();

        //Action is an interface
        Action act = actions.dragAndDropBy(endPoint,-20,0).build();
        act.perform();

        System.out.println("Location of the initial Point of slider after dragged: " + initialPoint.getLocation());
        System.out.println("Location of the end Point of slider: " + endPoint.getLocation());
    }
}
