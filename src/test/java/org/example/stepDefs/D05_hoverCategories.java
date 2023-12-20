package org.example.stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.P01_HomePage;
import org.testng.Assert;

public class D05_hoverCategories {
    P01_HomePage HP = new P01_HomePage();
    String text;
    @Given("user hovers on category name")
    public void hover() throws InterruptedException {
               HP.hovercat();
    }

    @When("he select subcategory")
    public void heSelectSubcategory() {
    text= HP.selectrandamsubcategory();
        System.out.println(text);
    }

    @Then("page name the same of subcategory")
    public void pageNameTheSameOfSubcategory() {
        System.out.println("-------------------------------");
    String pagetitle = HP.gettitle();
        System.out.println(pagetitle);
        Assert.assertTrue(pagetitle.contains(text));
    }
}
