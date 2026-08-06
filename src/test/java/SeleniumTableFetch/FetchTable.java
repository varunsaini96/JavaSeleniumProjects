package SeleniumTableFetch;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.time.Duration;
import java.util.List;

public class FetchTable {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.get("https://testautomationpractice.blogspot.com");
        driver.manage().window().maximize();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1900)");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@name='BookTable']")));

        List<WebElement> rows = driver.findElements(By.xpath("//table[@name='BookTable']//tr"));
        for(WebElement row:rows){
            List<WebElement> header = row.findElements(By.tagName("th"));
            for (WebElement th:header){
                System.out.print(th.getText()+"\t");
            }
            List<WebElement> columns = row.findElements(By.tagName("td"));
            for (WebElement col:columns){
                System.out.print(col.getText()+"\t");
            }
            System.out.println();
        }
        driver.quit();
    }
}
