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

public class SUM0110_Update_subscriber_external_id extends CSSTest {
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
    public void testSUM0110_Update_subscriber_external_id() throws Exception {

        try {
            String PRIMARY_OFFER1 = "DIYe - TV Video Gaming";
            String SUPPLEMENTARY_OFFER = "DIYe - Countdown extra !";
            String PRIMARY_OFFER2 = "DIY - Triple Choice Device TV Play Offer";
            launchCSSApplication();

            MyShapeChannel loginPage = new MyShapeChannel(tool, test, user);
            WorkSpace workSpace = loginPage.loginToPOS(user);

            EnterIdentificationData enterIdentificationData = workSpace.startNewConvergentResidentialCustomer();
            workSpace.account = enterIdentificationData.enterDefaultIdentificationData();
            workSpace.person = enterIdentificationData.getPerson();
            workSpace.subscriber = enterIdentificationData.getSubscriber();
            Shopping shopping = enterIdentificationData.clickContinue();
            shopping.clickSubscriberBundlePrimaryOfferName(PRIMARY_OFFER1);
            SelectOffersForYourSubscriber selectOffersForYourSubscriber = shopping.clickSelectOfferInPopUpWindowExpectingSelectOffersForYourSubscriber();
            selectOffersForYourSubscriber.selectOffersForSubscriber(SUPPLEMENTARY_OFFER);
            MyBasket myBasket = selectOffersForYourSubscriber.clickContinueExpectingMyBasket();
            ServiceConnectionDetails serviceConnectionDetails = myBasket.clickFirstActionsIcon();
            serviceConnectionDetails.clickSetIMSIInventory(workSpace.subscriber);
            serviceConnectionDetails.clickOk();
            myBasket.addConsumerUserPersonOrdering();
            myBasket.clickAcceptTermsAndConditions();
            CheckoutReview checkoutReview = myBasket.clickCheckOut();
            CheckoutConfirmation checkoutConfirmation = checkoutReview.clickConfirm();
            String orderNumber = checkoutConfirmation.getOrderNumberFromPage();
            WorkSpace workSpaceCommon = checkoutConfirmation.clickOk();
            workSpace.setAccount(workSpace.account);
            workSpace.setPerson(workSpace.person);
            workSpace.setSubscriber(workSpace.subscriber);
            SearchRequests searchRequests = workSpaceCommon.clickRequests();
            SearchOrders searchOrders = searchRequests.clickSearchOrders();
            searchOrders.waitUntilOrderCompletedOrFailed(orderNumber);
            searchOrders.clickHomeMenu();
            IdentifyCustomer identifyCustomer = workSpace.gotoManageAccount();
            AccountDetails accountDetails = identifyCustomer.searchByPersonLastNameSinglePerson(workSpace.getPerson().getPersonLastNameProperty());

            SubscriberDetails subscriberDashboard = accountDetails.selectFirstSubscriberFromNavigationPanel();
            CustomerAcquisitionCustomerDataReview customerAcquisitionCustomerDataReview = subscriberDashboard.clickMigrateToPostpaidSubscriber();
            customerAcquisitionCustomerDataReview.clickContinue();
            shopping.clickSubscriberBundlePrimaryOfferName(PRIMARY_OFFER2);
            EnterYourSubscriptionDetails enterYourSubscriptionDetails = shopping.clickSelectOfferInPopUpWindowExpectingEnterYourSubscriptionDetails();
            enterYourSubscriptionDetails.clickContinue();
            selectOffersForYourSubscriber.clickContinueExpectingServiceConnectionDetails();
            serviceConnectionDetails.clickSetTVQualityInventory(workSpace.subscriber);
            SwapImpact swapImpact = serviceConnectionDetails.clickOkExpectingSwapImpact();
            swapImpact.clickOK();
            myBasket.clickAcceptTermsAndConditions();
            Common.assertTextOnPage(tool, PRIMARY_OFFER2);
            myBasket.clickCheckOut();
            checkoutReview.clickConfirm();
            checkoutConfirmation.clickOkExpectingSubscriberDashboard();
            subscriberDashboard.clickAccountIDFromNavigationPanel();
            RequestsForCustomer requestsForCustomer = accountDetails.clickViewRequestsForThisCustomer();
            requestsForCustomer.waitUntilFirstRequestCompletedOrFailed();
            requestsForCustomer.clickToSubscriberDashboard();
            Common.assertTextOnPage(tool, workSpace.subscriber.getSubscriberIMSIProperty());

            Common.assertTextOnPage(tool, workSpace.subscriber.getSubscriberTVQualityProperty());

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