package SeleniumOthers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class iframe {
    public static void main(String[] args) {

        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://vinothqaacademy.com/iframe/");

        //switching to iframe
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement frameOne = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("employeetable")));
        driver.switchTo().frame(frameOne);
        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='myTable']//tr"));
        for (WebElement row:rows){
            List<WebElement> details = row.findElements(By.tagName("td"));
            for (WebElement detail:details){
                if (detail.getText().equals("Samuel Johnson")){
                    row.findElement(By.tagName("input")).click();
                    driver.findElement(By.id("deleteBtn")).click();
                    System.out.println("Samuel Johnson has been deleted from the table");
                    break;
                }
            }
        }
        driver.switchTo().defaultContent();// switch back to the main page or out of iframe

    }
}
