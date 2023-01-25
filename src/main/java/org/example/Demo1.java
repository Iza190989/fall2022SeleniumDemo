package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class Demo1 {



    @Test
    public void testDemo1() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://demoqa.com/text-box");

        WebElement fullNameInputField = driver.findElement(By.id("userName"));
        fullNameInputField.sendKeys("Izat");

        WebElement userEmail = driver.findElement(By.id("userEmail"));
        userEmail.sendKeys("john@gmail.com");

        WebElement currentAddress = driver.findElement(By.id("currentAddress"));
        currentAddress.sendKeys("Adress 123");

        WebElement permanentAddress = driver.findElement(By.id("permanentAddress"));
        permanentAddress.sendKeys("Bishkek");

//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("window.scrollBy(0,250)", "");



        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();


    }
}
//    JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("window.scrollBy(0,250)", "");
//import org.openqa.selenium.JavascriptExecutor;

