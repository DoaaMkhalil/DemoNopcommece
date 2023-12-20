package org.example.stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.Pages.P01_HomePage;
import org.testng.asserts.SoftAssert;

public class D06_homeSliders {
    P01_HomePage HP = new P01_HomePage();
   SoftAssert soft = new SoftAssert();
    @Given("user click on the slider {string}")
    public void userClickOnTheSlider(String arg0) {
      System.out.println(arg0);
        arg =arg0;
        if (arg0.contains("galxy"))
          HP.opengalaxy();
        else if (arg0.contains("iphone"))
        {   HP.opensiphone();}
    }

    @Then("corresponding page is open")
    public void correspondingPageIsOpen()
    {
        if (arg.contains("glaxy"))
        { soft.assertEquals(HP.getURL(),"https://demo.nopcommerce.com/galaxy-6");
        }
        else if (arg.contains("iphone"))
        { soft.assertEquals(HP.getURL(),"https://demo.nopcommerce.com/iphone-6");

        }

        soft.assertAll();
    }

       String arg ;




}
