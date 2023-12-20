package org.example.Pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.example.stepDefs.Hooks.driver;

public class P01_HomePage extends PageBase {



    @FindBy(id="customerCurrency")
    WebElement currency;
    @FindBy(className = "price")
    List<WebElement> price;
    @FindBy(className = "product-title")
    List<WebElement> product;

    @FindBy(css = "div[class=\"picture\"]")
    List<WebElement> productpic;
    @FindBy(className = "search-box-button")
    WebElement searchbtn;

    @FindBy(id = "small-searchterms")
    WebElement search;
    @FindBy(className = "sku")
    WebElement SKU;
    ///////////////////////////////////////////////
  @FindBy(xpath = "(//div[@class=\"header-menu\"]/ul)[1]/li")
   List<WebElement> parentcat;

 @FindBy(xpath = "(//div[@class=\"header-menu\"]/ul)[1]/li[1]/ul/li/a")
   List<WebElement> subcat;

   @FindBy(xpath = "(//div[@id=\"nivo-slider\"]/a)[2]")
   WebElement glaxyslider;
  @FindBy(xpath = "//div[@id=\"nivo-slider\"]/a")
  WebElement iphoneslider;
    @FindBy(xpath = "//a[text() =\"Facebook\"]")
    WebElement Facebook;
    @FindBy(xpath = "//a[text() =\"Twitter\"]")
    WebElement Twitter;
    @FindBy(xpath = "//a[text() =\"RSS\"]")
    WebElement RSS;
    @FindBy(xpath = "//a[text() =\"YouTube\"]")
    WebElement YouTube;

    @FindBy(xpath = "(//button[@title=\"Add to wishlist\"])[3]")
    WebElement wishlistBTN;

    @FindBy(css = "div[class=\"bar-notification success\"]")
    WebElement success;
    @FindBy(css = "div[class=\"page-title\"] h1")
    WebElement pagetiltle;

    @FindBy(className = "wishlist-label")
    WebElement wishlist;
    @FindBy(className = "qty-input")
    WebElement wishlistqty;

    public void selectcurrency(String text) {

        select(currency, text);
    }

    public List<String> priceurrency() {
        List<String> productPrice = new ArrayList<String>();
        for (int i = 0; i < price.size(); i++) {
            productPrice.add(i, getText(price.get(i)));
        }
        return productPrice;
    }

    public void search(String text) {
        sendKey(search, text);
    }

    public void searchbtn() {
        searchbtn.click();
    }

    public List<String> productname() {
        List<String> productname = new ArrayList<String>();
        for (int i = 0; i < product.size(); i++) {
            productname.add(i, getText(product.get(i)));
        }
        return productname;
    }
    public boolean displayedsuccessmsg()
    {
      return   isdiplayed(success);
    }
    public String colorofsuccessmsg()
    {
        String color = getColor(success ,"background-color");
        return   color;
    }


    public List<String> openproduct() {
        List<String> SKUNAME = new ArrayList<String>();
        for (int i = 0; i < productpic.size(); i++) {
            productpic.get(i).click();
            SKUNAME.add(i, getText(SKU));
            driver.navigate().back();
        }
        return SKUNAME;
    }

    ////////////////////////////////////////////////////////////
   public void hovercat() throws InterruptedException {
      hover(parentcat);
    }

    public String selectrandamsubcategory() {
        int random = (int) Math.floor(Math.random() * ((subcat.size() -1)- 0 + 1) + 0);
        Actions actions = new Actions(driver);
        actions.moveToElement(parentcat.get(0)).perform();
        String text = getText(subcat.get(random));
        subcat.get(random).click();
        System.out.println(text);
        return  text;
    }
    public String gettitle() {

        return  getText(pagetiltle);
    }
    ///////////////////////////////////////////////////

    public void opensiphone() {

            iphoneslider.click();

    }
    public void opengalaxy() {

            glaxyslider.click();
        }

        public void openWindow(String window){
        if (window.contains("book"))
            Facebook.click();
            else if (window.contains("itter"))
                Twitter.click();
        else if (window.contains("YouTube"))
            YouTube.click();
        else if (window.contains("RSS"))
            RSS.click();
        }
    public void addtowishlist()
    {
        wishlistBTN.click();
    }
    public void openwishlist(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        wait.until(ExpectedConditions.invisibilityOf(success));
        wishlist.click();
    }
    public String getQTY(){
      return   wishlistqty.getAttribute("value");
    }

}
