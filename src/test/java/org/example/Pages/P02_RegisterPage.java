package org.example.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.example.stepDefs.Hooks.driver;

public class P02_RegisterPage extends PageBase{

    @FindBy(className ="ico-register")
    WebElement regBut;
    @FindBy(id="gender-male")
    WebElement male;

    @FindBy(id="gender-female")
    WebElement female;
    @FindBy(id="FirstName")
     WebElement fn ;
    @FindBy(id="LastName")
     WebElement ln ;
    @FindBy(name="DateOfBirthDay")
     WebElement day;
    @FindBy(name="DateOfBirthMonth")
     WebElement month;
    @FindBy(name="DateOfBirthYear")
     WebElement year;
    @FindBy(id="Email")
     WebElement email;
    @FindBy(id="Password")
     WebElement Password;
    @FindBy(id="ConfirmPassword")
     WebElement ConfirmPassword;
    @FindBy(id="register-button")
     WebElement register;
    @FindBy( className ="result")
     WebElement msg;
    @FindBy( id="Email-error")
     WebElement errormsg;
    public void regButclick( )
    {
        regBut.click();
    }
    public void genderClick(String gen )
    {
        if (gen.contains("female") )
        female.click();
        else if (gen.contains("male") )
            male.click();
    }
    public void Fname(String key )
    {
        sendKey(fn,key);
    }
    public void Lname(String key )
    {
        sendKey(ln,key);
    }
    public void selectDay(int key )
    {
       select(day,key);
    }
    public void selectmon(int key )
    {
        select(month,key);
    }
    public void selectyear(int key )
    {
        select(year,key);
    }
    public void Email(String key )
    {
        sendKey(email,key);
    }
    public void pass(String key )
    {
        sendKey(Password,key);
    }
    public void conpass(String key )
    {
        sendKey(ConfirmPassword,key);
    }
    public void register()
    {
        register.click();
    }
    public String succmsg()
    {
      return  getText(msg);
    }
    public String colormsg()
    {
        return    getColor(msg,"color");
    }
    public String error()
    {
        return  getText(errormsg);
    }
    public String errorcolor()
    {
        return    getColor(errormsg,"color");
    }

}
