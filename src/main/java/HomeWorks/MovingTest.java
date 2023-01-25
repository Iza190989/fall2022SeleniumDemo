package HomeWorks;

import org.example.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class MovingTest extends BaseDemo1 {


    @Test
    public void testMovingHouse() {
        driver.get("https://www.imoving.com/full-inventory/#!/");
        WebElement houseMenu = driver.findElement(By.id("houseTypeSelectList"));
        Select select = new Select(houseMenu);
        select.selectByVisibleText("My Apartment");
        Helper.pause(3000);

        WebElement moveSizeMenu = driver.findElement(By.id("hp-nav-select-house"));
        Select select2 = new Select(moveSizeMenu);
        select2.selectByVisibleText("Just a few Items");
        Helper.pause(3000);

        WebElement clickQuotes = driver.findElement(By.xpath("//button[@class='btn btn-white quickQuoteLink']"));
        clickQuotes.click();
        Helper.pause(3000);

        WebElement continuesBox = driver.findElement(By.xpath("//span[@class='col-sm-9 col-xs-12']"));
        continuesBox.click();
        Helper.pause(3000);

        driver.findElement(By.xpath("//div[@class='modal-buttons']/a")).click();
        Helper.pause(3000);
        driver.findElement(By.id("closeTutorial")).click();

        Actions action = new Actions(driver);
        WebElement pictureDresser = driver.findElement(By.xpath("//div[@class='14']//figure"));
        action.moveToElement(pictureDresser).build().perform();
        driver.findElement(By.xpath("//div[@class='14']//a[@class='btn btn-blue'][normalize-space()='Add to Inventory']")).click();
        Helper.pause(3000);
        WebElement plusBoxDresser = driver.findElement(By.xpath("//span[@class='quantityCounterBlock']//button[@class='quantity-plus']"));

        action.doubleClick(plusBoxDresser).perform();
        Helper.pause(3000);


        WebElement bedImageContainer = driver.findElement(By.xpath("//div[@class='13']//figure"));
        action.moveToElement(bedImageContainer).build().perform();
        driver.findElement(By.xpath("//div[@class='13']//a[@class='btn btn-blue'][normalize-space()='Add to Inventory']")).click();
        Helper.pause(3000);
        WebElement plusBoxBed = driver.findElement(By.xpath("(//button[@class='quantity-plus'])[3]"));
        action.doubleClick(plusBoxBed).perform();

        WebElement tvImageContainer = driver.findElement(By.xpath("//div[@class='12']//figure"));
        action.moveToElement(tvImageContainer).build().perform();
        driver.findElement(By.cssSelector("div[class='12'] div[class='add-item-mob visible-xs-block visible-sm-block'] a[class='btn btn-blue']")).click();
        Helper.pause(3000);
        WebElement plusBoxTv = driver.findElement(By.xpath("(//button[@class='quantity-plus'])[5]"));
        action.doubleClick(plusBoxTv).perform();

        driver.findElement(By.xpath("//div[@class='rightPanelContainer']//div[@class='arrowOpenRightNavigation leftArrowNavi']")).click();



//            actions.moveToElement(picture);
//            actions.click();
//            actions.perform();
//
//            WebElement doubleClick2 = driver.findElement(By.cssSelector("div[class='13'] div[class='add-item-mob visible-xs-block visible-sm-block'] a[class='btn btn-blue']"));
//            doubleClick2.click();
//
//
//            driver.findElement(By.xpath("//div[@class='12']//a[@class='btn btn-blue'][normalize-space()='Add to Inventory']")).click();
//            driver.findElement(By.xpath("//span[@class='quantityCounterBlock']//button[@class='quantity-plus']")).click();


//        WebElement doubleClick3 = driver.findElement(By.xpath("//span[@class='quantityCounterBlock']//button[@class='quantity-plus']"));
//        actions.doubleClick(doubleClick3);
    }
}

