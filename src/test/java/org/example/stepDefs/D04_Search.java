package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.P01_HomePage;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class D04_Search {
    P01_HomePage HP = new P01_HomePage();
    SoftAssert soft = new SoftAssert();
    String arg ;
    @Given("user search {string}")
    public void userEnterSearch(String arg0) {
        arg = arg0;
        HP.search(arg0);

    }
    @When("press on search button")
    public void pressOnSearchButton() {
        HP.searchbtn();
    }
    @Then("correct products appears")
    public void product()
    {
        List<String> productname =HP.productname();
        soft.assertEquals(HP.getURL(),"https://demo.nopcommerce.com/search?q="+arg);
        for (int i=0 ; i<productname.size();i++)
        {
            System.out.println(productname.get(i));
            soft.assertTrue(productname.get(i).toLowerCase().contains(arg));
        }
        soft.assertAll();
    }




    @Then("product appears contain SKU")
    public void productAppearsContainSKU() {
        List<String> sku =  HP.openproduct();
        for (int i=0 ; i<sku.size();i++)
        {
            System.out.println(arg);
            System.out.println(sku.get(i));
            soft.assertTrue(sku.get(i).contains(arg));
        }
        soft.assertAll();
    }
}
