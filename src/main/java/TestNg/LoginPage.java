package TestNg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

        WebDriver driver;

        //Constructor
        public LoginPage(WebDriver driver){
            this.driver = driver;
            PageFactory.initElements(driver,this);
        }

        //Page Elements
        @FindBy(id="username")
        WebElement userName;

        @FindBy(id="password")
        WebElement password;

        @FindBy(id="submit")
        WebElement submitButton;

        //Page Action
        public void enterUserName(String user){
            userName.sendKeys(user);
        }

        public void enterPassword(String pass){
            password.sendKeys(pass);
        }

        public void clickButton(){
            submitButton.click();
        }

}
