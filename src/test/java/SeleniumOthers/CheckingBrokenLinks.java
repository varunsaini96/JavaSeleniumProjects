package SeleniumOthers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class CheckingBrokenLinks {
    public static void main(String[] args) throws IOException {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        int emptyURL = 0;
        int validURL = 0;
        int brokenURL = 0;

        driver.get("https://testautomationpractice.blogspot.com/");

        List<WebElement> hyperlinks = driver.findElements(By.tagName("a"));

        for (WebElement hyperlink:hyperlinks){
            String url = hyperlink.getAttribute("href");

            if (url==null || url.isEmpty()){
                System.out.println("Url is empty");
                emptyURL++;
                continue;
            }

            URL link = null;
            try {
                link = new URL(url);
            } catch (MalformedURLException e) {
                System.out.println(e.getMessage());
            }
            HttpURLConnection httpCon = null;
            try {
                httpCon = (HttpURLConnection) link.openConnection(); //creates and prepares a connection object for the given URL
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            try {
                httpCon.connect(); //establishes the actual connection with the server
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            if (httpCon.getResponseCode()>=400){
                System.out.println(httpCon.getResponseCode()+" is " + "Broken link for URL: " + url);
                brokenURL++;
            } else {
                System.out.println(httpCon.getResponseCode() + " is " + "Valid link for URL: " + url);
                validURL++;
            }

        }
        System.out.println("Empty URL: "+ emptyURL);
        System.out.println("Broken URL: " + brokenURL);
        System.out.println("Valid URL: " + validURL);
    }
}
