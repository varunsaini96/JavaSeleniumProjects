package SeleniumOthers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CheckSortedDropDown {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();

        driver.get("https://practice.expandtesting.com/dropdown");

        WebElement dropDown = driver.findElement(By.id("country"));
        Select select = new Select(dropDown);
        System.out.println("Below are the list of countries given in options: ");
        List<WebElement> options = select.getOptions();
        List<String> lists = new ArrayList<>();
        List<String> optionsList = new ArrayList<>();
        for (WebElement option: options){
            if (option.getText().equals("Select country")) continue;
            optionsList.add(option.getText());
            lists.add(option.getText());
        }

        for (String opt : optionsList){
            System.out.print(opt+",");
        }

        System.out.println();
        System.out.println("------------------------------------------------------------------");
        System.out.println("Below are the list of countries in sorted order: ");
        Collections.sort(lists);
        for (String list:lists){
            System.out.print(list+",");
        }

        System.out.println();
        if (optionsList.equals(lists)) System.out.println("Countries are in sorted order.");
        else System.out.println("Countries are not in sorted order.");
    }
}
