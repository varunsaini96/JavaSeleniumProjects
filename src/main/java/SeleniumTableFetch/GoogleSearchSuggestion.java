package SeleniumTableFetch;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Scanner;

public class GoogleSearchSuggestion {
    public static void main(String[] args) {
//        WebDriver driver = new EdgeDriver();
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--headless=new");
        WebDriver driver = new EdgeDriver(options);
        driver.get("https://www.google.com");
//        driver.manage().window().maximize();
        WebElement searchField = driver.findElement(By.id("APjFqb"));
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the search field here: ");
        String searchItem = sc.nextLine();
        searchField.sendKeys(searchItem);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='Alh6id']")));
        System.out.println("Below are the search suggestions:-");

        List<WebElement> list = driver.findElements(By.xpath("//div[@id='Alh6id']//li"));
        for (WebElement l:list){
            System.out.println(l.getText());
        }
    }
}
