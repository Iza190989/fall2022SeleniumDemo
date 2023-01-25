package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class WebTables extends BasedTest {

    @Test
    public void addNewUser() {
        driver.navigate().to("https://demoqa.com/webtables");
        driver.findElement(By.xpath("(//button[normalize-space()='Add'])[1]")).click();

        WebElement inputNameField = driver.findElement(By.xpath("(//input[@id='firstName'])[1]"));
        inputNameField.sendKeys("Adilet");
        WebElement inputLastnameField = driver.findElement(By.xpath("(//input[@id='lastName'])[1]"));
        inputLastnameField.sendKeys("Toktorov");
        WebElement inputEmailField = driver.findElement(By.xpath("(//input[@id='userEmail'])[1]"));
        inputEmailField.sendKeys("Toktorov20@gmail.com");
        driver.findElement(By.xpath("//input[@id='age']")).sendKeys("31");
        driver.findElement(By.xpath("//input[@id='salary']")).sendKeys("3500");
        driver.findElement(By.xpath("//input[@id='department']")).sendKeys("Control");
        driver.findElement(By.xpath("//button[@id='submit']")).click();

        WebElement table = driver.findElement(By.xpath("//div[@class='rt-tbody']"));
        List<WebElement> rowElements = table.findElements(By.xpath("//div[@role='rowgroup']"));  //div[@role='rowgroup'] rows
        System.out.println(rowElements.size());


        //        List<WebElement> allRows = table.findElements(By.className("rt-tr-group"));
        // for(int i =0; i<=rowSize;i++)
        //   for (int j =0 ; j<=ColumnsSize;j++)

        for (WebElement row : rowElements) {
            List<WebElement> allData = row.findElements(By.className("rt-td"));
            for (WebElement column : allData) {
                if (column.getText().equals("Adilet")) {
                    System.out.println(column.getText());
                    Assert.assertEquals(column.getText(), "Adilet");

                }
            }
        }
    }
}
