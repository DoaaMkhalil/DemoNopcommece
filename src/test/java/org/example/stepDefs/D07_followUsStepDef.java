package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.P01_HomePage;
import org.testng.Assert;

public class D07_followUsStepDef {
    P01_HomePage HP =new P01_HomePage();
    String window ;
    @Given("user click on {string} icon")
    public void userClickOnIcon(String WINDOW) {
       HP.openWindow(WINDOW);
       window =WINDOW;
    }

    @When("user navigate to second tab")
    public void userNavigateToSecondTab() {
        HP.navigateto2widow();

    }
    @Then("correct contactUS page is opend {string}")
    public void correctContactUSPageIsOpend(String arg0) {

            Assert.assertEquals(arg0,HP.getURL());
    }
    @And("user close the second window")
    public void close()
    {
        HP.close();
    }



}
