package com.selenium.util;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class SeleniumUtility {
    private final WebDriver driver;
    public SeleniumUtility(WebDriver driver){
        this.driver = driver;
    }

    public void click(By locator){

        WebElement element = driver.findElement(locator);
        element.click();

    }

    public void writeText(By locator,String text){

        WebElement element = driver.findElement(locator);
        element.clear();
        element.sendKeys(text);

    }

    public String getText(By locator){
        return driver.findElement(locator).getText();

    }

    public boolean isDisplayed(By locator) {

        WebElement element = driver.findElement(locator);
        return element.isDisplayed();
    }

    public boolean isEnabled(By locator){

        WebElement element = driver.findElement(locator);
        return element.isEnabled();

    }

    public boolean isSelected(By locator){

        WebElement element = driver.findElement(locator);
        return element.isSelected();

    }

    public String getAttribute(By locator,String attribute){

        WebElement element = driver.findElement(locator);
        return element.getAttribute(attribute);


    }

    public String getCssValue(By locator,String property){

        WebElement element = driver.findElement(locator);
        return element.getCssValue(property);

    }

    public void submit(By locator){

        WebElement element = driver.findElement(locator);
        element.submit();

    }

    public void switchTOFrame(By locator){

        WebElement frameElement = driver.findElement(locator);
         driver.switchTo().frame(frameElement);

    }

    public void waitUntil(By locator,int timeout){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

    }

    public void clearCookies(){

        driver.manage().deleteAllCookies();

    }

    public void screenshot(String filepath)throws Exception{

        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile,new File(filepath));

    }
    public void javascriptExecutor(String script){

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(script);

    }
}