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

public class USM0040_Display_home_page_for_a_telco extends CSSTest {
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
    public void testUSM0040_Display_home_page_for_a_telco() throws Exception {

        try {
            launchCSSApplicationAndSSOLogin();
            Common.assertTextOnPage(tool, "Welcome to Your Workspace");
            WorkSpace workSpace = new WorkSpace(tool, test, user);
            Common.assertTextOnPage(tool, "Welcome to Your Workspace");
            workSpace.clickLogoutExpectingSSO();

            user = new CSRUser();
            launchCSSApplicationAndSSOLogin();
            Common.assertTextOnPage(tool, "Welcome to Your Workspace");
            workSpace.clickLogoutExpectingSSO();

            user = new BOGAdmin();
            launchCSSApplicationAndSSOLogin();
            Common.assertTextOnPage(tool, "Welcome to Your Workspace");
            workSpace.clickLogoutExpectingSSO();

            user = new TelcoAdmin();
            launchCSSApplicationAndSSOLogin();
            Common.assertTextOnPage(tool, "Welcome to Your Workspace");

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
