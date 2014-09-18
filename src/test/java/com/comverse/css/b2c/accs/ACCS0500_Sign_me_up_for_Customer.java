package com.comverse.css.b2c.accs;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.b2c.HomePage;
import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.data.apps.B2C;

public class ACCS0500_Sign_me_up_for_Customer extends CSSTest {
    private StringBuffer verificationErrors = new StringBuffer();

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new B2C();
    }

    @Test
    public void testACCS0500_Sign_me_up_for_Customer() throws Exception {

        try {
            launchCSSApplication();
            String accountNumber = Common.getAccountNumberOfUnregisteredAccountForSignMeUp();
            String lastName = Common.getLastNameOfUnregisteredAccountForSignMeUp(accountNumber);

            HomePage homePage = new HomePage(tool, test, user);
            homePage.clickActivateAccount();
            Common.assertVerifyTrue(tool, homePage.getActivateAccountMessage().matches("^[\\s\\S]*Enter your customer number and your last name or your company name"));
            homePage.enterLastName(lastName);
            homePage.enterAccountNumber(accountNumber);
            homePage.clickContinueActivateAccount();
            // Common.assertVerifyTrue(tool, homePage.getMessageFromTheSignMeUpPage().matches("^[\\s\\S]*To finish the Sign Up process, you need to fill a few information."));
            homePage.enterLogin("b2c_" + accountNumber);
            homePage.enterPassword("Passw0rd!");
            homePage.enterConfirmPassword("Passw0rd!");
            homePage.enterSecretAnswer("Passw0rd!");
            homePage.clickSignMeUp();
            Common.assertVerifyTrue(tool, homePage.getSuccesfulSignMeUpMessage().matches("^[\\s\\S]*The \"Sign Me Up\" has been submitted successfully."));

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
