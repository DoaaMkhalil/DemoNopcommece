package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.Pages.P01_HomePage;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class D08_Wishlist {
      P01_HomePage HP = new P01_HomePage();
      SoftAssert soft = new SoftAssert();
    @Given("user adds product to wishlist")
    public void openwishlist(){
        HP.addtowishlist();
    }

    @Then("product is added to wishlist successfully")
    public void productIsAddedToWishlistSuccessfully() {
      soft.assertTrue(HP.displayedsuccessmsg());
        String HEXcolor = Color.fromString(HP.colorofsuccessmsg()).asHex();
     soft.assertEquals(HEXcolor,"#4bb07a");
     soft.assertAll();
    }

    @And("open wishlist page")
    public void openWishlistPage() {
        HP.openwishlist();
    }

    @Then("wishlist contain product")
    public void wishlistContainProduct() {
    int QTY = Integer.parseInt(HP.getQTY());
        Assert.assertTrue(QTY>0);
    }
}
