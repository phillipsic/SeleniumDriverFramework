package com.comverse.css.b2b.chk;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.b2b.*;
import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.data.apps.B2B;
import com.comverse.data.users.B2BAdmin;

public class CHK0040_Pay_now_Devices_and_Accessories_upfront_costs extends CSSTest {
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    @Override
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new B2B();
        user = new B2BAdmin();
    }

    @Test
    public void testCHK0040_Pay_now_Devices_and_Accessories_upfront_costs() throws Exception {

        try {
            launchCSSApplication();

            MyshapeBusiness loginPage = new MyshapeBusiness(tool, test, user);
            WorkSpace workSpace = loginPage.loginToB2B(user);

            AccountDetails accountDetails = workSpace.clickAccount();
            Shopping shopping = accountDetails.clickShopForDevicesAndAccessories();

            MyBasket myBasket = shopping.selectHandset("CSS-PQA-VoiceDevice-StandardPhones-DEV1");

            myBasket.clickContinueShopping();
            shopping.clickAccessoriesTab();
            myBasket = shopping.selectAccessory("CSS-PQA-Battery-Phone-ACC1");

            Common.assertTextOnPage(tool, "CSS-PQA-VoiceDevice-StandardPhones-DEV1");
            Common.assertTextOnPage(tool, "CSS-PQA-Battery-Phone-ACC1");
            test.setBugId("CBS00153652");
            myBasket.clickAcceptTermsAndConditions();
            test.setBugId("NoBug");
            CheckoutDeliveryAddress checkoutDeliveryAddress = myBasket.clickCheckOutWithGoods();
            CheckoutReview checkoutReview = checkoutDeliveryAddress.clickNextPage();
            ImmediatePayment immediatePayment = checkoutReview.clickConfirmWithGoods();

            immediatePayment.checkForExistingCreditCardDetailsAndClickNew();

            immediatePayment.setCardNumber("4111111111111111");
            immediatePayment.setExpirationDate("12/2020");
            immediatePayment.setCardHolderLastName("CardHolder LastName");
            immediatePayment.setCardHolderFirstName("CardHolder FirstName");
            immediatePayment.setCardSecretCode("1234");

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
