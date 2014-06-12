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

public class ORCO0014_Capture_Billing_Contact extends CSSTest {
    private StringBuffer verificationErrors = new StringBuffer();

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new B2C();
    }

    @Test
    public void testORCO0014_Capture_Billing_Contact() throws Exception {

        try {
            PO_ResidentialUltraPostpaid po_ResidentialUltraPostpaid = new PO_ResidentialUltraPostpaid();
            launchCSSApplication();

            String uniqueTimeStamp = Common.generateTimeStamp();

            HomePage homePage = new HomePage(tool, test, user);
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
            // CustomerDetails customerDetails =
            // signUpUser.enterMandatoryFieldsOnlyAndClickSignMeUp(uniqueTimeStamp);
            signUpUser.enterFirstName("FN" + uniqueTimeStamp);
            signUpUser.enterLastName("LN" + uniqueTimeStamp);
            signUpUser.enterAddressLineOne("Address Line One");
            signUpUser.enterZipCode("12345");
            signUpUser.enterCity("City1");
            signUpUser.selectState("Alabama");
            signUpUser.enterEmailAddress("email@comverse.com");
            signUpUser.enterLogin(uniqueTimeStamp);
            signUpUser.enterPassword("0123456");
            signUpUser.enterConfirmPassword("0123456");
            signUpUser.selectSecretQuestion("When did you kiss for the first time?");
            signUpUser.enterSecretAnswer("20 Nov 2012");
            signUpUser.enterDateOfBirth("12/12/1975");
            signUpUser.enterNationalId(uniqueTimeStamp);

            signUpUser.uncheckSameAsCustomerAddress();
            signUpUser.selectBillingTitle(("Mr."));
            signUpUser.enterBillingFirstName("BillingFN");
            signUpUser.enterBillingLastName("BillingLN");
            signUpUser.enterBillingAddressLineOne("BillingAddressLine1");
            signUpUser.enterBillingAddressLineTwo("BillingAddressLine2");
            signUpUser.enterBillingAddressLineThree("BillingAddressLine3");
            signUpUser.enterBillingAddressLineFour("BillingAddressLine4");
            signUpUser.enterBillingCity("BillingCity");
            signUpUser.selectBillingState("Alaska");
            signUpUser.enterBillingZipCode("123654");

            CustomerDetails customerDetails = signUpUser.clickSignMeUp();
            CheckOutBillingAccountInformation checkOutBillingAccountInformation = customerDetails.clickOk();
            checkOutBillingAccountInformation.clickDirectDebitRadioButton();
            checkOutBillingAccountInformation.enterBankAccountNumber("123456789");
            checkOutBillingAccountInformation.enterBankCode("12345");
            checkOutBillingAccountInformation.enterOwnerLastName("ownerLN" + uniqueTimeStamp);
            BillingManagement billingManagement = checkOutBillingAccountInformation.clickContinueExpectingBillingManagement();

            Common.assertTextOnPage(tool, "Mr. BillingFN BillingLN");
            Common.assertTextOnPage(tool, "BillingAddressLine1");
            Common.assertTextOnPage(tool, "BillingAddressLine2");
            Common.assertTextOnPage(tool, "BillingAddressLine3");
            Common.assertTextOnPage(tool, "BillingAddressLine4");
            Common.assertTextOnPage(tool, "BillingCity");
            Common.assertTextOnPage(tool, "Alaska");
            Common.assertTextOnPage(tool, "123654");

            CheckoutReview checkoutReview = billingManagement.clickContinue();

            CheckoutConfirmation checkoutConfirmation = checkoutReview.clickContinue();
            SearchOrders searchOrders = checkoutConfirmation.clickOk();
            searchOrders.waitUntilOrderCompletedOrFailed();

            searchOrders.clickDashbaord();

            Common.assertTextOnPage(tool, "BillingFNBillingLN");

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
