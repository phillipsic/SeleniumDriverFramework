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
import com.comverse.css.data.PO.PO_ResidentialUltraPostpaid;
import com.comverse.data.apps.B2C;

public class SHMA0016_View_Basket extends CSSTest {

    private StringBuffer verificationErrors = new StringBuffer();

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new B2C();
    }

    @Test
    public void testSHMA0016_View_Basket() throws Exception {
        try {
            PO_ResidentialUltraPostpaid po_ResidentialUltraPostpaid = new PO_ResidentialUltraPostpaid();
            // SO_DIYeCountdownExtra so_DIYeCountDownExtra = new
            // SO_DIYeCountdownExtra();
            VD_CSSPQAVoiceDeviceStandardPhonesDEV1 vd_StandardPhoneDEV1 = new VD_CSSPQAVoiceDeviceStandardPhonesDEV1();

            launchCSSApplication();
            String uniqueTimeStamp = Common.generateTimeStamp();
            double poNRC = Double.parseDouble(po_ResidentialUltraPostpaid.getNRC());

            HomePage homePage = new HomePage(tool, test, user);
            homePage.clickShoppingLink();
            Shopping shopping = homePage.selectAccountSegmentAll();

            ChooseYourPrimaryOffer chooseYourPrimaryOffer = shopping.clickGSMMobileLink();
            // ChooseYourPrimaryOffer chooseYourPrimaryOffer =
            // chooseYourPrimaryOfferInThisAccountBundle.clickSwitchToBrowsePrimaryOffers();
            ChooseYourDevice chooseYourDevice = chooseYourPrimaryOffer.selectPrimaryOfferByNameWithDevice(po_ResidentialUltraPostpaid.getOfferName());

            ChooseYourHandset chooseYourHandset = chooseYourDevice.clickSelectVoiceDevices();
            EnterYourSubscriptionDetails enterYourSubscriptionDetails = chooseYourHandset.selectHandsetExpectingSubscriptionDetails(vd_StandardPhoneDEV1.getDeviceName());

            enterYourSubscriptionDetails.enterDefaultIdentityAddressPhoneEmail(uniqueTimeStamp);
            SelectOffersForYourSubscriber selectOffersForYourSubscriber = enterYourSubscriptionDetails.clickOk();

            ConfigureOffers configureOffers = selectOffersForYourSubscriber.clickContinue();
            ConfigureBalance configureBalance = configureOffers.clickContinueExpectingConfigureBalance();
            configureBalance.setSpendingLimit(po_ResidentialUltraPostpaid.getBAL_GPRS_WAP_INTERNET().getBalanceName(), "120");
            configureBalance.clickContinueExpectingMyBasket();

            // Verification of added PO & Accessory with total price .
            Common.assertTextOnPage(tool, po_ResidentialUltraPostpaid.getOfferName());
            Common.assertTextOnPage(tool, String.valueOf(poNRC));
            Common.assertTextOnPage(tool, vd_StandardPhoneDEV1.getDeviceName());

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
