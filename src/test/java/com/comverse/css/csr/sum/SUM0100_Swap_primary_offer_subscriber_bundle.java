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
import com.comverse.css.data.PO.PO_DIYMonthlyPayPerView;
import com.comverse.css.data.SB.SB_DIYWeek7_7Bundle;
import com.comverse.data.apps.CSR;
import com.comverse.data.users.CSRAdmin;

public class SUM0100_Swap_primary_offer_subscriber_bundle extends CSSTest {
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    @Override
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new CSR();
        user = new CSRAdmin();
    }

    @Test
    public void testSUM0100_Swap_primary_offer_subscriber_bundle() throws Exception {
        try {
            PO_DIYMonthlyPayPerView po_DIYMonthlyPayPerView = new PO_DIYMonthlyPayPerView();
            SB_DIYWeek7_7Bundle sb_DIYWeek7_7Bundle = new SB_DIYWeek7_7Bundle();
            launchCSSApplicationAndSSOLogin();

            WorkSpace workSpace = new WorkSpace(tool, test, user);

            EnterIdentificationDataCommon enterIdentificationData = workSpace.startNewConvergentResidentialCustomer();
            workSpace.account = enterIdentificationData.enterDefaultIdentificationData();
            workSpace.person = enterIdentificationData.getPerson();
            workSpace.subscriber = enterIdentificationData.getSubscriber();
            ShoppingCommon shopping = enterIdentificationData.clickContinue();
            shopping.clickSubscriberBundlePrimaryOfferName(po_DIYMonthlyPayPerView.getOfferName());
            MyBasketCommon myBasket = shopping.clickSelectOfferInPopUpWindow();
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
            subscriberDashboard.clickChangePO_SBAndSO();
            shopping.clickSubscriberBundlePrimaryOfferName(sb_DIYWeek7_7Bundle.getOfferName());
            EnterYourSubscriptionDetailsCommon enterYourSubscriptionDetails = shopping.clickSelectOfferInPopUpWindowExpectingEnterYourSubscriptionDetails();
            SelectOffersForYourSubscriberCommon selectOffersForYourSubscriber = enterYourSubscriptionDetails.clickContinue();
            ConfigureOffersCommon configureOffers = selectOffersForYourSubscriber.clickContinue();
            SwapImpactCommon swapImpact = configureOffers.clickContinueExpectingSwapImpact();
            swapImpact.clickOK();
            myBasket.clickAcceptTermsAndConditions();
            Common.assertTextOnPage(tool, sb_DIYWeek7_7Bundle.getOfferName());
            myBasket.clickCheckOut();
            checkoutReview.clickConfirm();
            checkoutConfirmation.clickOkExpectingSubscriberDashboard();
            subscriberDashboard.clickAccountIDFromNavigationPanel();
            RequestsForCustomerCommon requestsForCustomer = accountDetails.clickViewRequestsForThisCustomer();

            requestsForCustomer.waitUntilFirstRequestCompletedOrFailed();

            requestsForCustomer.clickToSubscriberDashboard();
            Common.assertTextOnPage(tool, sb_DIYWeek7_7Bundle.getOfferName());

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
