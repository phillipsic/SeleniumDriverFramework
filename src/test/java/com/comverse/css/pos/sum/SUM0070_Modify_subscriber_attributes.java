package com.comverse.css.pos.sum;

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

public class SUM0070_Modify_subscriber_attributes extends CSSTest {
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    @Override
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new POS();
        user = new TelcoRetailerAdmin();
    }

    @Test
    public void testSUM0070_Modify_subscriber_attributes() throws Exception {

        try {
            launchCSSApplication();

            MyShapeChannel loginPage = new MyShapeChannel(tool, test, user);
            WorkSpace workSpace = loginPage.loginToPOS(user);

            workSpace.doResitdentialNCAResidentialBasicPrepaidBundlePOS();

            IdentifyCustomer identifyCustomer = workSpace.gotoManageAccount();

            AccountDetails accountDetails = identifyCustomer.searchByPersonLastNameSinglePerson(workSpace.getPerson().getPersonLastNameProperty());

            SubscriberDetails subscriberDashboard = accountDetails.selectFirstSubscriberFromNavigationPanel();
            subscriberDashboard.clickSubscriberAttributesTab();
            ModifySubscriberAttributes modifySubscriberAttributes = subscriberDashboard.clickModifySubscriberDetails();

            workSpace.subscriber.setSubscriberBirthdayProperty("09/01/2013");
            workSpace.subscriber.setSubscriberSecurityWordProperty("ModifiedSecWord");
            workSpace.subscriber.setSubscriberLanguageProperty("Dutch");

            modifySubscriberAttributes.enterBirthday(workSpace.subscriber.getSubscriberBirthdayProperty());
            modifySubscriberAttributes.enterSecurityWord(workSpace.subscriber.getSubscriberSecurityWordProperty());
            modifySubscriberAttributes.enterLanguage(workSpace.subscriber.getSubscriberLanguageProperty());
            modifySubscriberAttributes.enterHappyHourStart(workSpace.subscriber.getSubscriberHappyHourStartProperty());
            modifySubscriberAttributes.enterHappyHourEnd(workSpace.subscriber.getSubscriberHappyHourEndProperty());
            RequestSubmission requestSubmission = modifySubscriberAttributes.clickModifyAttributes();
            requestSubmission.clickOkModifyRequestGoTOSubscriberDashboard();

            subscriberDashboard.clickAccountIDFromNavigationPanel();
            RequestsForCustomer requestsForCustomer = accountDetails.clickViewRequestsForThisCustomer();
            requestsForCustomer.waitUntilFirstRequestCompletedOrFailed();
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
