package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestDemo {
    WebDriver driver =new ChromeDriver();

    @BeforeTest
    public void setUp(){

        WebDriverManager.chromedriver().setup();


        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.get("https://lalafo.kg/");

    }
    @Test
    public void testSearch(){

      WebElement searchBox =driver.findElement(By.className("mainSearchInput"));
      searchBox.sendKeys("Honda Fit");

      WebElement submitButton =driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[1]/div[1]/div/div/div/div/div[1]/button/span/svg/path"));

      submitButton.click();

    }




}
