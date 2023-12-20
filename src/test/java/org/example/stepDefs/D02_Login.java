package org.example.stepDefs;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.P01_HomePage;
import org.example.Pages.P03_LoginPage;
import org.openqa.selenium.support.Color;
import org.testng.asserts.SoftAssert;

import java.awt.*;
import java.io.IOException;

import static org.example.stepDefs.Hooks.driver;

public class D02_Login {
    Configuration con = new Configuration();
    P03_LoginPage LP = new P03_LoginPage();
    SoftAssert ass = new SoftAssert();
    Faker fake = new Faker();
    @Given("User opens login page")
    public void openLogin()
    {
        LP.OpenLoginTab();
    }


    @When("User enters valid UserName")
    public void userEntersValidUserName() throws IOException {
        String Email = con.get("Email");
        LP.enterEmail(Email);

    }
    @When("User enters Valid Password")
    public void userEntersValidPassword() throws IOException {
        String PASS = con.get("Password");
        LP.enterPass(PASS);

    }

    @And("press on Login button")
    public void pressOnLoginButton() {
        LP.clickOnLogin();
    }

    @Then("user access his account successfully")
    public void userAccessHisAccountSuccessfully() {
    ass.assertTrue(LP.Myaccuont());
    ass.assertEquals(LP.getURL(),"https://demo.nopcommerce.com/");
    ass.assertAll();

    }

    @When("User enters invalid Email {string}")
    public void userEntersInvalidEmail(String arg0) {
        LP.enterEmail(arg0);
    }

    @And("User enters any password")
    public void userEntersPassword() {
        fake.internet().password();
    }

    @Then("user can not access the account")
    public void userCanNotAccessTheAccount() {
        ass.assertTrue(LP.error().contains("Login was unsuccessful."));
        String hex = Color.fromString(LP.colorerror()).asHex();
        ass.assertEquals(hex, "#e4434b");
         ass.assertAll();
    }
}
