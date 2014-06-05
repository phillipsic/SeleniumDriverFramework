package com.comverse.css.b2c.orco;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.b2c.*;
import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.css.data.PO.PO_ResidentialUltraPostpaid;
import com.comverse.data.apps.B2C;

public class ORCO0013_Capture_Billing_Account_Attributes extends CSSTest {
    private StringBuffer verificationErrors = new StringBuffer();

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new B2C();
    }

    @Test
    public void testORCO0013_Capture_Billing_Account_Attributes() throws Exception {

        try {
            PO_ResidentialUltraPostpaid po_ResidentialUltraPostpaid = new PO_ResidentialUltraPostpaid();
            launchCSSApplication();

            String uniqueTimeStamp = Common.generateTimeStamp();

            HomePage homePage = new HomePage(driver);
            homePage.clickShoppingLink();

            Shopping shopping = homePage.selectAccountSegmentAll();

            ChooseYourPrimaryOffer chooseYourPrimaryOffer = shopping.clickGSMMobileLink();

            EnterYourSubscriptionDetails enterYourSubscriptionDetails = chooseYourPrimaryOffer.selectPrimaryOfferByNameWithoutDevice(po_ResidentialUltraPostpaid.getOfferName());

            enterYourSubscriptionDetails.enterDefaultIdentityAddressPhoneEmail(uniqueTimeStamp);
            SelectOffersForYourSubscriber SelectOffersForYourSubscriber = enterYourSubscriptionDetails.clickOk();

            ConfigureOffers configureOffers = SelectOffersForYourSubscriber.clickContinue();
            ConfigureBalance configureBalance = configureOffers.clickContinueExpectingConfigureBalance();
            configureBalance.configureBalance(po_ResidentialUltraPostpaid.getBAL_GPRS_WAP_INTERNET().getBalanceName(), po_ResidentialUltraPostpaid.getBAL_GPRS_WAP_INTERNET()
                    .getBalanceValue());
            ChooseAccessories chooseAccessories = configureBalance.clickContinue();

            MyBasket myBasket = chooseAccessories.clickContinue();
            CheckoutRegister checkoutRegister = myBasket.clickCheckOut();
            SignUpUser signUpUser = checkoutRegister.selectSignMeUpAndClickContinue();
            CustomerDetails customerDetails = signUpUser.enterMandatoryFieldsOnlyAndClickSignMeUp(uniqueTimeStamp);
            CheckOutBillingAccountInformation checkOutBillingAccountInformation = customerDetails.clickOk();
            checkOutBillingAccountInformation.clickCheckRadioButton();
            Common.assertTextOnPage(driver, "Account Attributes");
            checkOutBillingAccountInformation.selectAccountAttributeLanguage("French (Standard)");
            BillingManagement billingManagement = checkOutBillingAccountInformation.clickContinueExpectingBillingManagement();
            CheckoutReview checkoutReview = billingManagement.clickContinue();

            CheckoutConfirmation checkoutConfirmation = checkoutReview.clickContinue();
            SearchOrders searchOrders = checkoutConfirmation.clickOk();
            searchOrders.clickRequests();

            searchOrders.waitUntilOrderCompletedOrFailed();

            searchOrders.clickDashbaord();

            Common.assertTextOnPage(driver, "Check");
            Common.assertTextOnPage(driver, "French (Standard)");

            // assertTrue(selenium.isTextPresent("Billing Account Currency: US Dollar"));

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