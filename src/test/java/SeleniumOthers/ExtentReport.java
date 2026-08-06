package SeleniumOthers;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.List;
import java.util.Scanner;

public class ExtentReport {
    public static void main(String[] args) {

        //Initialize Extent Report
        String file ="Report.html";
        ExtentSparkReporter spark = new ExtentSparkReporter(file);
        ExtentReports reports = new ExtentReports();
        reports.attachReporter(spark);

        //Launch Browser
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        try {
            driver.get("https://practicetestautomation.com/practice-test-login/");
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the username: ");
            String user = sc.nextLine();
            driver.findElement(By.id("username")).sendKeys(user);
            driver.findElement(By.id("password")).sendKeys("Password123");
            driver.findElement(By.id("submit")).click();

            //Test case 1: Verify login
            ExtentTest test = reports.createTest("Verify the login page.");
            String expectedUrl = "https://practicetestautomation.com/logged-in-successfully/";
            if (driver.getCurrentUrl().equals(expectedUrl)) {
                test.log(Status.PASS, "Login Successful.");
                test.log(Status.PASS, "Verified URL.");
            } else {
                test.log(Status.FAIL, "Login Failed.");
            }

            //Test 2: Verify the Username
            ExtentTest test2 = reports.createTest("Verify Username.");
            List<WebElement> error = driver.findElements(By.id("error"));
            if (!error.isEmpty()) {
                String message = driver.findElement(By.id("error")).getText();
                if (message.equals("Your username is invalid!")) {

                    test2.log(Status.FAIL, "Incorrect Username.");

                } else {

                    test2.log(Status.FAIL, message);
                }
            } else {

                test2.log(Status.PASS, "Username verified successfully.");
            }
        }catch (Exception e){
            ExtentTest exceptionTest = reports.createTest("Exception");
            exceptionTest.log(Status.FAIL, e.getMessage());
        } finally {
            reports.flush();
            driver.quit();
        }

    }
}
