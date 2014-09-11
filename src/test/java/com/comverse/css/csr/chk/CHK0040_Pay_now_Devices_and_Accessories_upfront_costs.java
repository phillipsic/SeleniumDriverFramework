package com.comverse.css.csr.chk;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.css.csr.*;
import com.comverse.data.apps.CSR;
import com.comverse.data.users.CSRAdmin;

public class CHK0040_Pay_now_Devices_and_Accessories_upfront_costs extends CSSTest {
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
    public void testCHK0040_Pay_now_Devices_and_Accessories_upfront_costs() throws Exception {
        try {
            launchCSSApplicationAndSSOLogin();
            preparation.enableDevice(application);
            String uniqueString = Common.generateTimeStamp();

            WorkSpace workSpace = new WorkSpace(tool, test, user);

            EnterIdentificationData enterIdentificationData = workSpace.startNewConvergentResidentialCustomer();

            enterIdentificationData.setCustomerTitle("Mrs.");
            enterIdentificationData.setCustomerFirstName("FN" + uniqueString);
            enterIdentificationData.setCustomerLastName("LN" + uniqueString);
            enterIdentificationData.setGender("female");
            enterIdentificationData.setEmailAddress("email@address.com");
            enterIdentificationData.setPhoneNumber("0123456");
            enterIdentificationData.setFaxNumber("6543210");

            enterIdentificationData.enterCustomerPostCode("612204");
            enterIdentificationData.enterCustomerCity("US ville");
            enterIdentificationData.enterCustomerHomeCountry("United States");
            enterIdentificationData.enterCustomerHomeState("Iowa");

            enterIdentificationData.setCustomerStreetNumber("55");
            enterIdentificationData.setCustomerStreetName("Name of Street");
            enterIdentificationData.clickCopyFromCustomerAddressButton();
            enterIdentificationData.clickPaymentMethodCheck();

            Shopping shopping = enterIdentificationData.clickContinue();

            shopping.clickHandsetsTab();

            MyBasket myBasket = shopping.selectHandset("CSS-PQA-VoiceDevice-StandardPhones-DEV1");

            myBasket.clickContinueShopping();
            shopping.clickAccessoriesTab();
            myBasket = shopping.selectAccessory("CSS-PQA-Battery-Phone-ACC1");

            Common.assertTextOnPage(tool, "CSS-PQA-VoiceDevice-StandardPhones-DEV1");
            Common.assertTextOnPage(tool, "CSS-PQA-Battery-Phone-ACC1");
            myBasket.clickAcceptTermsAndConditions();
            CheckoutDeliveryAddress checkoutDeliveryAddress = myBasket.clickCheckOutWithGoods();
            CheckoutReview checkoutReview = checkoutDeliveryAddress.clickNextPage();
            ImmediatePayment immediatePayment = checkoutReview.clickConfirmWithGoods();
            immediatePayment.setCardNumber("4111111111111111");
            immediatePayment.setExpirationDate("12/2020");
            immediatePayment.setCardHolderLastName("CardHolder LastName");
            immediatePayment.setCardHolderFirstName("CardHolder FirstName");
            immediatePayment.setCardSecretCode("123");

            immediatePayment.clickContinue();

            Common.assertTextOnPage(tool, "Your payment has been processed successfully.");
            Common.assertTextOnPage(tool, "Payment Method:Credit Card");
            Common.assertTextOnPage(tool, "Credit Card Type:VISA");
            Common.assertTextOnPage(tool, "Your order has been submitted.");

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
