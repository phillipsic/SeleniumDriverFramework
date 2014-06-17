package com.comverse.css.b2c.shma;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.b2c.*;
import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.css.data.DEVICE.VD_CSSPQAVoiceDeviceStandardPhonesDEV1;
import com.comverse.css.data.DEVICE.VD_CSSPQAVoiceDeviceStandardPhonesDEV2;
import com.comverse.css.data.PO.PO_ResidentialUltraPostpaid;
import com.comverse.data.apps.B2C;

public class SHMA0101_Change_Device_of_a_Basket_Selection extends CSSTest {
    private StringBuffer verificationErrors = new StringBuffer();

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new B2C();
    }

    @Test
    public void testSHMA0101_Change_Device_of_a_Basket_Selection() throws Exception {
        try {
            launchCSSApplication();
            PO_ResidentialUltraPostpaid po_ResidentialUltraPostpaid = new PO_ResidentialUltraPostpaid();
            VD_CSSPQAVoiceDeviceStandardPhonesDEV1 voiceDevice1 = new VD_CSSPQAVoiceDeviceStandardPhonesDEV1();
            VD_CSSPQAVoiceDeviceStandardPhonesDEV2 voiceDevice2 = new VD_CSSPQAVoiceDeviceStandardPhonesDEV2();
            String uniqueTimeStamp = Common.generateTimeStamp();
            HomePage homePage = new HomePage(tool, test, user);
            homePage.clickShoppingLink();

            Shopping shopping = homePage.selectAccountSegmentAll();

            ChooseYourHandset chooseYourHandset = shopping.clickVoiceDevicesLink();
            ChooseYourPrimaryOffer chooseYourPrimaryOffer = chooseYourHandset.selectHandset(voiceDevice1.getDeviceName());
            EnterYourSubscriptionDetails enterYourSubscriptionDetails = chooseYourPrimaryOffer.selectPrimaryOfferByNameWithoutDevice(po_ResidentialUltraPostpaid.getOfferName());
            enterYourSubscriptionDetails.enterDefaultIdentityAddressPhoneEmail(uniqueTimeStamp);
            SelectOffersForYourSubscriber selectOffersForYourSubscriber = enterYourSubscriptionDetails.clickOk();
            ConfigureOffers configureOffers = selectOffersForYourSubscriber.clickContinue();
            ConfigureBalance configureBalance = configureOffers.clickContinueExpectingConfigureBalance();
            configureBalance.setSpendingLimit(po_ResidentialUltraPostpaid.getBAL_GPRS_WAP_INTERNET().getBalanceName(), "120");
            MyBasket myBasket = configureBalance.clickContinueExpectingMyBasket();
            // Checking Device3 details in Basket.
            Common.assertTextOnPage(tool, po_ResidentialUltraPostpaid.getOfferName());
            Common.assertTextOnPage(tool, voiceDevice1.getDeviceName());
            Common.assertTextOnPage(tool, voiceDevice1.getDevicePriceinDollar());
            // Changing Device from Basket
            chooseYourHandset = myBasket.clickChangeDevice();
            myBasket = chooseYourHandset.selectHandsetExpectingMyBasket(voiceDevice2.getDeviceName());
            // Checking Device3 not exist & Device4 existence
            Common.assertTextNotOnPage(tool, voiceDevice1.getDeviceName());
            Common.assertTextOnPage(tool, voiceDevice2.getDeviceName());
            Common.assertTextOnPage(tool, voiceDevice2.getDevicePriceinDollar());
            // bugId = "NoBug";
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
