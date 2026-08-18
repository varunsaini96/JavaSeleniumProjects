package SeleniumOthers;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.Set;

public class ManagingCookies {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.get("https://flipkart.com");

        Set<Cookie> cookies = driver.manage().getCookies();
        System.out.println("Size of cookies: " + cookies.size());
        for (Cookie cookie:cookies){
            System.out.println("Name of the cookie: "+ cookie.getName() + "-" + "cookie value: " + cookie.getValue());
        }

        //adding one cookie
        Cookie myCookie = new Cookie("MyCookie","12345");
        driver.manage().addCookie(myCookie);
        cookies = driver.manage().getCookies();
        System.out.println("size of cookies: " + cookies.size());

        //deleting the cookie
        driver.manage().deleteCookieNamed("MyCookie");
        cookies = driver.manage().getCookies();
        System.out.println("size of cookies: "+ cookies.size());
    }
}
