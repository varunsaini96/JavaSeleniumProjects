package SeleniumOthers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class HandlingTabs {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.letskodeit.com/practice");

//        String windowID = driver.getWindowHandle(); //return id of the single browser window.
        driver.findElement(By.id("opentab")).click();

        Set<String> tabs = driver.getWindowHandles();

//        //1st method
//        Iterator<String> it = tabs.iterator();
//        String parent = it.next();
//        String child = it.next(); // it gives the id of the tabs.

        //2nd method
        List<String> tabsList = new ArrayList<>(tabs); //converting set to list
        String parent2 = tabsList.get(0); //parent window id
        String child2 = tabsList.get(1); //child window id

        //switching driver
        driver.switchTo().window(parent2);
        System.out.println("Parent tab title: " + driver.getTitle());
        driver.switchTo().window(child2);
        System.out.println("Child tab title: " + driver.getTitle());
        driver.switchTo().window(parent2);
    }
}
