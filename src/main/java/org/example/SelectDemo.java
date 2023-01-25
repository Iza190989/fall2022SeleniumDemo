package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class SelectDemo extends BasedTest{
    @Test
    public void testSelectDemo(){
        driver.navigate().to("https://demoqa.com/select-menu");
        WebElement inputFieldBox = driver.findElement(By.xpath("//input[@id='react-select-2-input']"));
        inputFieldBox.sendKeys("");
    }
}
