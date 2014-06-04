package com.comverse.css.bct;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.Prep;
import com.comverse.data.apps.WPMC;
import com.comverse.workpoint.LogonToTheWorkPointManagementConsole;
import com.comverse.workpoint.WelcomeToTheWorkpointManagementConsole;
import com.comverse.workpoint.WorkpointManagementConsole;
import com.comverse.workpoint.common.WPMCTest;

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

            LogonToTheWorkPointManagementConsole loginPage = new LogonToTheWorkPointManagementConsole(driver);
            WelcomeToTheWorkpointManagementConsole welcomeToTheWorkpointManagementConsole = loginPage.successfulWPMCAdminLogin();
            WorkpointManagementConsole workpointManagementConsole = welcomeToTheWorkpointManagementConsole.clickManageMonitors();

            assertEquals("NORMAL", workpointManagementConsole.getStatusOfMonitorQueue("WPDS#actionq#ActionQ1"));
            assertEquals("NORMAL", workpointManagementConsole.getStatusOfMonitorQueue("WPDS#alertq#AlertQ1"));
            assertEquals("NORMAL", workpointManagementConsole.getStatusOfMonitorQueue("WPDS#jobq#JobQ1"));
            assertEquals("NORMAL", workpointManagementConsole.getStatusOfMonitorQueue("WPDS#mailq#MailQ1"));

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
