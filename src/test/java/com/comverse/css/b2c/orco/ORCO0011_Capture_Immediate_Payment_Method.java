package com.comverse.css.b2c.orco;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.b2c.*;
import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.css.data.DEV.VD_CSSPQAVoiceDeviceStandardPhonesDEV2;
import com.comverse.data.apps.B2C;

public class ORCO0011_Capture_Immediate_Payment_Method extends CSSTest {
    private StringBuffer verificationErrors = new StringBuffer();

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new B2C();
    }

    @Test
    public void testORCO0011_Capture_Immediate_Payment_Method() throws Exception {

        try {
            launchCSSApplication();
            VD_CSSPQAVoiceDeviceStandardPhonesDEV2 voiceDevice2 = new VD_CSSPQAVoiceDeviceStandardPhonesDEV2();
            String uniqueTimeStamp = Common.generateTimeStamp();

            HomePage homePage = new HomePage(driver);
            homePage.clickShoppingLink();

            Shopping shopping = homePage.selectAccountSegmentAll();

            ChooseYourHandset chooseYourHandset = shopping.clickVoiceDevicesLink();
            ChooseYourPrimaryOffer chooseYourPrimaryOffer = chooseYourHandset.selectHandset(voiceDevice2.getDeviceName());
            ChooseAccessories chooseAccessories = chooseYourPrimaryOffer.clickNoThanks();
            MyBasket myBasket = chooseAccessories.clickContinue();
            TermsAndConditions termsAndConditions = myBasket.clickCheckOutWithDevices();
            test.setBugId("CBS00163135");
            CheckoutRegister checkoutRegister = termsAndConditions.clickOk();
            test.setBugId("NoBug");
            SignUpUser signUpUser = checkoutRegister.selectSignMeUpAndClickContinue();
            CustomerDetails customerDetails = signUpUser.enterMandatoryFieldsOnlyAndClickSignMeUp(uniqueTimeStamp);

            CheckOutDeliveryAddress checkOutDeliveryAddress = customerDetails.clickOkWithDevices();
            CheckOutBillingAccountInformation checkOutBillingAccountInformation = checkOutDeliveryAddress.clickContinue();
            CheckoutReview checkoutReview = checkOutBillingAccountInformation.clickContinue();
            ImmediatePayment immediatePayment = checkoutReview.clickContinueWithDevices();
            immediatePayment.enterCardNumber("4111111111111111");
            immediatePayment.enterCardExpDate("09/2014");
            immediatePayment.enterCardHolderFirstName("FN");
            immediatePayment.enterCardHolderLastName("LN");
            immediatePayment.enterCardSecretCode("123");

            CheckoutConfirmation checkoutConfirmation = immediatePayment.clickContinue();

            checkoutConfirmation.clickOk();

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
