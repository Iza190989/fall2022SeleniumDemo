package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BasedTest {
   static WebDriver driver;
    BrowserHelper browserHelper;
    AlertHelper alertHelper;

    @BeforeClass
    public void setUp() {


        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        browserHelper = new BrowserHelper(driver);
        alertHelper = new AlertHelper(driver);

    }
//
//    @AfterClass
//    public void tearDown(){
//        driver.close();
//        driver.quit();
//    }
}
