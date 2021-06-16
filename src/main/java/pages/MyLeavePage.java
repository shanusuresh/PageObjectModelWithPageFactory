package pages;

import base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class MyLeavePage extends BaseClass {

    public MyLeavePage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//li[@class='selected']/a")
    WebElement tabNameEle;

    public MyLeavePage verifyTitle(){
        String tabText = tabNameEle.getText();
        Assert.assertEquals(tabText,"My Leave","Doesn't match");
        return this;
    }
}
