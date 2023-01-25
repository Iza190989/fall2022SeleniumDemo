package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class RelatXpath {
    WebDriver driver;

    @BeforeTest
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://glovoapp.com/kg/ru/bishkek/");

    }

    @Test(description = "Find sign box on the title page and click it",priority = 1)
    public void signBox(){
        WebElement signButton =driver.findElement(By.xpath("(//button[@id='user-register'])[2]"));
        signButton.click();
    }

    @Test(description = "Find full name input field and input dates ",priority = 2)
    public void signInName(){
        WebElement fullNameInputField = driver.findElement(By.xpath("(//input[@type='text'])[2]"));
        fullNameInputField.sendKeys("Izat");

    }

    @Test(description = "Find email input field amd sign in ",priority = 3)
    public void signInEmail(){
        WebElement emailInputField = driver.findElement(By.xpath("(//input[@type='text'])[3]"));
        emailInputField.sendKeys("Kerimbaev@gmail.com");
    }

    @Test(description = "Find password input field amd sign in",priority = 4)
    public void signInPsd(){
        WebElement fullPsdInputField = driver.findElement(By.xpath("//input[@type='password']"));
        fullPsdInputField.sendKeys("MSf");

    }

    @AfterTest
    public void tearDown (){
        driver.close();
        driver.quit();
    }
}
