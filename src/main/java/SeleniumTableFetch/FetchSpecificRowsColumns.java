package SeleniumTableFetch;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.List;
import java.util.Scanner;

public class FetchSpecificRowsColumns {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1900)");

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the starting number of the row: ");
        int startRow = sc.nextInt();
        System.out.println("Enter the ending number of the row: ");
        int endRow = sc.nextInt();
        System.out.println("Enter the starting number of the column: ");
        int startCol = sc.nextInt();
        System.out.println("Enter the ending number of the column: ");
        int endCol = sc.nextInt();

        for (int i = startRow; i <= endRow; i++) {
            for (int j = startCol; j <=endCol ; j++) {
                if (i==1) {
                    String rows = "//table[@name='BookTable']//tr["+i+"]//th["+j+"]";
                    WebElement detail = driver.findElement(By.xpath(rows));
                    System.out.print(detail.getText()+"\t");
                }else {
                    String rows = "//table[@name='BookTable']//tr["+i+"]//td["+j+"]";
                    WebElement detail = driver.findElement(By.xpath(rows));
                    System.out.print(detail.getText()+"\t");
                }
            }
            System.out.println();
        }
        driver.quit();
    }
}
