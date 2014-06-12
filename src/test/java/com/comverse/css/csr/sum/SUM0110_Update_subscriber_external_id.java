package com.comverse.css.csr.sum;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.css.commonpages.*;
import com.comverse.css.csr.WorkSpace;
import com.comverse.css.data.PO.PO_DIYTripleChoiceDeviceTVPlayOffer;
import com.comverse.css.data.PO.PO_DIYeTVVideoGaming;
import com.comverse.css.data.SO.SO_DIYeCountdownExtra;
import com.comverse.data.apps.CSR;
import com.comverse.data.users.CSRUser;

public class SUM0110_Update_subscriber_external_id extends CSSTest {
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    @Override
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new CSR();
        user = new CSRUser();
    }

    @Test
    public void testSUM0110_Update_subscriber_external_id() throws Exception {
        try {
            PO_DIYeTVVideoGaming po_DIYeTVVideoGaming = new PO_DIYeTVVideoGaming();
            SO_DIYeCountdownExtra so_DIYeCountdownExtra = new SO_DIYeCountdownExtra();
            PO_DIYTripleChoiceDeviceTVPlayOffer po_DIYTripleChoiceDeviceTVPlayOffer = new PO_DIYTripleChoiceDeviceTVPlayOffer();
            launchCSSApplicationAndSSOLogin();

            WorkSpace workSpace = new WorkSpace(tool, test, user);

            EnterIdentificationDataCommon enterIdentificationData = workSpace.startNewConvergentResidentialCustomer();
            workSpace.account = enterIdentificationData.enterDefaultIdentificationData();
            workSpace.person = enterIdentificationData.getPerson();
            workSpace.subscriber = enterIdentificationData.getSubscriber();
            ShoppingCommon shopping = enterIdentificationData.clickContinue();
            shopping.clickSubscriberBundlePrimaryOfferName(po_DIYeTVVideoGaming.getOfferName());
            SelectOffersForYourSubscriberCommon selectOffersForYourSubscriber = shopping.clickSelectOfferInPopUpWindowExpectingSelectOffersForYourSubscriber();
            selectOffersForYourSubscriber.selectOffersForSubscriber(so_DIYeCountdownExtra.getOfferName());
            MyBasketCommon myBasket = selectOffersForYourSubscriber.clickContinueExpectingMyBasket();
            ServiceConnectionDetailsCommon serviceConnectionDetails = myBasket.clickFirstActionsIcon();
            serviceConnectionDetails.clickSetIMSIInventory(workSpace.subscriber);
            serviceConnectionDetails.clickOk();
            myBasket.addConsumerUserPersonOrdering();
            myBasket.clickAcceptTermsAndConditions();
            CheckoutReviewCommon checkoutReview = myBasket.clickCheckOut();
            CheckoutConfirmationCommon checkoutConfirmation = checkoutReview.clickConfirm();
            String orderNumber = checkoutConfirmation.getOrderNumberFromPage();
            WorkSpaceCommon workSpaceCommon = checkoutConfirmation.clickOk();
            workSpace.setAccount(workSpace.account);
            workSpace.setPerson(workSpace.person);
            workSpace.setSubscriber(workSpace.subscriber);
            SearchRequestsCommon searchRequests = workSpaceCommon.clickRequests();
            SearchOrdersCommon searchOrders = searchRequests.clickSearchOrders();
            searchOrders.waitUntilOrderCompletedOrFailedWithGetAccountID(orderNumber, workSpace.account);
            searchOrders.clickHomeMenu();
            IdentifyCustomerCommon identifyCustomer = workSpace.gotoManageAccount();
            AccountDetailsCommon accountDetails = identifyCustomer.searchByPersonLastNameSinglePerson(workSpace.getPerson().getPersonLastNameProperty());

            SubscriberDetailsCommon subscriberDashboard = accountDetails.selectFirstSubscriberFromNavigationPanel();
            CustomerAcquisitionCustomerDataReviewCommon customerAcquisitionCustomerDataReview = subscriberDashboard.clickMigrateToPostpaidSubscriber();
            customerAcquisitionCustomerDataReview.clickContinue();
            shopping.clickSubscriberBundlePrimaryOfferName(po_DIYTripleChoiceDeviceTVPlayOffer.getOfferName());
            EnterYourSubscriptionDetailsCommon enterYourSubscriptionDetails = shopping.clickSelectOfferInPopUpWindowExpectingEnterYourSubscriptionDetails();
            enterYourSubscriptionDetails.clickContinue();
            selectOffersForYourSubscriber.clickContinueExpectingServiceConnectionDetails();
            serviceConnectionDetails.clickSetTVQualityInventory(workSpace.subscriber);
            SwapImpactCommon swapImpact = serviceConnectionDetails.clickOkExpectingSwapImpact();
            swapImpact.clickOK();
            myBasket.clickAcceptTermsAndConditions();
            Common.assertTextOnPage(tool, po_DIYTripleChoiceDeviceTVPlayOffer.getOfferName());
            myBasket.clickCheckOut();
            checkoutReview.clickConfirm();
            checkoutConfirmation.clickOkExpectingSubscriberDashboard();
            subscriberDashboard.clickAccountIDFromNavigationPanel();
            RequestsForCustomerCommon requestsForCustomer = accountDetails.clickViewRequestsForThisCustomer();
            requestsForCustomer.waitUntilFirstRequestCompletedOrFailed();
            requestsForCustomer.clickToSubscriberDashboard();
            Common.assertTextOnPage(tool, workSpace.subscriber.getSubscriberIMSIProperty());
            test.setBugId("CBS00154277");
            Common.assertTextOnPage(tool, workSpace.subscriber.getSubscriberTVQualityProperty());
            test.setBugId("NoBug");

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
