package org.example;

import org.testng.annotations.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class ActionsDemo extends BasedTest {


    @Test
    public void testRadioButton() {
        driver.get("https://demoqa.com/radio-button");
        WebElement yesRadio = driver.findElement(By.xpath(".//label[@for='yesRadio']"));
        yesRadio.click();
        Assert.assertTrue(yesRadio.isEnabled());
    }

    @Test
    public void testRightClick() {
        driver.get("https://demoqa.com/buttons");
        WebElement rightClickButton = driver.findElement(By.id("doubleClickBtn"));
        Actions actions = new Actions(driver);
        Helper.pause(3000);
        actions.doubleClick(rightClickButton).perform();
        Assert.assertEquals(driver.findElement(By.id("doubleClickMessage")).getText(), "You have done a double click");
        Assert.assertTrue(driver.findElement(By.id("doubleClickMessage")).getText().contains("You have done a double click"));
    }
}

