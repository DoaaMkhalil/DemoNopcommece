package org.example.stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.Pages.P01_HomePage;
import org.testng.Assert;

import java.util.List;

public class D03_Currencies {
    String arg0 ;
    P01_HomePage homePage = new P01_HomePage();
    @Given("user selects currency from the dropdown list on the top left of home page {string}")
    public void userSelectsCurrencyFromTheDropdownListOnTheTopLeftOfHomePage( String arg )

    {
        System.out.println("-------------------------------------------");
        System.out.println(arg);
        System.out.println("-------------------------------------------");
        homePage.selectcurrency(arg);
        arg0 =arg;
    }

    @Then("all product price appear with correct currency")
    public void ptoductcurrency()
    {
        List<String> cur = homePage.priceurrency();
        if(arg0.contains("Euro"))
        {
            for (int i=0 ; i<cur.size();i++)
            {
                System.out.println(cur.get(i));
                Assert.assertTrue(cur.get(i).contains("€"));
            }
        }
        else if(arg0.contains("US Dollar"))
        {
            for (int i=0 ; i<cur.size();i++)
            {
                System.out.println(cur.get(i));
                Assert.assertTrue(cur.get(i).contains("$"));
            }
        }

    }



}

