package com.comverse.css.pos.aml;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.css.pos.*;
import com.comverse.data.apps.POS;
import com.comverse.data.users.TelcoRetailerAdmin;

public class AML0010_Disconnect_Account extends CSSTest {
    private StringBuffer verificationErrors = new StringBuffer();

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new POS();
        user = new TelcoRetailerAdmin();
    }

    @Test
    public void testAML0010_Disconnect_Account() throws Exception {
        try {
            launchCSSApplication();
            String accountLastname = Common.getBCTLastName();

            MyShapeChannel myShapeChannel = new MyShapeChannel(tool, test, user);
            WorkSpace workSpace = myShapeChannel.loginToPOS(user);
            IdentifyCustomer manageAccount = workSpace.gotoManageAccount();

            AccountDetails accountDashboard = manageAccount.gotoAccountDashboardUsingAccountLastName(accountLastname);

            Common.assertTextOnPage(tool, "Status: New");

            DisconnectAccount disconnectAccount = accountDashboard.clickDisconnectAccount();
            disconnectAccount.clickCheckBoxDisconnectNow();
            disconnectAccount.setAnnotation("Disconnect Account");
            disconnectAccount.clickContinue();
            Common.isTextOnPage(tool, "Disconnect account - Impacts");
            disconnectAccount.clickContinueOnImpacts();
            Common.isTextOnPage(tool, "Disconnect account - Confirmation");
            disconnectAccount.clickOk();
            Common.isTextOnPage(tool, "Account Details");

            accountDashboard.waitUntilStatusChanged("Disconnect Requested");

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
