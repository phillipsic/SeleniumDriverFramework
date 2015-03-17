package com.company.css.bct;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.framework.common.AlreadyRunException;
import com.framework.app.common.Common;
import com.framework.app.common.Prep;
import com.company.data.apps.WPMC;
import com.company.workpoint.LogonToTheWorkPointManagementConsole;
import com.company.workpoint.WelcomeToTheWorkpointManagementConsole;
import com.company.workpoint.WorkpointManagementConsole;
import com.company.workpoint.common.WPMCTest;

public class BCT010_WorkPointChecks extends WPMCTest {

    private StringBuffer verificationErrors = new StringBuffer();

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new WPMC();
    }

    @Test
    public void testBCT010_WorkPointChecks() throws Exception {

        try {
            launchWPMCApplication();

            LogonToTheWorkPointManagementConsole loginPage = new LogonToTheWorkPointManagementConsole(tool, test, user);
            WelcomeToTheWorkpointManagementConsole welcomeToTheWorkpointManagementConsole = loginPage.successfulWPMCAdminLogin();
            WorkpointManagementConsole workpointManagementConsole = welcomeToTheWorkpointManagementConsole.clickManageMonitors();

            Common.assertTextEquals("NORMAL", workpointManagementConsole.getStatusOfMonitorQueue("WPDS#actionq#ActionQ1"));
            Common.assertTextEquals("NORMAL", workpointManagementConsole.getStatusOfMonitorQueue("WPDS#alertq#AlertQ1"));
            Common.assertTextEquals("NORMAL", workpointManagementConsole.getStatusOfMonitorQueue("WPDS#jobq#JobQ1"));
            Common.assertTextEquals("NORMAL", workpointManagementConsole.getStatusOfMonitorQueue("WPDS#mailq#MailQ1"));

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
