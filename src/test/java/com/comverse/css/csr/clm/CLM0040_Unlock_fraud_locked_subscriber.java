package com.comverse.css.csr.clm;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.css.csr.*;
import com.comverse.data.apps.CSR;
import com.comverse.data.users.CSRUser;

public class CLM0040_Unlock_fraud_locked_subscriber extends CSSTest {
    private StringBuffer verificationErrors = new StringBuffer();

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new CSR();
        user = new CSRUser();
    }

    @Test
    public void testCLM0040_Unlock_fraud_locked_subscriber() throws Exception {
        try {
            launchCSSApplicationAndSSOLogin();

            WorkSpace workSpace = new WorkSpace(tool, test, user);

            workSpace.doResitdentialNCAResidentialUltraPostpaidCSR();

            IdentifyCustomer manageAccount = workSpace.gotoManageAccount();

            AccountDetails accountDetails = manageAccount.gotoAccountDashboardUsingAccountLastName(workSpace.getAccount().getBillingLastNameProperty());

            // AccountDetails accountDetails =
            // customerSearchResult.clickPersonNameLink(workSpace.getPerson().getPersonLastNameProperty());

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