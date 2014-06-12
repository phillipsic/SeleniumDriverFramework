package com.comverse.css.pos.clm;

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

public class CLM0050_Disconnect_subscriber extends CSSTest {
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
    public void testCLM0050_Disconnect_subscriber() throws Exception {
        try {
            launchCSSApplication();
            String accountLastname = Common.getLastNamePrepaidAccount();

            MyShapeChannel loginPage = new MyShapeChannel(tool, test, user);
            WorkSpace workSpace = loginPage.loginToPOS(user);
            IdentifyCustomer manageAccount = workSpace.gotoManageAccount();

            AccountDetails accountDetails = manageAccount.gotoAccountDashboardUsingAccountLastName(accountLastname);

            SubscriberDetails subscriberDashboard = accountDetails.selectFirstSubscriberFromNavigationPanel();
            // Confirm the status of the subscriber before Disconnecting
            Common.assertTextOnPage(tool, "Status: Active");

            DisconnectSubscriberRequestForDetails disconnectSubscriberRequestForDetails = subscriberDashboard.clickDisconnectSubscriber();
            disconnectSubscriberRequestForDetails.clickCheckBoxUnlockNow();
            disconnectSubscriberRequestForDetails.setAnnotation("Disconnected by Autotest CLM0050");
            DisconnectSubscriberImpacts disconnectSubscriberImpacts = disconnectSubscriberRequestForDetails.clickContinue();

            DisconnectSubscriber disconnectSubscriber = disconnectSubscriberImpacts.clickConfirm();
            DisconnectSubscriberDisconnectionSuccessful disconnectSubscriberDisconnectionSuccessful = disconnectSubscriber.clickConfirm();

            disconnectSubscriberDisconnectionSuccessful.clickOK();

            subscriberDashboard.waitUntilStatusChanged("Disconnected");

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