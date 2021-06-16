package tests;

import base.BaseClass;
import org.testng.annotations.Test;
import pages.LoginPage;

public class Test02 extends BaseClass {

    @Test(groups = {"smoke"},priority = 1)
    public void verifyMyLeaveInvalid01() throws InterruptedException {
        new LoginPage()
                .enterUsername("Admin")
                .enterPassword("admin123")
                .submitBtnClick()
                .verifyTitle()
                .clickOnMyLeave()
                .verifyTitle();
        System.out.println("VerifyMyLeaveInvalid01");
    }
    @Test(groups={"functional","smoke","negativecase"},priority = 0)
    public void verifyMyLeave01() throws InterruptedException {
        new LoginPage()
                .enterUsername("Admin")
                .enterPassword("admin123")
                .submitBtnClick()
                .verifyTitle()
                .clickOnMyLeave()
                .verifyTitle();
        System.out.println("VerifyMyLeave01");
    }


}
