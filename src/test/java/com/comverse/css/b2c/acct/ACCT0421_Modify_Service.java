package com.comverse.css.b2c.acct;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.b2c.*;
import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.css.data.SO.SO_2010WorldCupSoccerNews;
import com.comverse.data.apps.B2C;

public class ACCT0421_Modify_Service extends CSSTest {
    private StringBuffer verificationErrors = new StringBuffer();

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new B2C();
    }

    @Test
    public void testACCT0421_Modify_Service() throws Exception {
        try {
            launchCSSApplication();
            String login = Common.getB2CLoginName();
            String password = Common.getB2CPassword();
            SO_2010WorldCupSoccerNews so_2010WorldCupSoccerNews = new SO_2010WorldCupSoccerNews();
            HomePage homePage = new HomePage(tool, test, user);
            homePage.enterUsername(login);
            homePage.enterPassword(password);
            System.out.println(login + "/" + password);
            SubscriberDetail subscriberDetail = homePage.clickLogIn();
            Common.assertTextOnPage(tool, "WelcomeFN" + login);
            SelectOffers selectOffers = subscriberDetail.clickAddSO();
            ConfigureOffers configureOffer = selectOffers.selectOfferByNameAndContinue(so_2010WorldCupSoccerNews.getOfferName());
            AddSupplementaryOffers addSO = configureOffer.clickContinueExpectingOfferConfirmation();

            String orderNumber = addSO.getOrderNumberFromPage();
            subscriberDetail = addSO.clickOK();
            SearchOrders searchOrders = subscriberDetail.clickMyOrders();
            searchOrders.waitUntilOrderCompletedOrFailedWithOrderNumber(orderNumber);

            subscriberDetail = searchOrders.clickDashboard();

            Common.assertTextOnPage(tool, so_2010WorldCupSoccerNews.getOfferName());

            ModifyOfferParameters modifyOfferParameters = subscriberDetail.clickOfferConfigure(so_2010WorldCupSoccerNews.getOfferName());
            modifyOfferParameters.enterVoiceMailSize("512");
            modifyOfferParameters.checkVoiceMailEnableToNo();
            ModifyItemOfSubscriber modifyItemOfSubscriber = modifyOfferParameters.clickModify();
            ModifyItem modifyItem = modifyItemOfSubscriber.clickConfirm();
            subscriberDetail = modifyItem.clickOK();

            searchOrders = subscriberDetail.clickMyOrders();
            searchOrders.waitUntilOrderCompletedOrFailedWithOrderNumber(orderNumber);

            subscriberDetail = searchOrders.clickDashboard();

            modifyOfferParameters = subscriberDetail.clickOfferConfigure(so_2010WorldCupSoccerNews.getOfferName());

            assertEquals("512", modifyOfferParameters.getVoiceMailSize());
            // More validation steps to be added.

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
