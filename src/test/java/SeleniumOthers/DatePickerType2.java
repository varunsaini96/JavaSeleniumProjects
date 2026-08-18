package SeleniumOthers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class DatePickerType2 {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.automationtesting.in/Datepicker.html");

        WebElement datePicker = driver.findElement(By.id("datepicker2"));
        datePicker.click();

        WebElement availableYear = driver.findElement(By.xpath("//select[@title='Change the year']"));
        Select selectYear = new Select(availableYear);
        selectYear.selectByVisibleText("2025");

        WebElement availableMonth = driver.findElement(By.xpath("//select[@title='Change the month']"));
        Select selectMonth = new Select(availableMonth);
        selectMonth.selectByVisibleText("March");

        driver.findElement(By.xpath("//a[text()='24']")).click();
    }
}
