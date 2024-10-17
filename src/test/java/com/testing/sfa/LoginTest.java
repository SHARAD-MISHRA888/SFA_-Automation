package com.testing.sfa;

import com.selenium.util.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.util.ResourceBundle;

public class LoginTest extends Driver {

    ResourceBundle rb = ResourceBundle.getBundle("config");
    String url = rb.getString("url");
    String browser = rb.getString("browser");

    WebDriver driver;
    LoginPage loginPage;

    @Test
    public void loginBrowser() {
        openBrowser(browser,url);
        loginPage = new LoginPage(driver);

    }

    @Test

    public void validTestLogin(){
//        loginPage.enterUserName("8881771085");
//        loginPage.enterPassword("Sr@123456");
//        loginPage.clickLoginButton();
    }



}
