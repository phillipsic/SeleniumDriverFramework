package com.comverse.css.b2c.acct;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.b2c.*;
import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.data.apps.B2C;

public class ACCT0412AB_Subscribe_New_Services_AB_SB_PO extends CSSTest {
    private StringBuffer verificationErrors = new StringBuffer();

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new B2C();
    }

    @Test
    public void testACCT0412AB_Subscribe_New_Services_AB_SB_PO() throws Exception {
        try {
            launchCSSApplication();
            String login = Common.getB2CLoginName();
            String password = Common.getB2CPassword();

            HomePage homePage = new HomePage(tool, test, user);
            homePage.enterUsername(login);
            homePage.enterPassword(password);
            System.out.print(login + "/" + password);
            SubscriberDetail subscriberDetail = homePage.clickLogIn();
            Common.assertTextOnPage(tool, "Welcome");
            SelectOffers selectOffers = subscriberDetail.clickAddSO();
            AddSupplementaryOffers addSO = selectOffers.selectOfferByNameAndContinueExpectingAddSO("OneVoice Data");
            String orderNumber = addSO.getOrderNumberFromPage();

            // AddSupplementaryOffers addSO =
            // configureOffer.clickContinueExpectingOfferConfirmation();
            subscriberDetail = addSO.clickOK();
            SearchOrders searchOrders = subscriberDetail.clickMyOrders();

            // @TODO - need to check that the Add SO order has completed and
            // been added to the dashboard.
            searchOrders.waitUntilOrderCompletedOrFailedWithOrderNumber(orderNumber);

            subscriberDetail = searchOrders.clickDashboard();

            Common.assertTextOnPage(tool, "OneVoice Data");

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
