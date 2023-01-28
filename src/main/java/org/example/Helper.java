package org.example;

import com.google.common.base.Function;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Helper {
    static JavascriptExecutor js;
    static TakesScreenshot ts;


    public static void pause(Integer milliseconds) {
        try {
            TimeUnit.MILLISECONDS.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void jsClick(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }

    public static void jsScrollDown(WebDriver driver, String pixels) {
        js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0" + pixels + ")", "");
    }

    public static void waitForElementToBeDisplayed(WebDriver driver, WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.visibilityOf(element)).click();

    }

    public static void waitForElementToBeClickable(WebDriver driver, WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.elementToBeClickable(element)).click();

    }

    public static void sendKeysOnWebElement(WebDriver driver, WebElement element, String text) {
        new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.visibilityOf(element));
        js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value='" + text + "'", element);
        element.sendKeys(Keys.ENTER);
    }

    public static void takeScreenShotFullPage(WebDriver driver, String fileName) throws IOException {
        //Full page screen
        ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        File trg = new File(".\\screenshots\\" + fileName + ".png");
        FileUtils.copyFile(src, trg);


    }

    public static void takeScreenShotWebElement(WebElement element, String fileName) throws IOException {
        //section screen on the page
        //specific element on the page
        File src = element.getScreenshotAs(OutputType.FILE);
        File trg = new File(".\\screenshots\\" + fileName + ".png");//target location
        FileUtils.copyFile(src, trg);
    }

    public static WebElement waitForElementWithFluentWait(WebDriver driver, final By locator) {
        // Waiting 30 seconds for an element to be present on the page, checking
        // for its presence once every 5 seconds.
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30L))
                .pollingEvery(Duration.ofSeconds(5L))
                .ignoring(NoSuchElementException.class);

        WebElement element = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(locator);
            }
        });


        return element;
    }
}



