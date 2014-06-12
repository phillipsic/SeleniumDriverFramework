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

public class SUM0090_Change_primary_offer_and_supplementary_offers extends CSSTest {
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
    public void testSUM0090_Change_primary_offer_and_supplementary_offers() throws Exception {

        try {
            String PRIMARY_OFFER = "Residential - Basic Prepaid for Swap";
            String SUPPLEMENTARY_OFFER1 = "2010 World Cup Soccer News";
            String SUPPLEMENTARY_OFFER2 = "2009 March Madness News";
            launchCSSApplication();

            MyShapeChannel loginPage = new MyShapeChannel(tool, test, user);
            WorkSpace workSpace = loginPage.loginToPOS(user);

            workSpace.doResitdentialNCAResidentialBasicPrepaidWithSOPOS(SUPPLEMENTARY_OFFER1);

            IdentifyCustomer identifyCustomer = workSpace.gotoManageAccount();

            AccountDetails accountDetails = identifyCustomer.searchByPersonLastNameSinglePerson(workSpace.getPerson().getPersonLastNameProperty());

            SubscriberDetails subscriberDashboard = accountDetails.selectFirstSubscriberFromNavigationPanel();
            Shopping shopping = subscriberDashboard.clickChangePO_SBAndSO();
            shopping.clickSubscriberBundlePrimaryOfferName(PRIMARY_OFFER);
            EnterYourSubscriptionDetails enterYourSubscriptionDetails = shopping.clickSelectOfferInPopUpWindowExpectingEnterYourSubscriptionDetails();
            SelectOffersForYourSubscriber selectOffersForYourSubscriber = enterYourSubscriptionDetails.clickContinue();
            selectOffersForYourSubscriber.selectOffersForSubscriber(SUPPLEMENTARY_OFFER1, SUPPLEMENTARY_OFFER2);
            ConfigureOffers configureOffers = selectOffersForYourSubscriber.clickContinue();
            SwapImpact swapImpact = configureOffers.clickContinueExpectingSwapImpact();
            ConfigureBalance configureBalance = swapImpact.clickOKExpectingConfigureBalance();

            configureBalance.setSpendingLimit("Voice-Anytime", "50");
            configureBalance.setSpendingLimit("CORE BALANCE", "35");
            MyBasket myBasket = configureBalance.clickContinueExpectingMyBasket();

            Common.assertTextOnPage(tool, PRIMARY_OFFER);
            Common.assertTextOnPage(tool, SUPPLEMENTARY_OFFER2);
            CheckoutReview checkoutReview = myBasket.clickCheckOut();
            CheckoutConfirmation checkoutConfirmation = checkoutReview.clickConfirm();
            checkoutConfirmation.clickOkExpectingSubscriberDashboard();
            subscriberDashboard.clickAccountIDFromNavigationPanel();
            RequestsForCustomer requestsForCustomer = accountDetails.clickViewRequestsForThisCustomer();
            requestsForCustomer.waitUntilFirstRequestCompletedOrFailed();
            requestsForCustomer.clickToSubscriberDashboard();
            Common.assertTextOnPage(tool, PRIMARY_OFFER);
            Common.assertTextNotOnPage(tool, SUPPLEMENTARY_OFFER1);
            Common.assertTextOnPage(tool, SUPPLEMENTARY_OFFER2);

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
