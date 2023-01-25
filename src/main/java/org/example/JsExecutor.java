package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class JsExecutor extends BasedTest{

    @Test
    public void test1(){
        browserHelper.openURL("https://www.etsy.com/");
        WebElement careersLink =driver.findElement(By.xpath("//a[@href='https://www.etsy.com/careers?ref=ftr']"));
        // Helper.jsClick(driver,careersLink);
        careersLink.click();
        Helper.pause(10000);
        Helper.jsScrollDown(driver,"350");
        Helper.pause(5000);


    }
    }

