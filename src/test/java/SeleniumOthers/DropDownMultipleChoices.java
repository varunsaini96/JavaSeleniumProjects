package SeleniumOthers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;
import java.util.List;

public class DropDownMultipleChoices {
    public static void main(String[] args) {

        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
        driver.findElement(By.id("justAnInputBox")).click();
//        dropDownMultipleChoices(driver,"all");
        dropDownMultipleChoices(driver,"choice 2 1","choice 6 2 1");
    }

    public static void dropDownMultipleChoices(WebDriver driver, String... value){
        List<WebElement> multiOptions = driver.findElements(By.xpath("//span[@class='comboTreeItemTitle']"));

        if (!value[0].equalsIgnoreCase("all")){
            for (WebElement choice: multiOptions){
                String text = choice.getText();
                for (String val : value){
                    if (text.equals(val)){
                        choice.click();
                        break;
                    }
                }
            }
        }
        else {
            for (WebElement choice: multiOptions){
                choice.click();
            }
        }
    }
}
