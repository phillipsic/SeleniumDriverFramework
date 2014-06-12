package com.comverse.css.b2c.accs;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.b2c.HomePage;
import com.comverse.css.b2c.SubscriberDetail;
import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.data.apps.B2C;

public class ACCS0100_Lock_Login_after_login_failed extends CSSTest {
    private StringBuffer verificationErrors = new StringBuffer();

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new B2C();
    }

    @Test
    public void testACCS0100_Lock_Login_after_login_failed() throws Exception {

        try {
            launchCSSApplication();
            String login = Common.getB2CLoginName();
            String password = Common.getB2CPassword();

            HomePage homePage = new HomePage(tool, test, user);
            homePage.enterUsername(login);
            homePage.enterPassword(password);
            SubscriberDetail subscriberDetail = homePage.clickLogIn();
            Common.assertTextOnPage(tool, "Welcome");
            homePage = subscriberDetail.clickLogout();
            homePage.clickHomePage();

            for (int i = 1; i < 5; i++) {

                System.out.println("Login attempt :" + Integer.toString(i));
                homePage.enterUsername(login);
                homePage.enterPassword("wrong");
                homePage.clickLogInExpectingFail();

                Common.assertTextOnPage(tool, "Warning: after 5 attempts your account will be locked.");

            }

            homePage.enterUsername(login);
            homePage.enterPassword("wrong");
            homePage.clickLogInExpectingFail();

            assertTrue(homePage.getLogoffMessage().matches("Your login has been locked"));

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
