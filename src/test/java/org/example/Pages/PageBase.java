package org.example.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.example.stepDefs.Hooks.driver;

public class PageBase {


    public PageBase()
    {

        PageFactory.initElements(driver,this);
    }
    void sendKey(WebElement ELE  , String key)
    {
        ELE.sendKeys(key);
    }
    void select(WebElement ELE , int random)
    {
        Select no = new Select(ELE);
        no.selectByIndex(random);
    }
    void select(WebElement ELE , String text)
    {
        Select no = new Select(ELE);
        no.selectByVisibleText(text);
    }

     String getText(WebElement ELE)
    {
        return   ELE.getText();
    }
    String getvalue(WebElement ELE, String attributename)
    {
        return   ELE.getAttribute(attributename);
    }
     String getColor(WebElement ELE , String property)
    {
        return   ELE.getCssValue(property);
    }
    boolean isdiplayed(WebElement ELE)
    {
      return   ELE.isDisplayed();
    }
   public String getURL( )
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe("https://demo.nopcommerce.com/")));
        return   driver.getCurrentUrl();
    }

     void hover(List<WebElement>ELE ) throws InterruptedException {
         Actions action = new Actions(driver);
       for (int i=0 ;i< ELE.size();i++){
           action.moveToElement(ELE.get(i)).perform();
        //   Thread.sleep(3000);
       }

     }

    public void navigateto2widow(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        ArrayList<String> tabs= new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
    }
    public void close() {
        driver.close();
    }
}
