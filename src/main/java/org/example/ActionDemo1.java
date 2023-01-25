package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionDemo1 extends BasedTest {
    @Test
    public void testDoubleClick() {
        browserHelper.openURL("https://demoqa.com/buttons");
        WebElement doubleClickBtn = driver.findElement(By.xpath("//button[@id='doubleClickBtn']"));

        Actions action = new Actions(driver);
        action.doubleClick(doubleClickBtn).build().perform();


    }
}