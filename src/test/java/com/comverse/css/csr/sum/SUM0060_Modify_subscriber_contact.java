package com.comverse.css.csr.sum;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.css.commonpages.*;
import com.comverse.css.csr.WorkSpace;
import com.comverse.data.apps.CSR;
import com.comverse.data.users.CSRAdmin;

public class SUM0060_Modify_subscriber_contact extends CSSTest {
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
    public void testSUM0060_Modify_subscriber_contact() throws Exception {
        try {
            launchCSSApplicationAndSSOLogin();

            WorkSpace workSpace = new WorkSpace(tool, test, user);

            workSpace.doResitdentialNCAResidentialBasicPrepaidBundleCSR();

            IdentifyCustomerCommon identifyCustomer = workSpace.gotoManageAccount();

            AccountDetailsCommon accountDetails = identifyCustomer.searchByPersonLastNameSinglePerson(workSpace.getPerson().getPersonLastNameProperty());

            SubscriberDetailsCommon subscriberDashboard = accountDetails.selectFirstSubscriberFromNavigationPanel();
            ModifyContactInformationCommon modifyContactInformation = subscriberDashboard.clickModifyContactInformation();

            workSpace.subscriber.setSubscriberFirstNameProperty("ModifiedFN");
            workSpace.subscriber.setSubscriberLastNameProperty("ModifiedLN");
            workSpace.subscriber.setSubscriberDayPhoneNumberProperty("ModifiedDayPhone");
            workSpace.subscriber.setSubscriberEveningPhoneNumberProperty("ModifiedEveningPhone");

            modifyContactInformation.enterFirstName(workSpace.subscriber.getSubscriberFirstNameProperty());
            modifyContactInformation.enterLastName(workSpace.subscriber.getSubscriberLastNameProperty());
            modifyContactInformation.enterDayPhone(workSpace.subscriber.getSubscriberDayPhoneNumberProperty());
            modifyContactInformation.enterEveningPhone(workSpace.subscriber.getSubscriberEveningPhoneNumberProperty());
            ModifyContactInformationConfirmationCommon modifyContactInformationConfirmation = modifyContactInformation.clickOk();
            RequestSubmissionCommon requestSubmission = modifyContactInformationConfirmation.clickOk();
            requestSubmission.clickOkModifyRequestGoTOSubscriberDashboard();

            subscriberDashboard.clickAccountIDFromNavigationPanel();
            RequestsForCustomerCommon requestsForCustomer = accountDetails.clickViewRequestsForThisCustomer();
            requestsForCustomer.waitUntilFirstRequestCompletedOrFailed();
            requestsForCustomer.clickToSubscriberDashboard();

            subscriberDashboard.clickModifyContactInformation();
            Common.assertTextEquals(workSpace.subscriber.getSubscriberFirstNameProperty(), modifyContactInformation.getFirstName());
            Common.assertTextEquals(workSpace.subscriber.getSubscriberLastNameProperty(), modifyContactInformation.getLastName());
            Common.assertTextEquals(workSpace.subscriber.getSubscriberDayPhoneNumberProperty(), modifyContactInformation.getDayPhone());
            Common.assertTextEquals(workSpace.subscriber.getSubscriberEveningPhoneNumberProperty(), modifyContactInformation.getEveningPhone());

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
