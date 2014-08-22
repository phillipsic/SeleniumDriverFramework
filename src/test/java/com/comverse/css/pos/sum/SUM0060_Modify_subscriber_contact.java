package com.comverse.css.pos.sum;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Prep;
import com.comverse.css.pos.*;
import com.comverse.data.apps.POS;
import com.comverse.data.users.TelcoRetailerAdmin;

public class SUM0060_Modify_subscriber_contact extends CSSTest {

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
    public void testSUM0060_Modify_subscriber_contact() throws Exception {

        try {
            launchCSSApplication();

            MyShapeChannel loginPage = new MyShapeChannel(tool, test, user);
            WorkSpace workSpace = loginPage.loginToPOS(user);

            workSpace.doResitdentialNCAResidentialBasicPrepaidBundlePOS();

            IdentifyCustomer identifyCustomer = workSpace.gotoManageAccount();

            AccountDetails accountDetails = identifyCustomer.searchByPersonLastNameSinglePerson(workSpace.getPerson().getPersonLastNameProperty());

            SubscriberDetails subscriberDashboard = accountDetails.selectFirstSubscriberFromNavigationPanel();
            ModifyContactInformation modifyContactInformation = subscriberDashboard.clickModifyContactInformation();

            workSpace.subscriber.setSubscriberFirstNameProperty("ModifiedFN");
            workSpace.subscriber.setSubscriberLastNameProperty("ModifiedLN");
            workSpace.subscriber.setSubscriberDayPhoneNumberProperty("ModifiedDayPhone");
            workSpace.subscriber.setSubscriberEveningPhoneNumberProperty("ModifiedEveningPhone");

            modifyContactInformation.enterFirstName(workSpace.subscriber.getSubscriberFirstNameProperty());
            modifyContactInformation.enterLastName(workSpace.subscriber.getSubscriberLastNameProperty());
            modifyContactInformation.enterDayPhone(workSpace.subscriber.getSubscriberDayPhoneNumberProperty());
            modifyContactInformation.enterEveningPhone(workSpace.subscriber.getSubscriberEveningPhoneNumberProperty());
            ModifyContactInformationConfirmation modifyContactInformationConfirmation = modifyContactInformation.clickOk();
            test.setBugId("CBS00169186");
            RequestSubmission requestSubmission = modifyContactInformationConfirmation.clickOk();
            test.setBugId("NoBug");
            requestSubmission.clickOkModifyRequestGoTOSubscriberDashboard();

            subscriberDashboard.clickAccountIDFromNavigationPanel();
            RequestsForCustomer requestsForCustomer = accountDetails.clickViewRequestsForThisCustomer();
            requestsForCustomer.waitUntilFirstRequestCompletedOrFailed();
            requestsForCustomer.clickToSubscriberDashboard();

            subscriberDashboard.clickModifyContactInformation();
            assertEquals(workSpace.subscriber.getSubscriberFirstNameProperty(), modifyContactInformation.getFirstName());
            assertEquals(workSpace.subscriber.getSubscriberLastNameProperty(), modifyContactInformation.getLastName());
            assertEquals(workSpace.subscriber.getSubscriberDayPhoneNumberProperty(), modifyContactInformation.getDayPhone());
            assertEquals(workSpace.subscriber.getSubscriberEveningPhoneNumberProperty(), modifyContactInformation.getEveningPhone());

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
