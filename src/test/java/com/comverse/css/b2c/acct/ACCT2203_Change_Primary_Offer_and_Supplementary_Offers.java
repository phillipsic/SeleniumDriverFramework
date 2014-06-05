package com.comverse.css.b2c.acct;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.b2c.*;
import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.css.data.PO.PO_ResidentialBasicPrepaid;
import com.comverse.css.data.PO.PO_ResidentialBasicPrepaidForSwap;
import com.comverse.css.data.SO.SO_2009MarchMadnessNews;
import com.comverse.css.data.SO.SO_2010WorldCupSoccerNews;
import com.comverse.data.apps.B2C;

public class ACCT2203_Change_Primary_Offer_and_Supplementary_Offers extends CSSTest {
    private StringBuffer verificationErrors = new StringBuffer();

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new B2C();
    }

    @Test
    public void testACCT2203_Change_Primary_Offer_and_Supplementary_Offers() throws Exception {
        try {
            PO_ResidentialBasicPrepaid po_ResidentialBasicPrepaid = new PO_ResidentialBasicPrepaid();
            PO_ResidentialBasicPrepaidForSwap po_ResidentialBasicPrepaidForSwap = new PO_ResidentialBasicPrepaidForSwap();
            SO_2010WorldCupSoccerNews so_2010WorldCupSoccerNews = new SO_2010WorldCupSoccerNews();
            SO_2009MarchMadnessNews so_2009MarchMadnessNews = new SO_2009MarchMadnessNews();
            launchCSSApplication();
            String uniqueTimeStamp = Common.generateTimeStamp();

            HomePage homePage = new HomePage(driver);
            homePage.clickShoppingLink();
            Shopping shopping = homePage.selectAccountSegmentAll();

            ChooseYourPrimaryOffer chooseYourPrimaryOffer = shopping.clickGSMMobileLink();
            EnterYourSubscriptionDetails enterYourSubscriptionDetails = chooseYourPrimaryOffer.selectPrimaryOfferByNameWithoutDevice(po_ResidentialBasicPrepaid.getOfferName());
            enterYourSubscriptionDetails.enterDefaultIdentityAddressPhoneEmail(uniqueTimeStamp);

            SelectOffersForYourSubscriber selectOffersForYourSubscriber = enterYourSubscriptionDetails.clickOk();
            ConfigureOffers configureOffers = selectOffersForYourSubscriber.clickContinue();
            ChooseAccessories chooseAccessories = configureOffers.clickContinue();

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

            Common.assertTextOnPage(driver, po_ResidentialBasicPrepaid.getOfferName());

            chooseYourPrimaryOffer = subscriberDetail.clickChangeOffer();
            enterYourSubscriptionDetails = chooseYourPrimaryOffer.selectPrimaryOfferByNameWithoutDevice(po_ResidentialBasicPrepaidForSwap.getOfferName());
            selectOffersForYourSubscriber = enterYourSubscriptionDetails.clickOk();
            selectOffersForYourSubscriber.selectOffersForSubscriber(so_2010WorldCupSoccerNews.getOfferName(), so_2009MarchMadnessNews.getOfferName());

            configureOffers = selectOffersForYourSubscriber.clickContinue();
            SwapImpact swapImpact = configureOffers.clickContinueExpectingSwapImpact();
            ConfigureBalance configureBalance = swapImpact.clickOkExpectingConfigureBalance();
            configureBalance.configureBalance("Voice-Anytime", "20");
            configureBalance.configureBalance("CORE BALANCE", "120");
            myBasket = configureBalance.clickContinueExpectingMyBasket();
            checkOutBillingAccountInformation = myBasket.clickCheckOutExpectingCheckOutBillingAccountInformation();
            checkOutBillingAccountInformation.enterAddressLine1("Address Line 1");
            checkOutBillingAccountInformation.enterZipPostalCode("123456");
            checkOutBillingAccountInformation.enterCity("Vegas");
            checkOutBillingAccountInformation.enterState("Texas");
            checkoutReview = checkOutBillingAccountInformation.clickContinue();
            checkoutConfirmation = checkoutReview.clickContinue();
            String orderNumber1 = checkoutConfirmation.getOrderNumberFromPage();
            shopping = checkoutConfirmation.clickOkExpectingShopping();
            subscriberDetail = shopping.clickMyAccount();
            searchOrders = subscriberDetail.clickMyOrdersTab();
            searchOrders.waitUntilOrderCompletedOrFailedWithOrderNumber(orderNumber1);
            subscriberDetail = searchOrders.clickDashboard();

            Common.assertTextOnPage(driver, po_ResidentialBasicPrepaidForSwap.getOfferName());
            Common.assertTextOnPage(driver, so_2010WorldCupSoccerNews.getOfferName());
            Common.assertTextOnPage(driver, so_2009MarchMadnessNews.getOfferName());

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
