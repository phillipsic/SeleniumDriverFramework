package com.comverse.css.csr.sum;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.css.csr.*;
import com.comverse.css.data.PO.PO_DIYeTVVideoGaming;
import com.comverse.css.data.SB.SB_DIYMonthlyPayPerView;
import com.comverse.css.data.SO.SO_DIYeCountdownExtra;
import com.comverse.data.apps.CSR;
import com.comverse.data.users.CSRUser;

public class SUM0080_Migrate_from_prepaid_to_post_paid extends CSSTest {
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
    public void testSUM0080_Migrate_from_prepaid_to_post_paid() throws Exception {
        try {
            PO_DIYeTVVideoGaming po_DIYeTVVideoGaming = new PO_DIYeTVVideoGaming();
            SO_DIYeCountdownExtra so_DIYeCountdownExtra = new SO_DIYeCountdownExtra();
            SB_DIYMonthlyPayPerView sb_DIYMonthlyPayPerView = new SB_DIYMonthlyPayPerView();
            launchCSSApplicationAndSSOLogin();

            WorkSpace workSpace = new WorkSpace(tool, test, user);

            EnterIdentificationData enterIdentificationData = workSpace.startNewConvergentResidentialCustomer();
            enterIdentificationData.enterDefaultIdentificationData();
            Shopping shopping = enterIdentificationData.clickContinue();
            shopping.clickSubscriberBundlePrimaryOfferName(po_DIYeTVVideoGaming.getOfferName());
            SelectOffersForYourSubscriber selectOffersForYourSubscriber = shopping.clickSelectOfferInPopUpWindowExpectingSelectOffersForYourSubscriber();
            selectOffersForYourSubscriber.selectOffersForSubscriber(so_DIYeCountdownExtra.getOfferName());
            MyBasket myBasket = selectOffersForYourSubscriber.clickContinueExpectingMyBasket();
            ServiceConnectionDetails serviceConnectionDetails = myBasket.clickFirstActionsIcon();
            serviceConnectionDetails.clickSetIMSIInventory(enterIdentificationData.getSubscriber());
            serviceConnectionDetails.clickOk();
            myBasket.addConsumerUserPersonOrdering();
            myBasket.clickAcceptTermsAndConditions();
            CheckoutReview checkoutReview = myBasket.clickCheckOut();
            CheckoutConfirmation checkoutConfirmation = checkoutReview.clickConfirm();
            String orderNumber = checkoutConfirmation.getOrderNumberFromPage();
            workSpace = checkoutConfirmation.clickOk();
            SearchRequests searchRequests = workSpace.clickRequests();
            SearchOrders searchOrders = searchRequests.clickSearchOrders();

            searchOrders.waitUntilOrderCompletedOrFailed(orderNumber);

            searchOrders.clickHomeMenu();
            IdentifyCustomer identifyCustomer = workSpace.gotoManageAccount();
            AccountDetails accountDetails = identifyCustomer.searchByPersonLastNameSinglePerson(enterIdentificationData.getPerson().getPersonLastNameProperty());

            SubscriberDetails subscriberDashboard = accountDetails.selectFirstSubscriberFromNavigationPanel();
            CustomerAcquisitionCustomerDataReview customerAcquisitionCustomerDataReview = subscriberDashboard.clickMigrateToPostpaidSubscriber();
            customerAcquisitionCustomerDataReview.clickContinue();
            shopping.clickSubscriberBundlePrimaryOfferName(sb_DIYMonthlyPayPerView.getOfferName());
            EnterYourSubscriptionDetails enterYourSubscriptionDetails = shopping.clickSelectOfferInPopUpWindowExpectingEnterYourSubscriptionDetails();
            enterYourSubscriptionDetails.clickContinue();
            SwapImpact swapImpact = selectOffersForYourSubscriber.clickContinueExpectingSwapImpact();
            swapImpact.clickOK();
            myBasket.clickAcceptTermsAndConditions();
            Common.assertTextOnPage(tool, sb_DIYMonthlyPayPerView.getOfferName());
            myBasket.clickCheckOut();
            checkoutReview.clickConfirm();
            checkoutConfirmation.clickOkExpectingSubscriberDashboard();
            subscriberDashboard.clickAccountIDFromNavigationPanel();
            RequestsForCustomer requestsForCustomer = accountDetails.clickViewRequestsForThisCustomer();
            test.setBugId("CBS00155901");
            requestsForCustomer.waitUntilFirstRequestCompletedOrFailed();
            test.setBugId("NoBug");
            requestsForCustomer.clickToSubscriberDashboard();
            Common.assertTextOnPage(tool, sb_DIYMonthlyPayPerView.getOfferName());
            Common.assertTextOnPage(tool, so_DIYeCountdownExtra.getOfferName());

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
