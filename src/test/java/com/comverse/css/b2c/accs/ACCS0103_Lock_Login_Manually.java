package com.comverse.css.b2c.accs;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.b2c.*;
import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.data.apps.B2C;

public class ACCS0103_Lock_Login_Manually extends CSSTest {
    private StringBuffer verificationErrors = new StringBuffer();

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new B2C();
    }

    @Test
    public void testACCS0103_Lock_Login_Manually() throws Exception {

        try {
            launchCSSApplication();
            String login = Common.getB2CLoginName();
            String password = Common.getB2CPassword();
            String lastName = Common.getBCTLastName();

            HomePage homePage = new HomePage(tool, test, user);
            homePage.enterUsername(login);
            homePage.enterPassword(password);
            SubscriberDetail subscriberDetail = homePage.clickLogIn();

            Common.assertTextOnPage(tool, "Welcome");

            subscriberDetail.clickLogout();
            homePage.clickHomePage();

            WorkSpace workSpace = homePage.loginAsTelcoAdmin(application);

            SearchCustomer searchCustomer = workSpace.clickSearchCustomer();
            searchCustomer.enterLastName(lastName);
            searchCustomer.clickSearchLastFirstName();
            ContactInformation contactInformation = searchCustomer.clickOnCustomerNameLink(lastName);

            SearchMember searchMember = contactInformation.clickFamilyMemeber();

            LoginInformation loginInformation = searchMember.clickManageLogin();

            LockLogin lockLogin = loginInformation.clickLockLogin();
            // Not sure what is supported to happen here as its blocked by a bug
            lockLogin.clickConfirm();
            homePage = lockLogin.clickLogout();
            homePage.clickHomePage();

            homePage.enterUsername(login);
            homePage.enterPassword(password);
            homePage.clickLogInExpectingFail();
            Common.assertTextOnPage(tool, "Your login has been locked");

            test.setResult("pass");

        } catch (AlreadyRunException e) {
        } catch (Exception e) {
            verificationErrors.append(e.getMessage());
            throw e;
        }

    }

    @Override
    @After
    public void tearDown() throws Exception {
        super.tearDown();
    }
}
