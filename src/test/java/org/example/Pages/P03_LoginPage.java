package org.example.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class P03_LoginPage extends PageBase{
    @FindBy(className = "ico-login")
    WebElement LoginTab;
    @FindBy(className ="email" )
     WebElement Email;
    @FindBy(className ="password" )
     WebElement password;
    @FindBy(css ="button[ class=\"button-1 login-button\"]" )
    WebElement LoginBut;

    @FindBy(className ="ico-account" )
    WebElement myAcc;
    @FindBy(className ="message-error" )
    WebElement errormsg;

    public void OpenLoginTab() {
        LoginTab.click();
    }
    public void enterEmail(String key )
    {
        int x ;
        sendKey(Email,key);

    }
    public void enterPass(String key )
    {
        sendKey(password,key);
    }
    public void clickOnLogin(){
        LoginBut.click();
    }

    public Boolean Myaccuont(){
        return isdiplayed(myAcc);
    }
    public String error(){
        return getText(errormsg);
    }
    public String colorerror(){
        return getColor(errormsg,"color");

    }
}
