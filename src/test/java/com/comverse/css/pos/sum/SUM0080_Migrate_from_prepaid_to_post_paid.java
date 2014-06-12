package com.comverse.css.pos.sum;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.css.data.PO.PO_DIYeTVVideoGaming;
import com.comverse.css.data.SO.SO_DIYeCountdownExtra;
import com.comverse.css.pos.*;
import com.comverse.data.apps.POS;
import com.comverse.data.users.TelcoRetailerAdmin;

public class SUM0080_Migrate_from_prepaid_to_post_paid extends CSSTest {
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
    public void testSUM0080_Migrate_from_prepaid_to_post_paid() throws Exception {

        try {
            PO_DIYeTVVideoGaming po_DIYeTVVideoGaming = new PO_DIYeTVVideoGaming();
            SO_DIYeCountdownExtra so_DIYeCountDownExtra = new SO_DIYeCountdownExtra();
            String SUBSCRIBER_BUNDLE = "DIY - Monthly PayPerView ( with cCi)";
            launchCSSApplication();

            MyShapeChannel loginPage = new MyShapeChannel(tool, test, user);
            WorkSpace workSpace = loginPage.loginToPOS(user);

            EnterIdentificationData enterIdentificationData = workSpace.startNewConvergentResidentialCustomer();
            workSpace.account = enterIdentificationData.enterDefaultIdentificationData();
            workSpace.person = enterIdentificationData.getPerson();
            workSpace.subscriber = enterIdentificationData.getSubscriber();
            Shopping shopping = enterIdentificationData.clickContinue();
            shopping.clickSubscriberBundlePrimaryOfferName(po_DIYeTVVideoGaming.getOfferName());
            SelectOffersForYourSubscriber selectOffersForYourSubscriber = shopping.clickSelectOfferInPopUpWindowExpectingSelectOffersForYourSubscriber();
            selectOffersForYourSubscriber.selectOffersForSubscriber(so_DIYeCountDownExtra.getOfferName());
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
            shopping.clickSubscriberBundlePrimaryOfferName(SUBSCRIBER_BUNDLE);
            EnterYourSubscriptionDetails enterYourSubscriptionDetails = shopping.clickSelectOfferInPopUpWindowExpectingEnterYourSubscriptionDetails();
            enterYourSubscriptionDetails.clickContinue();
            SwapImpact swapImpact = selectOffersForYourSubscriber.clickContinueExpectingSwapImpact();
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
            Common.assertTextOnPage(tool, so_DIYeCountDownExtra.getOfferName());

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