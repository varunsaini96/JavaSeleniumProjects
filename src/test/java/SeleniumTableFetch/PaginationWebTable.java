package SeleniumTableFetch;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.List;

public class PaginationWebTable {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://testautomationpractice.blogspot.com/");

        List<WebElement> pages = driver.findElements(By.xpath("//ul[@id='pagination']//li"));
        for (WebElement page:pages){
            page.click();
            List<WebElement> rows = driver.findElements(By.xpath("//table[@id='productTable']//tr"));
            for (WebElement row: rows){
                List<WebElement> tableHeaders = row.findElements(By.tagName("th"));
                for (WebElement tableHeader: tableHeaders){
                    System.out.print(tableHeader.getText() + "  ");
                }
                List<WebElement> columns = row.findElements(By.tagName("td"));
                for (WebElement column: columns){
                    System.out.print(column.getText() + "  ");
                }
                System.out.println();
            }
        }
        driver.quit();
    }
}