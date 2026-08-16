package SeleniumOthers;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class DropDownSelection {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.get("https://www.google.com/");

        WebElement searchField = driver.findElement(By.id("APjFqb"));
        searchField.sendKeys("Selenium");
        String text;

        do {
            searchField.sendKeys(Keys.ARROW_DOWN);
            text = searchField.getAttribute("value");
            if (text.equals("selenium rich foods")){
                searchField.sendKeys(Keys.ENTER);
                break;
            }
        }while (!text.isEmpty());
    }
}
