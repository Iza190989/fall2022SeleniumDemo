package org.example;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;


    public class AlerstDemo extends BasedTest {

        @Test
        public void testAlert1() {
            driver.get("https://demoqa.com/alerts");
            WebElement alertButton = driver.findElement(By.id("alertButton"));
            alertButton.click();

            Alert alert = driver.switchTo().alert();
            alert.accept();
            Helper.pause(3000);


        }

        @Test
        public void testExplicitWaitAndAlert() {
            driver.get("https://demoqa.com/alerts");
            WebElement alertButton = driver.findElement(By.id("timerAlertButton"));
            alertButton.click();

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            alert.accept();//prinyat alert


        }

        @Test
        public void testConfirmButton() {
            WebElement confirmButton = driver.findElement(By.xpath("//button[@id='timerAlertButton']"));
            confirmButton.click();
            Alert alert = driver.switchTo().alert();
            alert.dismiss();// otklonit alert
            WebElement confirmResultBox = driver.findElement(By.id("confirmResult"));
            Assert.assertEquals(confirmResultBox.getText(), "You selected Cancel");
        }

        @Test
        public void testPromptButton() {
            driver.get("https://demoqa.com/alerts");
            WebElement promptButton = driver.findElement(By.xpath("//button[@id='promtButton']"));
            promptButton.click();
            Alert alert = driver.switchTo().alert();
            alert.accept();
            alert.sendKeys("Meder");


        }
    }

