package com.comverse.css.csr.aml;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.css.csr.*;
import com.comverse.data.apps.CSR;
import com.comverse.data.users.CSRAdmin;

public class AML0010_Disconnect_Account extends CSSTest {
    private StringBuffer verificationErrors = new StringBuffer();

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new CSR();
        user = new CSRAdmin();
    }

    @Test
    public void testAML0010_Disconnect_Account() throws Exception {
        try {
            launchCSSApplicationAndSSOLogin();
            String accountLastname = Common.getBCTLastName();

            WorkSpace workSpace = new WorkSpace(tool, test, user);
            IdentifyCustomer manageAccount = workSpace.gotoManageAccount();

            AccountDetails accountDashboard = manageAccount.gotoAccountDashboardUsingAccountLastName(accountLastname);

            Common.assertTextOnPage(tool, "Status: New");

            DisconnectAccount disconnectAccount = accountDashboard.clickDisconnectAccount();
            disconnectAccount.clickCheckBoxUnlockNow();
            disconnectAccount.setAnnotation("Disconnect Account");
            disconnectAccount.clickContinue();
            Common.isTextOnPage(tool, "Disconnect account - Impacts");
            disconnectAccount.clickContinueOnImpacts();
            Common.isTextOnPage(tool, "Disconnect account - Confirmation");
            disconnectAccount.clickOk();
            Common.isTextOnPage(tool, "Account Details");

            accountDashboard.waitUntilSubscriberStatusChanged("Status:  Disconnected");

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