package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class SeleniumExceptions extends BasedTest {

    @Test
    public void demo1() {
        //NoSuchElementException
        browserHelper.openURL("https://demoqa.com/text-box");
        driver.findElement(By.id("userName1")).sendKeys("Hello world");//netu takogo elementa

    }

    @Test
    public void noSuchWindowException() {
        //NoSuchElementException
        browserHelper.openURL("https://demoqa.com/text-box");
        //  browserHelper.switchToWindow(5); //poluchim illegalArgumentEction
        driver.switchTo().window("Hello");//NoSuchWindowException
    }

    @Test
    public void noSuchFrameException() {
        //NoSuchFrameException
        browserHelper.openURL("https://demoqa.com/text-box");
        driver.switchTo().frame(123);
    }

    @Test
    public void noSuchAlertException() {
        //NoSuchAlertException
        browserHelper.openURL("https://demoqa.com/text-box");
        alertHelper.acceptAlert();

    }

    @Test
    public void invalidSelectorException() {
        //org.openqa.selenium.InvalidSelectorException
        browserHelper.openURL("https://demoqa.com/text-box");
        driver.findElement(By.cssSelector("//button[@type='button'][100]"));
    }

    @Test
    public void noSuchSessionException() {
        //noSuchSessionException
        driver.quit();
        browserHelper.openURL("https://demoqa.com/text-box");
    }

    @Test
    public void staleElementReferenceException() {
        //ustarevwaya ssylka na element
        browserHelper.openURL("https://www.amazon.com/");
        driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("Iphone", Keys.ENTER);
        List<WebElement> allBrands = driver.findElements(By.xpath("//div[@id='brandsRefinements']//ul/li/span/a"));
        int count = 0;
        for (WebElement e : allBrands) {
            count++;
            if (e.getText().contains("SAMSUNG")) {
                driver.findElement(By.xpath("(//div[@id='brandsRefinements']//ul/li/span/a/div/label/i)" + "[" + count + "]")).click();
               // break; ubrali iz za etogo exception
            }
        }
    }

    @Test
    public void timeOutException(){
        //TimeoutException
        browserHelper.openURL("https://www.demoqa.com/dynamic-properties");
        WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("enableAfter"))).click();
    }

    @Test
    public void elementNotIteractableException(){
        // disapled elementu hotim otpravit value
        browserHelper.openURL("https://demoqa.com/radio-button");
//        driver.findElement(By.id("noRadio")).sendKeys("saas");
        driver.findElement(By.id("noRadio")).click();

    }


    @Test
    public void elementClickInterceptedException(){
        browserHelper.openURL("https://www.imoving.com/");
        WebElement selectMenu = driver.findElement(By.id("houseTypeSelectList"));
        Select select = new Select(selectMenu);
        select.selectByVisibleText("My House");
        Select select1 = new Select(driver.findElement(By.id("hp-nav-select-house")));
        select1.selectByVisibleText("Just a few Items");
        driver.findElement(By.xpath("//button[text()='Compare Quotes']")).click();
        Helper.pause(3000);
        driver.findElement(By.xpath("//a[@class='btn btn-blue col-xs-6']")).click();
//        Helper.pause(3000);
//        driver.findElement(By.xpath("//a[text()='GOT IT']")).click();
        Helper.pause(3000);
        driver.findElement(By.xpath(".//a[@id='closeTutorial']")).click();
        Helper.pause(3000);
    }



}
