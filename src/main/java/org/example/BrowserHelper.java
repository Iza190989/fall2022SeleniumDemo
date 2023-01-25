package org.example;

import org.openqa.selenium.WebDriver;

import java.net.URL;
import java.util.LinkedList;
import java.util.Set;

public class BrowserHelper {

    private WebDriver driver;

    public BrowserHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void openURL(String URL){
        driver.navigate().to(URL);

    }

    public void goBack(){
        driver.navigate().back();
    }

    public void goForward(){
        driver.navigate().forward();
    }

    public Set<String> getWindowHandles(){
        return driver.getWindowHandles();
    }
    public void switchToWindow(int index){
        LinkedList<String> windowId =new LinkedList<String>(getWindowHandles());
        if(index <0 || index >windowId.size()){
            throw  new IllegalArgumentException("Invalid index : " + index);
        }
        driver.switchTo().window(windowId.get(index));
    }

    public void switchToParent(){
        LinkedList<String> windowId =new LinkedList<String>(getWindowHandles());
        driver.switchTo().window(windowId.get(0));
    }
}
