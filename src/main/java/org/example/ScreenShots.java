package org.example;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class ScreenShots extends BasedTest {

    @Test
    public void screenShot() throws Exception {
        browserHelper.openURL("https://www.amazon.com/");
        takeSnapShot(driver, "C:\\Users\\НУР\\IdeaProjects\\UI_framework_Practice\\src\\main\\resources\\Amazon.png");

    }

    public void takeSnapShot(WebDriver webdriver, String fileWithPath) throws Exception {
//Convert web driver object to TakeScreenshot
        TakesScreenshot scrShot = ((TakesScreenshot) webdriver);
//Call getScreenshotAs method to create image file
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
//Move image file to new destination
        File DestFile = new File(fileWithPath);
//Copy file at destination
        FileUtils.copyFile(SrcFile, DestFile);
    }

    @Test
    public void screenShot2() throws IOException {

        browserHelper.openURL("https://ru-ru.facebook.com/");
        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        File trg = new File(".\\screenshots\\facebook.png");
        FileUtils.copyFile(src, trg);


    }

    @Test
    public void screenShotSection() throws IOException {

        browserHelper.openURL("https://nambafood.kg/?language=ru");
        WebElement section = driver.findElement(By.xpath("(//div[@class='home--cat-item wrap--item'])[1]"));
        File src = section.getScreenshotAs(OutputType.FILE);
        File trg = new File(".\\screenshots\\facebook.png");
        FileUtils.copyFile(src, trg);

    }
}
