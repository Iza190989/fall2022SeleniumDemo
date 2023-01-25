package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class FrameDemo extends BasedTest {
    @Test
    public void test1() {

        driver.get("https://demoqa.com/frames");
        driver.switchTo().frame(2);
        WebElement text1 = driver.findElement(By.id("sampleHeading"));
        System.out.println(text1.getText());
        driver.switchTo().defaultContent();
        driver.switchTo().frame(3);
        WebElement text2 = driver.findElement(By.id("sampleHeading"));
        System.err.println(text2.getText());
        driver.switchTo().defaultContent();
        WebElement text3 = driver.findElement(By.xpath("//div[@class='pattern-backgound playgound-header']"));
        System.out.println(text3.getText());






    }

    @Test
    public void etsySignInBox() {
        driver.navigate().to("http://www.etsy.com");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement signBox = driver.findElement(By.xpath("(//button[contains(text(),'Войти')])[1]"));
        signBox.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("join-neu-overlay-title")));

        WebElement inputNameField = driver.findElement(By.xpath("(//input[@id='join_neu_email_field'])[1]"));
        inputNameField.sendKeys("Kerimbaevazat@gmail.com");

        WebElement inputPsdField = driver.findElement(By.xpath("(//input[@id='join_neu_password_field'])[1]"));
        inputPsdField.sendKeys("5555");


    }
}
