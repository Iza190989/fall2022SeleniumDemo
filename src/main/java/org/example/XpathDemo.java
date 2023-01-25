package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class XpathDemo {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://demoqa.com/text-box");
    }
    @Test
    public void xpathTest(){

//        String name =driver.findElement(By.name("Name")).getText();
//        String name =driver.findElement(By.tagName("h5")).getText();

        WebElement emailText =driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/form/div[2]/div[1]/label\n"));
        String expectedEmailText = "Email";

        WebElement nameText2 =driver.findElement(By.xpath("//label[@id='userEmail-label']"));

        Assert.assertEquals(emailText.getText(),expectedEmailText);
        Assert.assertTrue(expectedEmailText.contains(nameText2.getText()));//

    }
    @Test
    public void xpath2(){

    WebElement userName = driver.findElement(By.xpath("//input[@id='userName']"));
    userName.sendKeys("Test123");
        System.out.println("Result is : " + userName.getAttribute("value)"));
    Assert.assertEquals(userName.getAttribute("value"),"Test123");

//    //textarea[@id='currentAddress']
//        ([@type='button'])[2]

    }

    @AfterClass
    public void tearDown(){
        driver.close();
        driver.quit();
    }

}
