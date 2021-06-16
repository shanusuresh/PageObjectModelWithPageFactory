package pages;

import base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterMethod;

public class DashboardPage extends BaseClass {

    public DashboardPage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//div[@id='dashboard-quick-launch-panel-container']//span[text()='My Leave']")
    WebElement myleaveLinkEle;

    @FindBy(id="welcome")
    WebElement welcomeEle;

    @FindBy(linkText = "Logout")
    WebElement logoutLinkEle;

    public DashboardPage verifyTitle(){
        System.out.println(driver.getTitle());
        System.out.println("Verified title");
        return this;
    }

    public MyLeavePage clickOnMyLeave() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("Clicking on my leave");
        wait.until(ExpectedConditions.visibilityOf(myleaveLinkEle));
        myleaveLinkEle.click();
        return new MyLeavePage();
    }

    @AfterMethod(alwaysRun = true)
    public DashboardPage logOut(){
        System.out.println("Logging out");
        welcomeEle.click();
        logoutLinkEle.click();
        return this;
    }


}
