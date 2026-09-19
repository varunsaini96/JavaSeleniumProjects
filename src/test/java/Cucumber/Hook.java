package Cucumber;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hook {

    @Before
    public void setUp(){
        DriverManager.getDriver();
        System.out.println("Browser launched.");
    }

    @After
    public void quit(){
        DriverManager.quitDriver();
        System.out.println("Browser closed.");
    }
}
