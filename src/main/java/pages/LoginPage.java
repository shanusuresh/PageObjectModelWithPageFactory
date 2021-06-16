package pages;

import base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass {

    public LoginPage(){
        PageFactory.initElements(driver,this);
    }

    /**
     * Page element locators
     */
    @FindBy(id = "txtUsername")
    WebElement usernameEle;

    @FindBy(xpath = "//input[@id='txtPassword']")
    WebElement passwordEle;

    @FindBy(id="btnLogin")
    WebElement submitBtnEle;

    @FindBy(linkText = "Forgot your password?")
    WebElement forgotPasswordEle;


    /**
     * method used to perform operation on the locators
     * @return
     */

    public LoginPage enterUsername(String username){
        usernameEle.sendKeys(username);
        return this;
    }

    public LoginPage enterPassword(String password){
        passwordEle.sendKeys(password);
        return this;
    }

    public DashboardPage submitBtnClick(){
        submitBtnEle.click();
        return new DashboardPage();
    }

    public void clickForgotPassword(){
        forgotPasswordEle.click();
    }

}
