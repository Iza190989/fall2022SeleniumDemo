package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class CssDemo extends BasedTest {

    @Test
    public void CssTest1()  {
        driver.get("https://www.amazon.com/");
        //  WebElement searchInput = driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("Iphone");
        //
        driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("Iphone", Keys.ENTER);
        WebElement appleText = driver.findElement(By.cssSelector("li[id='p_89/Apple']"));
        System.out.println(appleText.getText());





        List<WebElement> allBrands = driver.findElements(By.xpath("//div[@id='brandsRefinements']/child::ul/descendant::a"));
        driver.findElement(By.cssSelector("a[aria-label='See more, Brands'] span[class='a-expander-prompt']")).click();

        clickMatchingElement(allBrands,"Nokia");


    }
    private void clickMatchingElement(List<WebElement>allBrands,String suiteBrand){
        for (WebElement e : allBrands) {
            String element = e.getText();
            if (element.equalsIgnoreCase(suiteBrand)) {
                e.click();
                break;

            }
        }

    }

}

