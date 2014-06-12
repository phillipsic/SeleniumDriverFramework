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
import com.comverse.css.data.SO.SO_2010SuperBowlNews;
import com.comverse.css.data.SO.SO_2010WorldCupSoccerNews;
import com.comverse.data.apps.CSR;
import com.comverse.data.users.CSRAdmin;

public class SUM0170_Reconfigure_subscriber_selective_offers extends CSSTest {
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
    public void testSUM0170_Reconfigure_subscriber_selective_offers() throws Exception {
        try {
            SO_2010WorldCupSoccerNews so_2010WorldCupSoccerNews = new SO_2010WorldCupSoccerNews();
            SO_2010SuperBowlNews so_2010SuperBowlNews = new SO_2010SuperBowlNews();
            launchCSSApplicationAndSSOLogin();

            WorkSpace workSpace = new WorkSpace(tool, test, user);

            workSpace.doResitdentialNCAResidentialBasicPrepaidBundleCSR();

            IdentifyCustomerCommon identifyCustomer = workSpace.gotoManageAccount();

            AccountDetailsCommon accountDetails = identifyCustomer.searchByPersonLastNameSinglePerson(workSpace.getPerson().getPersonLastNameProperty());

            SubscriberDetailsCommon subscriberDashboard = accountDetails.selectFirstSubscriberFromNavigationPanel();
            SelectOffersForYourSubscriberCommon selectOffersForYourSubscriber = subscriberDashboard.clickReconfigureSupplementaryOffers();
            selectOffersForYourSubscriber.selectOffersForSubscriber(so_2010WorldCupSoccerNews.getOfferName(), so_2010SuperBowlNews.getOfferName());
            ConfigureOffersCommon configureOffers = selectOffersForYourSubscriber.clickContinue();
            MyBasketCommon myBasket = configureOffers.clickContinueExpectingMyBasket();
            Common.assertTextOnPage(tool, so_2010WorldCupSoccerNews.getOfferName());
            Common.assertTextOnPage(tool, so_2010SuperBowlNews.getOfferName());
            CheckoutReviewCommon checkoutReview = myBasket.clickCheckOut();
            CheckoutConfirmationCommon checkoutConfirmation = checkoutReview.clickConfirm();
            checkoutConfirmation.clickOkExpectingSubscriberDashboard();
            subscriberDashboard.clickAccountIDFromNavigationPanel();
            RequestsForCustomerCommon requestsForCustomer = accountDetails.clickViewRequestsForThisCustomer();
            requestsForCustomer.waitUntilFirstRequestCompletedOrFailed();
            requestsForCustomer.clickToSubscriberDashboard();
            Common.assertTextOnPage(tool, so_2010WorldCupSoccerNews.getOfferName());
            Common.assertTextOnPage(tool, so_2010SuperBowlNews.getOfferName());

            subscriberDashboard.clickReconfigureSupplementaryOffers();
            // Unselect the SO
            selectOffersForYourSubscriber.selectOffersForSubscriber(so_2010WorldCupSoccerNews.getOfferName());
            selectOffersForYourSubscriber.clickContinueExpectingMyBasket();
            Common.assertTextOnPage(tool, so_2010WorldCupSoccerNews.getOfferName());
            myBasket.clickCheckOut();
            checkoutReview.clickConfirm();
            checkoutConfirmation.clickOkExpectingSubscriberDashboard();
            subscriberDashboard.clickAccountIDFromNavigationPanel();
            accountDetails.clickViewRequestsForThisCustomer();
            requestsForCustomer.waitUntilFirstRequestCompletedOrFailed();
            requestsForCustomer.clickToSubscriberDashboard();
            Common.assertTextNotOnPage(tool, so_2010WorldCupSoccerNews.getOfferName());
            Common.assertTextOnPage(tool, so_2010SuperBowlNews.getOfferName());

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
