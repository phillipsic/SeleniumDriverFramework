package com.comverse.css.csr.uam;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.common.User;
import com.comverse.css.OCM.LoginPage;
import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.css.csr.*;
import com.comverse.data.apps.CSR;
import com.comverse.data.users.OCMPub;
import com.comverse.data.users.TelcoAdmin;
import com.comverse.sec.ComverseOneSingleSignOn;
import static org.junit.Assert.assertEquals;

public class UAM0140_Force_user_to_change_password_on_first_login extends CSSTest {

    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    @Override
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new CSR();
        user = new TelcoAdmin();
    }

    @Test
    public void testUAM0140_Force_user_to_change_password_on_first_login() throws Exception {
        try {
            launchCSSApplicationAndSSOLogin();
            String uniqueCode = Common.generateTimeStamp();

            WorkSpace workSpace = new WorkSpace(tool, test, user);
            ViewHierarchy viewHierarchy = workSpace.clickManageTelco();

            User OCMUser = viewHierarchy.addOCMPublisherEmployee(uniqueCode);

            ComverseOneSingleSignOn comverseOneSingleSignOn = viewHierarchy.clickLogoutExpectingSSO();

            launchOCMApplication();
            LoginPage loginPage = new LoginPage(tool, test, OCMUser);
            loginPage.loginToOCMAndChangePassword(OCMUser);

            test.setResult("pass");

        } catch (AlreadyRunException e) {
        } catch (Exception e) {
            verificationErrors.append(e.getMessage());
            throw e;
        }
    }

    @After
    @Override
    public void tearDown() throws Exception {
        super.tearDown();
    }
}
