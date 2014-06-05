package com.comverse.css.b2c.acct;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.b2c.*;
import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.css.data.SO.SO_OneVoiceData;
import com.comverse.data.apps.B2C;

public class ACCT0413AB_Remove_Service_AB_SB_PO extends CSSTest {
    private StringBuffer verificationErrors = new StringBuffer();

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new B2C();
    }

    @Test
    public void testACCT0413AB_Remove_Service_AB_SB_PO() throws Exception {
        try {
            launchCSSApplication();
            String login = Common.getB2CLoginName();
            String password = Common.getB2CPassword();
            SO_OneVoiceData so_OneVoiceData = new SO_OneVoiceData();
            HomePage homePage = new HomePage(driver);
            homePage.enterUsername(login);
            homePage.enterPassword(password);
            System.out.println(login + "/" + password);
            SubscriberDetail subscriberDetail = homePage.clickLogIn();
            Common.assertTextOnPage(driver, "WelcomeFN" + login);
            SelectOffers selectOffers = subscriberDetail.clickAddSO();
            AddSO addSO = selectOffers.selectOfferByNameAndContinueExpectingAddSO(so_OneVoiceData.getOfferName());
            // AddSO addSO =
            // configureOffer.clickContinueExpectingOfferConfirmation();
            String firstOrder = addSO.getOrderNumberFromPage();
            subscriberDetail = addSO.confirmAddSO();
            SearchOrders searchOrders = subscriberDetail.clickMyOrders();

            searchOrders.waitUntilOrderCompletedOrFailedWithOrderNumber(firstOrder);
            subscriberDetail = searchOrders.clickDashboard();

            Common.assertTextOnPage(driver, so_OneVoiceData.getOfferName());
            RemoveOffer removeOffer = subscriberDetail.clickOfferRemove();
            OfferCancellation offerCancellation = removeOffer.ClickYes();

            String secondOrder = offerCancellation.getOrderNumberFromPage();
            subscriberDetail = offerCancellation.ClickOk();

            searchOrders = subscriberDetail.clickMyOrders();

            searchOrders.waitUntilOrderCompletedOrFailedWithOrderNumber(secondOrder);
            subscriberDetail = searchOrders.clickDashboard();

            Common.assertTextNotOnPage(driver, so_OneVoiceData.getOfferName());

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
