
package practice;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.AssertJUnit.assertEquals;


public class UserRegistrationTest {
    User user =new User();
    WebDriver driver = new ChromeDriver();

    String expectedName = "Izat";
    String expectedEmail = "Kerimbaev@gmail.com";
    String expectedAddress = "Bishkek 312 ";
    String expectedPerAdd = "Kyrgyzstan";

    String fakeName ;
    String fakeEmail ;
    String fakeAddress;
    String fakePerAddress ;

    @BeforeTest
    public void generateData(){
        Faker fakeData = new Faker();
        user.setFakeName(fakeData.name().firstName());
        user.setFakeEmail(fakeData.internet().emailAddress());
        user.setFakeAddress(fakeData.address().city());
        user.setFakePerAdd(fakeData.address().country());

        WebDriverManager.chromedriver().setup();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://demoqa.com/text-box");

        WebElement fullNameInputField = driver.findElement(By.id("userName"));
        fullNameInputField.sendKeys(user.getFakeName());

        WebElement userEmail = driver.findElement(By.id("userEmail"));
        userEmail.sendKeys(user.getFakeEmail());

        WebElement currentAddress = driver.findElement(By.id("currentAddress"));
        currentAddress.sendKeys(user.getFakeAddress());

        WebElement permanentAddress = driver.findElement(By.id("permanentAddress"));
        permanentAddress.sendKeys(user.getFakePerAdd());

        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

    }
    @AfterTest
    public void tearDown(){
        driver.quit();
    }



    @Test (description = "check the name",priority = 1)
    public void checkName(){
        String actualName = driver.findElement(By.id("name")).getText();
        assertEquals(expectedName,actualName);
    }

    @Test (description = "check the email",priority = 2)
    public void checkEmail(){
        String actualEmail = driver.findElement(By.id("email")).getText();
        assertEquals(expectedEmail,actualEmail);
    }

    @Test (description = "check the address",priority = 3)
    public void checkAddress(){
        String actualAddress= driver.findElement(By.id("currentAddress")).getText();
        assertEquals(expectedAddress,actualAddress);
    }

    @Test (description = "check the permanent address",priority = 4)
    public void checkPerAddress(){
        String actualPerAdd= driver.findElement(By.xpath("//p[@id='permanentAddress']")).getText();
        assertEquals(expectedPerAdd,actualPerAdd);
    }
}





