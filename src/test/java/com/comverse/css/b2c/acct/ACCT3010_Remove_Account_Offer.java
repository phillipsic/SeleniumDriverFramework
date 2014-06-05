package com.comverse.css.b2c.acct;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.b2c.*;
import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.css.data.AO.AO_ResidentialSNRegionAccountOffer;
import com.comverse.css.data.PO.PO_ResidentialBasicPrepaid;
import com.comverse.data.apps.B2C;

public class ACCT3010_Remove_Account_Offer extends CSSTest {
    private StringBuffer verificationErrors = new StringBuffer();

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new B2C();
    }

    @Test
    public void testACCT3010_Remove_Account_Offer() throws Exception {
        try {
            PO_ResidentialBasicPrepaid po_ResidentialBasicPrepaid = new PO_ResidentialBasicPrepaid();
            AO_ResidentialSNRegionAccountOffer ao_ResidentialSNRegionAccountOffer = new AO_ResidentialSNRegionAccountOffer();
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
            SelectOffersForYourAccount selectOffersForYourAccount = subscriberDetail.clickSubscribeToNewOffer();
            selectOffersForYourAccount.selectOffersForAccount(ao_ResidentialSNRegionAccountOffer.getOfferName());
            AddAccountOffers addAccountOffers = selectOffersForYourAccount.clickContinueToAddAO();
            String addAO_OrderNumber = addAccountOffers.getAOOrderNumberFromPage();
            subscriberDetail = addAccountOffers.clickOk();
            searchOrders = subscriberDetail.clickMyOrdersTab();
            searchOrders.waitUntilOrderCompletedOrFailedWithOrderNumber(addAO_OrderNumber);
            subscriberDetail = searchOrders.clickDashboard();

            Common.assertTextOnPage(driver, ao_ResidentialSNRegionAccountOffer.getOfferName());

            RemoveOffer removeOffer = subscriberDetail.clickRemoveAO(ao_ResidentialSNRegionAccountOffer.getOfferName());
            OfferCancellation offerCancellation = removeOffer.ClickYes();
            String removeAO_OrderNumber = offerCancellation.getOrderNumberFromPage();
            subscriberDetail = offerCancellation.ClickOk();
            searchOrders = subscriberDetail.clickMyOrdersTab();
            searchOrders.waitUntilOrderCompletedOrFailedWithOrderNumber(removeAO_OrderNumber);
            subscriberDetail = searchOrders.clickDashboard();

            Common.assertTextNotOnPage(driver, ao_ResidentialSNRegionAccountOffer.getOfferName());

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
