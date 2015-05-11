package com.company.mercurytours;

import com.company.mercurytours.app.MercuryTours;
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
    public void testCHK001_RegisterUser() throws Exception {

        try {

            launchApplication();

            WelcomeMercuryTours WelcomePage = new WelcomeMercuryTours(tool, test, user);
            RegisterMercuryTours RegisterPage = WelcomePage.clickRegisterLink();

            RegisterPage.enterFirstName(user.getFirstName());
            RegisterPage.enterLastName(user.getLastName());

            RegisterPage.enterUserName(user.getLogin());
            RegisterPage.enterPassword(user.getPassword());
            RegisterPage.enterConfirmPassword(user.getPassword());
            RegisterPage.clickSubmit();

            Common.assertTextOnPage(tool, "Dear " + user.getFirstName() + " " + user.getLastName());
            Common.assertTextOnPage(tool, "Note: Your user name is " + user.getLogin());

            SignOnMercuryTours SignOn = RegisterPage.clickSignIn();

            SignOn.enterUserName(user.getLogin());
            SignOn.enterPassword(user.getPassword());
            FindAFlightMercuryTours FindAFlight = SignOn.clickSubmit();

            SignOn = FindAFlight.clickSignOffLink();

//            Only uncomment if you have the MySQL DB reporting installed and activated in the init.properties file
//            Common.storeLoginDetailsAndLastName(user.getLastName(), user.getLogin(), user.getPassword(), "Login details stored for later");
            // Following will create and update a property file at the root of the project.
            // File will be called "<ENV>_test.properties"
            Common.storePropertyInIniFile("user_login", user.getLogin(), "Created by test CHK001_RegisterUser");
            Common.storePropertyInIniFile("user_password", user.getPassword(), "Created by test CHK001_RegisterUser");

            System.out.println("User password - " + Common.getPropertyFromIniFile("user_password"));

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
