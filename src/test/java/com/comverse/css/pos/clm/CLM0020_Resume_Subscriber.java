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

public class CLM0020_Resume_Subscriber extends CSSTest {
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
    public void testCLM0020_Resume_Subscriber() throws Exception {
        try {
            launchCSSApplication();

            MyShapeChannel loginPage = new MyShapeChannel(tool, test, user);
            WorkSpace workSpace = loginPage.loginToPOS(user);

            workSpace.doResitdentialNCAResidentialUltraPostpaidPOS();

            IdentifyCustomer manageAccount = workSpace.gotoManageAccount();

            CustomerSearchResult customerSearchResult = manageAccount.searchByAccountLastNameMultiplePersons(workSpace.getAccount().getBillingLastNameProperty());

            AccountDetails accountDetails = customerSearchResult.clickPersonNameLink(workSpace.getPerson().getPersonLastNameProperty());

            SubscriberDetails subscriberDashboard = accountDetails.selectFirstSubscriberFromNavigationPanel();
            // Confirm the status of the subscriber before Suspending
            Common.assertTextOnPage(tool, "Status: Active");
            SuspendSubscriberRequestForDetails suspendSubscriberRequestForDetails = subscriberDashboard.clickSuspendSubscriber();
            Common.assertTextOnPage(tool, "Date/Time suspension");
            suspendSubscriberRequestForDetails.setReason("Customer Initiated");
            suspendSubscriberRequestForDetails.setAnnotation("Suspended by Auto test CLM0020");
            SuspendSubscriberConfirmation suspendSubscriberConfirmation = suspendSubscriberRequestForDetails.clickContinue();

            Common.assertTextOnPage(tool, "Now");
            Common.assertTextOnPage(tool, "Customer Initiated");

            SuspendSubscriberSuspendSuccessful suspendSubscriberSuspendSuccessful = suspendSubscriberConfirmation.clickConfirm();
            subscriberDashboard = suspendSubscriberSuspendSuccessful.clickOK();

            subscriberDashboard.waitUntilStatusChanged("Suspended");
            Common.assertTextOnPage(tool, "Status: Suspended");

            ResumeSubscriberRequestForDetails resumeSubscriberRequestForDetails = subscriberDashboard.clickResumeSubscriber();
            Common.assertTextOnPage(tool, "Date/Time resume");
            resumeSubscriberRequestForDetails.clickCheckBoxResumeNow();
            resumeSubscriberRequestForDetails.setReason("Customer Initiated");
            resumeSubscriberRequestForDetails.setAnnotation("Resumed by CLM0020");
            ResumeSubscriberConfirmation resumeSubscriberConfirmation = resumeSubscriberRequestForDetails.clickContinue();

            Common.assertTextOnPage(tool, "Now");
            Common.assertTextOnPage(tool, "Customer Initiated");

            ResumeSubscriberResumeSuccessful resumeSubscriberResumeSuccessful = resumeSubscriberConfirmation.clickConfirm();

            subscriberDashboard = resumeSubscriberResumeSuccessful.clickOK();
            subscriberDashboard.waitUntilStatusChanged("Active");
            // Check that the status is updated to active again after Resume
            Common.assertTextOnPage(tool, "Status: Active");
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