package SeleniumOthers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ChooseOptions {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");
        WebElement chooseState = driver.findElement(By.id("state"));
        WebElement chooseCity = driver.findElement(By.id("city"));
        chooseOptions(chooseState,"Uttar Pradesh");
        chooseOptions(chooseCity, "Agra");
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");
        // Find elements again for second tab
        WebElement chooseState2 = driver.findElement(By.id("state"));
        WebElement chooseCity2 = driver.findElement(By.id("city"));
        chooseOptions2(chooseState2,"Uttar Pradesh");
        chooseOptions2(chooseCity2, "Meerut");
        //switching tabs
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());//using Arraylist as set doesn't support index based access.
            driver.switchTo().window(tabs.get(0));
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.switchTo().window(tabs.get(1));
    }

   static void chooseOptions(WebElement element, String text){
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }

    static void chooseOptions2(WebElement element, String text){
        Select select = new Select(element);
        List<WebElement> options = select.getOptions();
        for (WebElement option:options){
            if (option.getText().equals(text)){
                option.click();
                break;
            }
        }
    }
}
