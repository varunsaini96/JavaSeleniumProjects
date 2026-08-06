package SeleniumTableFetch;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Scanner;

public class FetchSpecificCell {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.get("https://testautomationpractice.blogspot.com/");
        System.out.println("This is applicable for the Static Web Table......");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the row number: ");
        int r = sc.nextInt();
        System.out.println("Enter the column number: ");
        int c = sc.nextInt();

        WebElement cell = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td["+c+"]"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOf(cell));
        System.out.println(cell.getText());

    }
}
