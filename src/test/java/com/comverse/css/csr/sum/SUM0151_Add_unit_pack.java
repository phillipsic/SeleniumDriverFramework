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
import com.comverse.css.data.SO.UNITPACK_UnitsPackage500;
import com.comverse.data.apps.CSR;
import com.comverse.data.users.CSRAdmin;

public class SUM0151_Add_unit_pack extends CSSTest {
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
    public void testSUM0151_Add_unit_pack() throws Exception {
        try {
            UNITPACK_UnitsPackage500 unitpack_UnitsPackage500 = new UNITPACK_UnitsPackage500();
            launchCSSApplicationAndSSOLogin();

            WorkSpace workSpace = new WorkSpace(tool, test, user);

            workSpace.doResitdentialNCAResidentialUltraPostpaidCSR();

            IdentifyCustomerCommon identifyCustomer = workSpace.gotoManageAccount();

            AccountDetailsCommon accountDetails = identifyCustomer.searchByPersonLastNameSinglePerson(workSpace.getPerson().getPersonLastNameProperty());

            SubscriberDetailsCommon subscriberDashboard = accountDetails.selectFirstSubscriberFromNavigationPanel();
            SelectOffersForYourSubscriberCommon selectOffersForYourSubscriber = subscriberDashboard.clickSubscribeNewOffers();

            selectOffersForYourSubscriber.selectOffersForSubscriber(unitpack_UnitsPackage500.getOfferName());
            MyBasketCommon myBasket = selectOffersForYourSubscriber.clickContinueExpectingMyBasket();
            Common.assertTextOnPage(tool, unitpack_UnitsPackage500.getOfferName());
            CheckoutReviewCommon checkoutReview = myBasket.clickCheckOut();
            CheckoutConfirmationCommon checkoutConfirmation = checkoutReview.clickConfirm();
            checkoutConfirmation.clickOkExpectingSubscriberDashboard();
            subscriberDashboard.clickAccountIDFromNavigationPanel();
            RequestsForCustomerCommon requestsForCustomer = accountDetails.clickViewRequestsForThisCustomer();
            requestsForCustomer.waitUntilFirstRequestCompletedOrFailed();
            requestsForCustomer.clickToSubscriberDashboard();

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
