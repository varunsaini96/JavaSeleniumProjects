package SeleniumOthers;

import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class TakingScreenShots {
    public static void main(String[] args) {

        String imagesFile = "C:\\Users\\saini\\Documents\\Projects\\Java\\JavaSelenium\\src\\test\\java\\images\\";
        WebDriver driver = new EdgeDriver();
        driver.get("https://www.flipkart.com/");
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        WebElement close = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span.b3wTlE")));
        close.click();
        WebElement searchItem = driver.findElement(By.xpath("//input[@class='nw1UBF v1zwn25' and @title='Search for Products, Brands and More']"));
        searchItem.sendKeys("Iphone 16");
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ENTER).perform();
        //capture the screenshot for whole window
        TakesScreenshot ts = (TakesScreenshot) driver;
        File f = ts.getScreenshotAs(OutputType.FILE);
        File fileDest = new File(imagesFile+"iphone16sc.png");
        try {
            FileHandler.copy(f,fileDest);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        //capture the screenshot of a particular section
        WebElement section = driver.findElement(By.xpath("//div[@data-id='MOBH4DQF849HCG6G']"));
        File sectionFile = section.getScreenshotAs(OutputType.FILE);
        File sectionFileDir = new File(imagesFile+"sectionImage.png");
        try {
            FileHandler.copy(sectionFile,sectionFileDir);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        driver.quit();
    }
}
