package com.company.mercurytours;

import com.company.mercurytours.app.Google;
import com.company.mercurytours.app.MercuryTours;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.framework.common.AlreadyRunException;
import com.framework.common.AppTest;
import com.framework.common.Common;
import com.framework.common.Prep;
import com.company.mercurytours.users.JoeBloggs;

import com.company.mercurytours.pages.*;
import com.framework.common.Application;

public class CHK002_LaunchSecondApplication extends AppTest {

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
    public void testCHK001_RegisterUser() throws Exception {

        try {

            launchMainApplication();

            WelcomeMercuryTours WelcomePage = new WelcomeMercuryTours(tool, test, user);
            RegisterMercuryTours RegisterPage = WelcomePage.clickRegisterLink();

            RegisterPage.enterFirstName(user.getFirstName());
            RegisterPage.enterLastName(user.getLastName());

            RegisterPage.enterUserName(user.getLogin());
            RegisterPage.enterPassword(user.getPassword());
            RegisterPage.enterConfirmPassword(user.getPassword());
            RegisterPage.clickSubmit();

            test.assertTextOnPage(tool, "Dear " + user.getFirstName() + " " + user.getLastName());
            test.assertTextOnPage(tool, "Note: Your user name is " + user.getLogin());

            Application googleApplication = new Google();
            launchAnotherApplication(googleApplication);
            test.assertCorrectPageTitle(tool, "Google");

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
