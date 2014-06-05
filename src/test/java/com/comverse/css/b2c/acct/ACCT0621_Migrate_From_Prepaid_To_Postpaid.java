package com.comverse.css.b2c.acct;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.b2c.*;
import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.css.data.PO.PO_DIYRechargesPromotions;
import com.comverse.css.data.SB.SB_DIYWeek7_7Bundle;
import com.comverse.data.apps.B2C;

public class ACCT0621_Migrate_From_Prepaid_To_Postpaid extends CSSTest {
    private StringBuffer verificationErrors = new StringBuffer();

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new B2C();
    }

    @Test
    public void testACCT0621_Migrate_From_Prepaid_To_Postpaid() throws Exception {
        try {
            PO_DIYRechargesPromotions po_DIYRechargesPromotions = new PO_DIYRechargesPromotions();
            SB_DIYWeek7_7Bundle sb_DIYWeek7_7Bundle = new SB_DIYWeek7_7Bundle();
            launchCSSApplication();
            String uniqueTimeStamp = Common.generateTimeStamp();

            HomePage homePage = new HomePage(driver);
            homePage.clickShoppingLink();
            Shopping shopping = homePage.selectAccountSegmentAll();

            ChooseYourPrimaryOffer chooseYourPrimaryOffer = shopping.clickNetworkTVLink();
            EnterYourSubscriptionDetails enterYourSubscriptionDetails = chooseYourPrimaryOffer.selectPrimaryOfferByNameWithoutDevice(po_DIYRechargesPromotions.getOfferName());
            enterYourSubscriptionDetails.enterDefaultIdentityAddressPhoneEmail(uniqueTimeStamp);

            SelectOffersForYourSubscriber selectOffersForYourSubscriber = enterYourSubscriptionDetails.clickOk();
            ChooseAccessories chooseAccessories = selectOffersForYourSubscriber.clickContinueExpectingChooseAccessories();

            MyBasket myBasket = chooseAccessories.clickContinue();

            CheckoutRegister checkoutRegister = myBasket.clickCheckOut();

            checkoutRegister.selectSignMeUp();
            SignUpUser signUpUser = checkoutRegister.clickContinue();
            CustomerDetails customerDetails = signUpUser.enterMandatoryFieldsOnlyAndClickSignMeUp(uniqueTimeStamp);
            CheckOutBillingAccountInformation checkOutBillingAccountInformation = customerDetails.clickOk();
            CheckoutReview checkoutReview = checkOutBillingAccountInformation.clickContinue();
            CheckoutConfirmation checkoutConfirmation = checkoutReview.clickContinue();
            String orderNumber = checkoutConfirmation.getOrderNumberFromPage();
            SearchOrders searchOrders = checkoutConfirmation.clickOk();
            searchOrders.waitUntilOrderCompletedOrFailedWithOrderNumber(orderNumber);
            SubscriberDetail subscriberDetail = searchOrders.clickDashbaord();

            Common.assertTextOnPage(driver, po_DIYRechargesPromotions.getOfferName());

            chooseYourPrimaryOffer = subscriberDetail.clickMigrateToPostpaidSubscriber();
            enterYourSubscriptionDetails = chooseYourPrimaryOffer.selectSubscriberBundleByNameWithoutDevice(sb_DIYWeek7_7Bundle.getOfferName(), sb_DIYWeek7_7Bundle
                    .getPO_DIYWeeklySubscriptionPrimeOffering().getOfferName());
            selectOffersForYourSubscriber = enterYourSubscriptionDetails.clickOk();
            ConfigureOffers configureOffers = selectOffersForYourSubscriber.clickContinue();
            SwapImpact swapImpact = configureOffers.clickContinueExpectingSwapImpact();
            myBasket = swapImpact.clickOk();
            TermsAndConditions termsAndConditions = myBasket.clickCheckOutExpectingTermsAndConditions();
            checkOutBillingAccountInformation = termsAndConditions.clickOkExpectingBilingAccountInformation();
            checkOutBillingAccountInformation.clickCheckRadioButton();
            checkOutBillingAccountInformation.enterAddressLine1("Address Line 1");
            checkOutBillingAccountInformation.enterZipPostalCode("123456");
            checkOutBillingAccountInformation.enterCity("Vegas");
            checkOutBillingAccountInformation.enterState("Texas");
            BillingManagement billingManagement = checkOutBillingAccountInformation.clickContinueExpectingBillingManagement();
            checkoutReview = billingManagement.clickContinue();
            checkoutConfirmation = checkoutReview.clickContinue();
            String orderNumber1 = checkoutConfirmation.getOrderNumberFromPage();
            shopping = checkoutConfirmation.clickOkExpectingShopping();
            subscriberDetail = shopping.clickMyAccount();
            searchOrders = subscriberDetail.clickMyOrdersTab();
            searchOrders.waitUntilOrderCompletedOrFailedWithOrderNumber(orderNumber1);
            subscriberDetail = searchOrders.clickDashboard();

            Common.assertTextOnPage(driver, sb_DIYWeek7_7Bundle.getOfferName());

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
