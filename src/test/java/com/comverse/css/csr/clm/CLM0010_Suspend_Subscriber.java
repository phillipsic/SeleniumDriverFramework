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
import com.comverse.data.users.CSRAdmin;


public class CLM0010_Suspend_Subscriber extends CSSTest {
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
    public void testCLM0010_Suspend_Subscriber() throws Exception {
        try {
            launchCSSApplicationAndSSOLogin();

            WorkSpace workSpace = new WorkSpace(tool, test, user);

            workSpace.doResitdentialNCAResidentialUltraPostpaidCSR();

            IdentifyCustomer manageAccount = workSpace.gotoManageAccount();

            AccountDetails accountDetails = manageAccount.gotoAccountDashboardUsingAccountLastName(workSpace.getAccount().getBillingLastNameProperty());

            // AccountDetails accountDetails =
            // customerSearchResult.clickPersonNameLink(workSpace.getPerson().getPersonLastNameProperty());

            SubscriberDetails subscriberDashboard = accountDetails.selectFirstSubscriberFromNavigationPanel();
            // Confirm the status of the subscriber before Suspending
            Common.assertTextOnPage(tool, "Status: Active");
            SuspendSubscriberRequestForDetails suspendSubscriberRequestForDetails = subscriberDashboard.clickSuspendSubscriber();
            Common.assertTextOnPage(tool, "Date/Time suspension");
            suspendSubscriberRequestForDetails.setReason("Customer Initiated");
            suspendSubscriberRequestForDetails.setAnnotation("Suspended by Autotest CLM0010");
            SuspendSubscriberConfirmation suspendSubscriberConfirmation = suspendSubscriberRequestForDetails.clickContinue();

            Common.assertTextOnPage(tool, "Now");
            Common.assertTextOnPage(tool, "Customer Initiated");

            SuspendSubscriberSuspendSuccessful suspendSubscriberSuspendSuccessful = suspendSubscriberConfirmation.clickConfirm();
            subscriberDashboard = suspendSubscriberSuspendSuccessful.clickOK();

            subscriberDashboard.waitUntilStatusChanged("Suspended");
            Common.assertTextOnPage(tool, "Status: Suspended");

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