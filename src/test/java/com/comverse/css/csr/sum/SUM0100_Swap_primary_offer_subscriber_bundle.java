package com.comverse.css.csr.sum;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.css.csr.*;
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

            EnterIdentificationData enterIdentificationData = workSpace.startNewConvergentResidentialCustomer();
            workSpace.account = enterIdentificationData.enterDefaultIdentificationData();
            workSpace.person = enterIdentificationData.getPerson();
            workSpace.subscriber = enterIdentificationData.getSubscriber();
            Shopping shopping = enterIdentificationData.clickContinue();
            shopping.clickSubscriberBundlePrimaryOfferName(po_DIYMonthlyPayPerView.getOfferName());
            MyBasket myBasket = shopping.clickSelectOfferInPopUpWindow();
            ServiceConnectionDetails serviceConnectionDetails = myBasket.clickFirstActionsIcon();
            serviceConnectionDetails.clickSetIMSIInventory(workSpace.subscriber);
            serviceConnectionDetails.clickOk();
            myBasket.addConsumerUserPersonOrdering();
            myBasket.clickAcceptTermsAndConditions();
            CheckoutReview checkoutReview = myBasket.clickCheckOut();
            CheckoutConfirmation checkoutConfirmation = checkoutReview.clickConfirm();
            String orderNumber = checkoutConfirmation.getOrderNumberFromPage();
            checkoutConfirmation.clickOk();
            workSpace.setAccount(workSpace.account);
            workSpace.setPerson(workSpace.person);
            workSpace.setSubscriber(workSpace.subscriber);
            SearchRequests searchRequests = workSpace.clickRequests();
            SearchOrders searchOrders = searchRequests.clickSearchOrders();
            searchOrders.waitUntilOrderCompletedOrFailedWithGetAccountID(orderNumber, workSpace.account);
            searchOrders.clickHomeMenu();
            IdentifyCustomer identifyCustomer = workSpace.gotoManageAccount();
            AccountDetails accountDetails = identifyCustomer.searchByPersonLastNameSinglePerson(workSpace.getPerson().getPersonLastNameProperty());

            SubscriberDetails subscriberDashboard = accountDetails.selectFirstSubscriberFromNavigationPanel();
            subscriberDashboard.clickChangePO_SBAndSO();
            shopping.clickSubscriberBundlePrimaryOfferName(sb_DIYWeek7_7Bundle.getOfferName());
            EnterYourSubscriptionDetails enterYourSubscriptionDetails = shopping.clickSelectOfferInPopUpWindowExpectingEnterYourSubscriptionDetails();
            SelectOffersForYourSubscriber selectOffersForYourSubscriber = enterYourSubscriptionDetails.clickContinue();
            ConfigureOffers configureOffers = selectOffersForYourSubscriber.clickContinue();
            SwapImpact swapImpact = configureOffers.clickContinueExpectingSwapImpact();
            swapImpact.clickOK();
            myBasket.clickAcceptTermsAndConditions();
            Common.assertTextOnPage(tool, sb_DIYWeek7_7Bundle.getOfferName());
            myBasket.clickCheckOut();
            checkoutReview.clickConfirm();
            checkoutConfirmation.clickOkExpectingSubscriberDashboard();
            subscriberDashboard.clickAccountIDFromNavigationPanel();
            RequestsForCustomer requestsForCustomer = accountDetails.clickViewRequestsForThisCustomer();

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
