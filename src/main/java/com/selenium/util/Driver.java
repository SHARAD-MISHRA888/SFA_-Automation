package com.selenium.util;

import constant.BrowserTypes;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {

    public WebDriver driver;
    public void openBrowser(String browserName, String url){
        switch(BrowserTypes.valueOf(browserName.toUpperCase())) {
            case CHROME:  chrome();
            break;
            case EDGE: edge();
            break;
            case FIREFOX: firefox();
            break;

        }
        driver.get(url);

    }

    public void  chrome(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    public void edge(){
        driver = new EdgeDriver();
        driver.manage().window().maximize();
    }
    public void firefox(){
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }
    public void closeBrowser(){
        driver.quit();
    }
}
