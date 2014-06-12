package com.comverse.css.pos.pem;

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

public class PEM0310_Dissociate_persona_from_subscription extends CSSTest {
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
    public void testPEM0310_Dissociate_persona_from_subscription() throws Exception {

        try {
            launchCSSApplication();
            MyShapeChannel loginPage = new MyShapeChannel(tool, test, user);
            WorkSpace workSpace = loginPage.loginToPOS(user);
            workSpace.doResitdentialNCAResidentialUltraPostpaidPOS();
            IdentifyCustomer manageAccount = workSpace.gotoManageAccount();
            CustomerSearchResult customerSearchResult = manageAccount.searchByAccountLastNameMultiplePersons(workSpace.getAccount().getBillingLastNameProperty());

            AccountDetails accountDetails = customerSearchResult.clickPersonNameLink(workSpace.getPerson().getPersonLastNameProperty());

            PersonManagement personManagement = accountDetails.clickPersonManagement();

            Common.assertTextOnPage(tool, "Customer User: Ordering");
            Common.assertTextOnPage(tool, workSpace.getSubscriber().getSubscriberMSISDNProperty());
            personManagement.clickActions(workSpace.person2.getPersonFirstNameProperty());
            personManagement.clickDissociate();
            personManagement.clickOKFromDissociate();
            Common.assertTextOnPage(tool, "N/A");
            Common.assertTextNotOnPage(tool, workSpace.getSubscriber().getSubscriberMSISDNProperty());

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
