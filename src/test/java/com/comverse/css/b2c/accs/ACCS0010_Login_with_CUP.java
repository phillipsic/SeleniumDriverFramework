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

public class ACCS0010_Login_with_CUP extends CSSTest {
    private StringBuffer verificationErrors = new StringBuffer();

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new B2C();
    }

    @Test
    public void testACCS0010_Login_with_CUP() throws Exception {

        try {
            launchCSSApplication();

            String login = Common.getNonOrderingCUPB2CLogin();
            String password = Common.getNonOrderingCUPB2CPassword(login);

            HomePage homePage = new HomePage(driver);
            homePage.enterUsername(login);
            homePage.enterPassword(password);
            homePage.clickLogInExpectingChangePassword();
            homePage.enterOldPassword(password);
            homePage.enterNewPassword("Pa$$w0rd");
            homePage.enterNewConfirmPassword("Pa$$w0rd");
            homePage.enterChangePasswordSecretAnswer("Pa$$w0rd");
            homePage.clickChange();

            Common.assertTextOnPage(driver, "Welcome");

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
