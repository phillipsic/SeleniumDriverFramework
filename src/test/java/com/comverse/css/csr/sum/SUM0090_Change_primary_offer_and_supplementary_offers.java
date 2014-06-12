package com.comverse.css.csr.sum;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.css.csr.*;
import com.comverse.css.data.PO.PO_ResidentialBasicPrepaidForSwap;
import com.comverse.css.data.SO.SO_2009MarchMadnessNews;
import com.comverse.css.data.SO.SO_2010WorldCupSoccerNews;
import com.comverse.data.apps.CSR;
import com.comverse.data.users.CSRUser;

public class SUM0090_Change_primary_offer_and_supplementary_offers extends CSSTest {
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
    public void testSUM0090_Change_primary_offer_and_supplementary_offers() throws Exception {
        try {
            PO_ResidentialBasicPrepaidForSwap po_ResidentialBasicPrepaidForSwap = new PO_ResidentialBasicPrepaidForSwap();
            SO_2010WorldCupSoccerNews so_2010WorldCupSoccerNews = new SO_2010WorldCupSoccerNews();
            SO_2009MarchMadnessNews so_2009MarchMadnessNews = new SO_2009MarchMadnessNews();
            launchCSSApplicationAndSSOLogin();

            WorkSpace workSpace = new WorkSpace(tool, test, user);

            workSpace.doResitdentialNCAResidentialBasicPrepaidWithSOCSR(so_2010WorldCupSoccerNews.getOfferName());

            IdentifyCustomer identifyCustomer = workSpace.gotoManageAccount();

            AccountDetails accountDetails = identifyCustomer.searchByPersonLastNameSinglePerson(workSpace.getPerson().getPersonLastNameProperty());

            SubscriberDetails subscriberDashboard = accountDetails.selectFirstSubscriberFromNavigationPanel();
            Shopping shopping = subscriberDashboard.clickChangePO_SBAndSO();
            shopping.clickSubscriberBundlePrimaryOfferName(po_ResidentialBasicPrepaidForSwap.getOfferName());
            EnterYourSubscriptionDetails enterYourSubscriptionDetails = shopping.clickSelectOfferInPopUpWindowExpectingEnterYourSubscriptionDetails();
            SelectOffersForYourSubscriber selectOffersForYourSubscriber = enterYourSubscriptionDetails.clickContinue();
            test.setBugId("CBS00159871");
            selectOffersForYourSubscriber.selectOffersForSubscriber(so_2010WorldCupSoccerNews.getOfferName(), so_2009MarchMadnessNews.getOfferName());
            test.setBugId("NoBug");
            ConfigureOffers configureOffers = selectOffersForYourSubscriber.clickContinue();
            SwapImpact swapImpact = configureOffers.clickContinueExpectingSwapImpact();
            // MyBasketCommon myBasket = swapImpact.clickOK();
            ConfigureBalance configureBalance = swapImpact.clickOKExpectingConfigureBalance();
            configureBalance.setSpendingLimit("CORE BALANCE", "120");
            configureBalance.setSpendingLimit("Voice-Anytime", "20");
            MyBasket myBasket = configureBalance.clickContinueExpectingMyBasket();
            Common.assertTextOnPage(tool, po_ResidentialBasicPrepaidForSwap.getOfferName());
            Common.assertTextOnPage(tool, so_2009MarchMadnessNews.getOfferName());
            CheckoutReview checkoutReview = myBasket.clickCheckOut();
            CheckoutConfirmation checkoutConfirmation = checkoutReview.clickConfirm();
            checkoutConfirmation.clickOkExpectingSubscriberDashboard();
            subscriberDashboard.clickAccountIDFromNavigationPanel();
            RequestsForCustomer requestsForCustomer = accountDetails.clickViewRequestsForThisCustomer();
            test.setBugId("CBS00155901");
            requestsForCustomer.waitUntilFirstRequestCompletedOrFailed();
            test.setBugId("NoBug");
            requestsForCustomer.clickToSubscriberDashboard();
            Common.assertTextOnPage(tool, po_ResidentialBasicPrepaidForSwap.getOfferName());
            Common.assertTextNotOnPage(tool, so_2010WorldCupSoccerNews.getOfferName());
            Common.assertTextOnPage(tool, so_2009MarchMadnessNews.getOfferName());

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
