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

public class SUM0100_Swap_primary_offer_subscriber_bundle extends CSSTest {
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
    public void testSUM0100_Swap_primary_offer_subscriber_bundle() throws Exception {

        try {
            String PRIMARY_OFFER = "DIY - Weekly Subscription Prime Offering.";
            String SUBSCRIBER_BUNDLE = "DIY - Week 7-7 Bundle.";
            launchCSSApplication();

            MyShapeChannel loginPage = new MyShapeChannel(tool, test, user);
            WorkSpace workSpace = loginPage.loginToPOS(user);

            EnterIdentificationData enterIdentificationData = workSpace.startNewConvergentResidentialCustomer();
            workSpace.account = enterIdentificationData.enterDefaultIdentificationData();
            workSpace.person = enterIdentificationData.getPerson();
            workSpace.subscriber = enterIdentificationData.getSubscriber();
            Shopping shopping = enterIdentificationData.clickContinue();
            shopping.clickSubscriberBundlePrimaryOfferName(PRIMARY_OFFER);
            ConfigureContractDetails configureContractDetails = shopping.clickSelectOfferInPopUpWindowExpectingConfigureContract();

            MyBasket myBasket = configureContractDetails.clickContinue();

            ServiceConnectionDetails serviceConnectionDetails = myBasket.clickFirstActionsIcon();
            serviceConnectionDetails.clickSetIMSIInventory(workSpace.subscriber);
            serviceConnectionDetails.clickOk();
            myBasket.addConsumerUserPersonOrdering();
            myBasket.clickAcceptTermsAndConditions();
            CheckoutReview checkoutReview = myBasket.clickCheckOut();
            CheckoutConfirmation checkoutConfirmation = checkoutReview.clickConfirm();
            String orderNumber = checkoutConfirmation.getOrderNumberFromPage();
            workSpace = checkoutConfirmation.clickOk();
            workSpace.setAccount(workSpace.account);
            workSpace.setPerson(workSpace.person);
            workSpace.setSubscriber(workSpace.subscriber);
            SearchRequests searchRequests = workSpace.clickRequests();
            SearchOrders searchOrders = searchRequests.clickSearchOrders();
            searchOrders.waitUntilOrderCompletedOrFailed(orderNumber);
            searchOrders.clickHomeMenu();
            IdentifyCustomer identifyCustomer = workSpace.gotoManageAccount();
            AccountDetails accountDetails = identifyCustomer.searchByPersonLastNameSinglePerson(enterIdentificationData.getPerson().getPersonLastNameProperty());

            SubscriberDetails subscriberDashboard = accountDetails.selectFirstSubscriberFromNavigationPanel();
            subscriberDashboard.clickChangePO_SBAndSO();
            shopping.clickSubscriberBundlePrimaryOfferName(SUBSCRIBER_BUNDLE);
            test.setBugId("CBS00165233");
            EnterYourSubscriptionDetails enterYourSubscriptionDetails = shopping.clickSelectOfferInPopUpWindowExpectingEnterYourSubscriptionDetails();
            test.setBugId("NoBug");

            SelectOffersForYourSubscriber selectOffersForYourSubscriber = enterYourSubscriptionDetails.clickContinue();
            ConfigureOffers configureOffers = selectOffersForYourSubscriber.clickContinue();
            SwapImpact swapImpact = configureOffers.clickContinueExpectingSwapImpact();
            swapImpact.clickOK();
            myBasket.clickAcceptTermsAndConditions();
            Common.assertTextOnPage(tool, SUBSCRIBER_BUNDLE);
            myBasket.clickCheckOut();
            checkoutReview.clickConfirm();
            checkoutConfirmation.clickOkExpectingSubscriberDashboard();
            subscriberDashboard.clickAccountIDFromNavigationPanel();
            RequestsForCustomer requestsForCustomer = accountDetails.clickViewRequestsForThisCustomer();
            requestsForCustomer.waitUntilFirstRequestCompletedOrFailed();
            requestsForCustomer.clickToSubscriberDashboard();
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
