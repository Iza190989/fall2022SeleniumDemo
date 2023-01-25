package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class JsSendkey extends BasedTest {

    @Test
    public void test1(){
        browserHelper.openURL("https://www.google.ru/");
        WebElement searchBox =driver.findElement(By.name("q"));
       Helper.sendKeysOnWebElement(driver,searchBox,"Izat");
    }
}
