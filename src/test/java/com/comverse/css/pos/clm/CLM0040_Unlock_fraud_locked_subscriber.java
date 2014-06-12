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

public class CLM0040_Unlock_fraud_locked_subscriber extends CSSTest {
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
    public void testCLM0040_Unlock_fraud_locked_subscriber() throws Exception {
        try {
            launchCSSApplication();

            MyShapeChannel loginPage = new MyShapeChannel(tool, test, user);
            WorkSpace workSpace = loginPage.loginToPOS(user);

            workSpace.doResitdentialNCAResidentialUltraPostpaidPOS();

            IdentifyCustomer manageAccount = workSpace.gotoManageAccount();

            CustomerSearchResult customerSearchResult = manageAccount.searchByAccountLastNameMultiplePersons(workSpace.getAccount().getBillingLastNameProperty());

            AccountDetails accountDetails = customerSearchResult.clickPersonNameLink(workSpace.getPerson().getPersonLastNameProperty());

            SubscriberDetails subscriberDashboard = accountDetails.selectFirstSubscriberFromNavigationPanel();
            // Confirm the status of the subscriber before Fraud Locking
            Common.assertTextOnPage(tool, "Status: Active");

            FraudlockSubscriberRequestForDetails fraudlockSubscriberRequestForDetails = subscriberDashboard.clickFraudlockSubscriber();

            fraudlockSubscriberRequestForDetails.clickCheckBoxFraudlockNow();
            fraudlockSubscriberRequestForDetails.setReason("Customer Initiated");
            fraudlockSubscriberRequestForDetails.setAnnotation("Fraud Locked by Autotest CLM0040");
            FraudlockSubscriberConfirmation fraudlockSubscriberConfirmation = fraudlockSubscriberRequestForDetails.clickContinue();

            Common.assertTextOnPage(tool, "Now");
            Common.assertTextOnPage(tool, "Customer Initiated");
            Common.assertTextOnPage(tool, "Fraud lock impacts:");

            FraudlockSubscriberFraudlockSuccessful fraudlockSubscriberFraudlockSuccessful = fraudlockSubscriberConfirmation.clickConfirm();
            subscriberDashboard = fraudlockSubscriberFraudlockSuccessful.clickOK();

            subscriberDashboard.waitUntilStatusChanged("Fraud Lock");
            Common.assertTextOnPage(tool, "Status: Fraud Lock");

            UnlockSubscriberRequestForDetails unlockSubscriberRequestForDetails = subscriberDashboard.clickUnlockSubscriber();

            unlockSubscriberRequestForDetails.clickCheckBoxUnlockNow();
            unlockSubscriberRequestForDetails.setReason("Customer Initiated");
            unlockSubscriberRequestForDetails.setAnnotation("Unlocked by Auto test CLM0040");
            UnlockSubscriberConfirmation unlockSubscriberConfirmation = unlockSubscriberRequestForDetails.clickContinue();

            Common.assertTextOnPage(tool, "Now");
            Common.assertTextOnPage(tool, "Customer Initiated");

            UnlockSubscriberUnlockSuccessful unlockSubscriberUnlockSuccessful = unlockSubscriberConfirmation.clickConfirm();

            subscriberDashboard = unlockSubscriberUnlockSuccessful.clickOK();

            subscriberDashboard.waitUntilStatusChanged("Active");

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
//
//
//           