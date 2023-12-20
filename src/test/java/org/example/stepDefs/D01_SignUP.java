package org.example.stepDefs;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.P01_HomePage;
import org.example.Pages.P02_RegisterPage;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class D01_SignUP {
    Configuration con = new Configuration();
    P02_RegisterPage RP = new P02_RegisterPage();
    Faker fake = new Faker();
    SoftAssert ass = new SoftAssert();
    @Given("guest user opens register page")
    public void openRegisterPage(){
       RP.regButclick();
    }

    @When("user selects the gender {string}")
    public void userSelectsTheGender(String gender) {
         RP.genderClick(gender);
    }

    @And("enters firstrname & lastname")
    public void entersUsername() {

       RP.Fname(fake.name().firstName());
       RP.Lname(fake.name().lastName());

    }

    @And("chooses DOB")
    public void choosesDOB() {
        int random_day = (int)Math.floor(Math.random() * (30 - 1 + 1) + 1);
        int random_month = (int)Math.floor(Math.random() * (12 - 1 + 1) + 1);
        int random_year = (int)Math.floor(Math.random() * (20 - 1 + 1) + 1);
        RP.selectDay(random_day);
        RP.selectmon(random_month);
        RP.selectyear(random_year);

    }

    @And("enter a valid Email")
    public void enterValidEmail() throws IOException {
       String Email= fake.internet().emailAddress();

      con.set("Email",Email);
       RP.Email(Email);
    }



    @And("enters pass & confirmation pass")
    public void entersPassConfirmationPass() throws IOException {
        String passs = fake.internet().password();
        con.set("Password",passs);
        RP.pass(passs);
        RP.conpass(passs);
    }

    @And("press on register")
    public void pressOnRegister() {
    RP.register();
    }

    @Then("new account is created successfully")
    public void newAccountIsCreatedSuccessfully() {

        ass.assertEquals(RP.succmsg(),"Your registration completed");
        ass.assertEquals(RP.colormsg(),"rgba(76, 177, 124, 1)");
        ass.assertAll();
    }


    @And("enter a invalid Email {string}")
    public void enterAInvalidEmail(String arg0) {
        RP.Email(arg0);
    }

    @Then("error msg is displayed")
    public void errorMsgIsDisplayed() {
        ass.assertEquals(RP.error(),"Wrong email");
        String hex =  Color.fromString(RP.errorcolor()).asHex();
        ass.assertEquals(hex,"#e4434b");
        ass.assertAll();

    }
}
