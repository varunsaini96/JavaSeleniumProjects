package SeleniumOthers;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class KeyBoardActions {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.diffchecker.com/");

        WebElement popup = driver.findElement(By.cssSelector("button[aria-label='Close modal']"));
        popup.click();
        Actions actions = new Actions(driver);
        WebElement input1 = driver.findElement(By.xpath("//div[@aria-label='Original text input']"));
        WebElement input2 = driver.findElement(By.xpath("//div[@aria-label='Changed text input']"));
        input1.click();
        input1.sendKeys("Welcome to my Automation Script!");
        CtrlA(actions);
        CtrlC(actions);
        actions.sendKeys(Keys.TAB).perform();
        actions.sendKeys(Keys.TAB).perform();
        CtrlV(actions);

        if (input1.getText().equals(input2.getText())) System.out.println("Matched");
        else System.out.println("Not matched");
    }

    static void CtrlA(Actions actions){
        actions.keyDown(Keys.CONTROL);
        actions.sendKeys("a");
        actions.keyUp(Keys.CONTROL);
        actions.perform();
    }

    static void CtrlC(Actions actions){
        actions.keyDown(Keys.CONTROL);
        actions.sendKeys("c");
        actions.keyUp(Keys.CONTROL);
        actions.perform();
    }

    static void CtrlV(Actions actions){
        actions.keyDown(Keys.CONTROL);
        actions.sendKeys("v");
        actions.keyUp(Keys.CONTROL);
        actions.perform();
    }


}
