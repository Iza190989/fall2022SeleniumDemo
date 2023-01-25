package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class UploadDownloDemo extends BasedTest {
    @Test
    public void test1(){
        driver.navigate().to("https://demoqa.com/upload-download");
        driver.findElement(By.id("uploadFile")).sendKeys("C:\\Users\\Админ\\Desktop\\Meder\\aza");
    }
}
