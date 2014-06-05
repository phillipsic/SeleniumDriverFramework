package com.comverse.css.b2c.orco;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.b2c.*;
import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.css.data.PO.PO_ResidentialPostpaidwithOptionalEmail;
import com.comverse.css.data.PO.PO_ResidentialUltraPostpaid;
import com.comverse.data.apps.B2C;

public class ORCO0009_Capture_Billing_Information extends CSSTest {
    private StringBuffer verificationErrors = new StringBuffer();

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new B2C();
    }

    @Test
    public void testORCO0009_Capture_Billing_Information() throws Exception {

        try {
            PO_ResidentialUltraPostpaid po_ResidentialUltraPostpaid = new PO_ResidentialUltraPostpaid();
            PO_ResidentialPostpaidwithOptionalEmail po_ResidentialPostpaidwithOptionalEmail = new PO_ResidentialPostpaidwithOptionalEmail();
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
            configureBalance.configureBalance(po_ResidentialUltraPostpaid.getBAL_GPRS_WAP_INTERNET().getBalanceName(), "1023");
            ChooseAccessories chooseAccessories = configureBalance.clickContinue();
            MyBasket myBasket = chooseAccessories.clickContinue();

            Common.assertTextOnPage(driver, po_ResidentialUltraPostpaid.getOfferName());

            shopping = myBasket.clickContinueShopping();

            chooseYourPrimaryOffer = shopping.clickGSMMobileLink();
            enterYourSubscriptionDetails = chooseYourPrimaryOffer.selectPrimaryOfferByNameWithoutDevice(po_ResidentialPostpaidwithOptionalEmail.getOfferName());
            enterYourSubscriptionDetails.enterDefaultIdentityAddressPhoneEmail(uniqueTimeStamp);
            SelectOffersForYourSubscriber = enterYourSubscriptionDetails.clickOk();
            configureBalance = SelectOffersForYourSubscriber.clickContinueExpectingConfigurableBalance();

            configureBalance.configureBalance(po_ResidentialPostpaidwithOptionalEmail.getBAL_GPRS_WAP_INTERNET().getBalanceName(), "1023");
            chooseAccessories = configureBalance.clickContinue();
            ConfigureServiceConnectionDetails configureServiceConnectionDetails = chooseAccessories.clickContinueExpectingConnectionServiceDetails();
            configureServiceConnectionDetails.setServiceConnectionEmail("email@email.com");
            myBasket = configureServiceConnectionDetails.clickContinue();

            CheckoutRegister checkoutRegister = myBasket.clickCheckOut();
            SignUpUser signUpUser = checkoutRegister.selectSignMeUpAndClickContinue();
            CustomerDetails customerDetails = signUpUser.enterMandatoryFieldsOnlyAndClickSignMeUp(uniqueTimeStamp);
            CheckOutBillingAccountInformation checkOutBillingAccountInformation = customerDetails.clickOk();
            checkOutBillingAccountInformation.clickCheckRadioButton();
            BillingManagement billingManagement = checkOutBillingAccountInformation.clickContinueExpectingBillingManagement();

            checkOutBillingAccountInformation = billingManagement.clickIWantASeparateBillForFirstSubscriber();
            checkOutBillingAccountInformation.clickDirectDebitRadioButton();
            checkOutBillingAccountInformation.enterBankAccountNumber("123456");
            checkOutBillingAccountInformation.enterBankAgencyCode("4444");
            checkOutBillingAccountInformation.enterBankCode("2222");
            checkOutBillingAccountInformation.enterOwnerLastName("Sub2LN" + uniqueTimeStamp);
            billingManagement = checkOutBillingAccountInformation.clickContinueExpectingBillingManagement();

            Common.assertTextOnPage(driver, "Check");
            Common.assertTextOnPage(driver, "Direct Debit");
            Common.assertTextOnPage(driver, "Bank code:2222");
            Common.assertTextOnPage(driver, "Bank agency code:4444");
            Common.assertTextOnPage(driver, "Bank account number:123456");
            Common.assertTextOnPage(driver, "Owner Last Name:Sub2LN" + uniqueTimeStamp);

            billingManagement.clickContinue();

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
