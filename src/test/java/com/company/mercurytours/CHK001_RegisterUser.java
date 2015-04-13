package com.company.mercurytours;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.framework.common.AlreadyRunException;
import com.framework.app.common.AppTest;
import com.framework.app.common.Common;
import com.framework.app.common.Prep;
import com.company.mercurytours.users.JoeBloggs;

import com.company.mercurytours.pages.*;

public class CHK001_RegisterUser extends AppTest {

    private StringBuffer verificationErrors = new StringBuffer();

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new MercuryTours();
        user = new JoeBloggs();
    }

    @Test
    public void testACCS0000_CreateExistingAccount() throws Exception {

        try {

            launchApplication();

            String uniqueTimeStamp = Common.generateTimeStamp();

            WelcomeMercuryTours WelcomePage = new WelcomeMercuryTours(tool, test, user);
            RegisterMercuryTours RegisterPage = WelcomePage.clickRegisterLink();

            RegisterPage.enterUserName(user.getLogin());
            RegisterPage.enterPassword(user.getPassword());
            RegisterPage.enterConfirmPassword(user.getPassword());
            RegisterPage.clickSubmit();
            

            Common.storeB2CLoginDetailsAndLastName("LN" + uniqueTimeStamp, uniqueTimeStamp, "0123456", "ACCS0000_CreateExistingAccount");

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
