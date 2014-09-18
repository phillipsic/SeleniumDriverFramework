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
import com.comverse.data.users.CSRUser;

public class SUM0070_Modify_subscriber_attributes extends CSSTest {
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    @Override
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new CSR();
        user = new CSRUser();
    }

    @Test
    public void testSUM0070_Modify_subscriber_attributes() throws Exception {
        try {
            launchCSSApplicationAndSSOLogin();

            WorkSpace workSpace = new WorkSpace(tool, test, user);

            workSpace.doResitdentialNCAResidentialBasicPrepaidBundleCSR();

            IdentifyCustomerCommon identifyCustomer = workSpace.gotoManageAccount();

            AccountDetailsCommon accountDetails = identifyCustomer.searchByPersonLastNameSinglePerson(workSpace.getPerson().getPersonLastNameProperty());

            SubscriberDetailsCommon subscriberDashboard = accountDetails.selectFirstSubscriberFromNavigationPanel();
            subscriberDashboard.clickSubscriberAttributesTab();
            ModifySubscriberAttributesCommon modifySubscriberAttributes = subscriberDashboard.clickModifySubscriberDetails();

            workSpace.subscriber.setSubscriberBirthdayProperty("09/01/2013");
            workSpace.subscriber.setSubscriberSecurityWordProperty("ModifiedSecWord");
            workSpace.subscriber.setSubscriberLanguageProperty("Dutch");

            modifySubscriberAttributes.enterBirthday(workSpace.subscriber.getSubscriberBirthdayProperty());
            modifySubscriberAttributes.enterSecurityWord(workSpace.subscriber.getSubscriberSecurityWordProperty());
            modifySubscriberAttributes.enterLanguage(workSpace.subscriber.getSubscriberLanguageProperty());
            modifySubscriberAttributes.enterHappyHourStart(workSpace.subscriber.getSubscriberHappyHourStartProperty());
            modifySubscriberAttributes.enterHappyHourEnd(workSpace.subscriber.getSubscriberHappyHourEndProperty());
            RequestSubmissionCommon requestSubmission = modifySubscriberAttributes.clickModifyAttributes();
            requestSubmission.clickOkModifyRequestGoTOSubscriberDashboard();

            subscriberDashboard.clickAccountIDFromNavigationPanel();
            RequestsForCustomerCommon requestsForCustomer = accountDetails.clickViewRequestsForThisCustomer();
            test.setBugId("CBS00159807");
            requestsForCustomer.waitUntilFirstRequestCompletedOrFailed();
            test.setBugId("NoBug");

            requestsForCustomer.clickToSubscriberDashboard();

            subscriberDashboard.clickSubscriberAttributesTab();
            subscriberDashboard.clickModifySubscriberDetails();
            Common.assertTextEquals(workSpace.subscriber.getSubscriberBirthdayProperty(), modifySubscriberAttributes.getBirthday());
            Common.assertTextEquals(workSpace.subscriber.getSubscriberSecurityWordProperty(), modifySubscriberAttributes.getSecurityWord());
            Common.assertTextEquals(workSpace.subscriber.getSubscriberLanguageProperty(), modifySubscriberAttributes.getLanguage());
            Common.assertTextEquals(workSpace.subscriber.getSubscriberHappyHourStartProperty(), modifySubscriberAttributes.getHappyHourStart());
            Common.assertTextEquals(workSpace.subscriber.getSubscriberHappyHourEndProperty(), modifySubscriberAttributes.getHappyHourEnd());

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
