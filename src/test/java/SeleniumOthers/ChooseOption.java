package SeleniumOthers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class ChooseOption {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");

        WebElement dropDown = driver.findElement(By.id("state"));

        Select select = new Select(dropDown);
        select.selectByVisibleText("Uttar Pradesh");//select Uttar Pradesh
//        select.selectByValue("Uttar Pradesh"); //select Uttar Pradesh
//        select.selectByIndex(2); //select Uttar Pradesh
    }
}
