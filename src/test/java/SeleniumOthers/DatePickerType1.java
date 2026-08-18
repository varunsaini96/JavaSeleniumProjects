package SeleniumOthers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;
import java.util.List;

public class DatePickerType1 {
    public static void main(String[] args) {

        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.automationtesting.in/Datepicker.html");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String date = "21";
        String month = "December";
        String year = "2026";

        WebElement datePicker = driver.findElement(By.id("datepicker1"));
        datePicker.click();

        while (true){
            WebElement next = driver.findElement(By.xpath("//a[@class='ui-datepicker-next ui-corner-all']"));
            WebElement availableYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']"));
            String selectedYear = availableYear.getText();
            WebElement availableMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']"));
            String selectedMonth = availableMonth.getText();
            if (selectedYear.equalsIgnoreCase(year) && selectedMonth.equalsIgnoreCase(month)){
                List<WebElement> availableDates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tr//td//a"));
                for (WebElement availableDate:availableDates){
                    if(availableDate.getText().equals(date)) {
                        availableDate.click();
                        break;
                    }
                }

            } else next.click();
        }
    }
}
