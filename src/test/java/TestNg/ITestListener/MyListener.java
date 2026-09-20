package TestNg.ITestListener;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class MyListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result){
        System.out.println("Test Failed");
        TakesScreenshot ts = (TakesScreenshot) TitleTest.driver;
        File f = ts.getScreenshotAs(OutputType.FILE);
        File location = new File("C:\\Users\\saini\\Documents\\Projects\\Java\\JavaSelenium\\src\\test\\java\\TestNg\\FailedImages\\titletest.png");
        try {
            FileHandler.copy(f,location);
        } catch (IOException e) {
            System.out.println(e.getStackTrace());
        }
    }

    @Override
    public void onTestSuccess(ITestResult result){
        System.out.println("Test Passed");
    }
}
