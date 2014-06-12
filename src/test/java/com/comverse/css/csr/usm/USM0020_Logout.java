package com.comverse.css.csr.usm;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.css.csr.WorkSpace;
import com.comverse.data.apps.CSR;
import com.comverse.data.users.BOGAdmin;
import com.comverse.data.users.CSRAdmin;
import com.comverse.data.users.CSRUser;
import com.comverse.data.users.TelcoAdmin;

public class USM0020_Logout extends CSSTest {
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    @Override
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new CSR();
        user = new CSRAdmin();
    }

    @Test
    public void testUSM0020_Logout() throws Exception {
        try {
            String logOutMessage = "You have successfully logged out of the Central Authentication Service.";

            launchCSSApplicationAndSSOLogin();
            Common.assertTextOnPage(tool, "Welcome to Your Workspace");
            WorkSpace workSpace = new WorkSpace(tool, test, user);
            workSpace.clickLogoutExpectingSSO();
            Common.assertTextOnPage(tool, "Logout successful");
            Common.assertTextOnPage(tool, logOutMessage);

            user = new CSRUser();
            launchCSSApplicationAndSSOLogin();
            Common.assertTextOnPage(tool, "Welcome to Your Workspace");
            workSpace.clickLogoutExpectingSSO();
            Common.assertTextOnPage(tool, "Logout successful");
            Common.assertTextOnPage(tool, logOutMessage);

            user = new BOGAdmin();
            launchCSSApplicationAndSSOLogin();
            Common.assertTextOnPage(tool, "Welcome to Your Workspace");
            workSpace.clickLogoutExpectingSSO();
            Common.assertTextOnPage(tool, "Logout successful");
            Common.assertTextOnPage(tool, logOutMessage);

            user = new TelcoAdmin();
            launchCSSApplicationAndSSOLogin();
            Common.assertTextOnPage(tool, "Welcome to Your Workspace");
            Common.assertTextOnPage(tool, "Manage your account 24 hours a day 7 days a week.");
            workSpace.clickLogoutExpectingSSO();
            Common.assertTextOnPage(tool, "Logout successful");
            Common.assertTextOnPage(tool, logOutMessage);

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
