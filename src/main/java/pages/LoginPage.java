package pages;

import org.apache.logging.log4j.core.util.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;

    @FindBy(id="username")
    WebElement userNameField;

    @FindBy(name="password")
    WebElement passwordField;

    @FindBy(xpath = "//p[@class=\"btn btn-lg btn-block btn-light lift text-uppercase\"]")
    WebElement loginButton;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    private void enterUserName(String username){
        userNameField.sendKeys(username);
    }

    private void enterPassword(String password){
        passwordField.sendKeys(password);
    }

    private void clickLoginButton(){
        loginButton.click();
    }

    public void doLogin() {
        try {
            enterUserName("8881771085");
            enterPassword("Sr@123456");
            clickLoginButton();
        } catch (Exception e) {
        System.out.println(e.getMessage());

    }
    }
}


