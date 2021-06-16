package tests;

import base.BaseClass;
import org.testng.annotations.Test;
import pages.LoginPage;

public class Test01 extends BaseClass {
//groups - to categorize/grouping our test cases
    //priority - which test case should be given priority. It starts from 0. default is 0
    @Test(groups={"smoke"},priority = 1)
    public void verifyMyLeave() throws InterruptedException {
        new LoginPage()
                .enterUsername("Admin")
                .enterPassword("admin123")
                .submitBtnClick()
                .verifyTitle()
                .clickOnMyLeave()
                .verifyTitle();
        System.out.println("VerifyMyLeave");
    }

    @Test(groups={"smoke","negativecase"})
    public void verifyMyLeaveInvalid() throws InterruptedException {
        new LoginPage()
                .enterUsername("Admin")
                .enterPassword("admin123")
                .submitBtnClick()
                .verifyTitle()
                .clickOnMyLeave()
                .verifyTitle();
        System.out.println("VerifyMyLeaveInvalid");
    }
}
