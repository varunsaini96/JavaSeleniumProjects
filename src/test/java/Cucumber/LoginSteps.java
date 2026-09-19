package Cucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

public class LoginSteps {
    WebDriver driver = DriverManager.getDriver();

    @Given("the user is on the login page")
    public void openLoginPage(){
        driver.get("https://practicetestautomation.com/practice-test-login/");
    }

    @When("the user enters username {string} and password {string}")
    public void enterUsernamePassword(String username, String password){
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("submit")).click();
    }

    @Then("the Logged In Successfully displayed")
    public void verifyWelcomeMessage(){
        String msg = driver.findElement(By.cssSelector(".post-title")).getText();
        Assert.assertEquals(msg,"Logged In Successfully","Check the login credentials.");
    }
}
