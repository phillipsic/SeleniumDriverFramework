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

public class SUM0030_View_subscribed_subscriber_bundle_details extends CSSTest {

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
    public void testSUM0030_View_subscribed_subscriber_bundle_details() throws Exception {

        try {
            String SUBSCRIBER_BUNDLE = "Residential - Basic Prepaid Bundle";
            launchCSSApplication();

            MyShapeChannel loginPage = new MyShapeChannel(tool, test, user);
            WorkSpace workSpace = loginPage.loginToPOS(user);

            workSpace.doResitdentialNCAResidentialBasicPrepaidBundlePOS();

            IdentifyCustomer identifyCustomer = workSpace.gotoManageAccount();

            AccountDetails accountDetails = identifyCustomer.searchByPersonLastNameSinglePerson(workSpace.getPerson().getPersonLastNameProperty());

            SubscriberDetails subscriberDashboard = accountDetails.selectFirstSubscriberFromNavigationPanel();
            subscriberDashboard.clickImageOfSubscriberBundleName(SUBSCRIBER_BUNDLE);

            Common.assertTextOnPage(tool, SUBSCRIBER_BUNDLE);

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
