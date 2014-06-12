package com.comverse.css.b2c.prod;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.b2c.*;
import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.css.data.DEV.VD_CSSPQAVoiceDeviceStandardPhonesDEV1;
import com.comverse.data.apps.B2C;

public class PROD0100_Browse_devices_and_kits extends CSSTest {
    private StringBuffer verificationErrors = new StringBuffer();

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new B2C();
    }

    @Test
    public void testPROD0100_Browse_devices_and_kits() throws Exception {
        try {
            launchCSSApplication();

            VD_CSSPQAVoiceDeviceStandardPhonesDEV1 voiceDevice1 = new VD_CSSPQAVoiceDeviceStandardPhonesDEV1();
            HomePage homePage = new HomePage(tool, test, user);
            homePage.clickShoppingLink();

            Shopping shopping = homePage.selectAccountSegmentAll();

            ChooseYourHandset chooseYourHandset = shopping.clickVoiceDevicesLink();
            HandsetDetails handsetDetails = chooseYourHandset.viewDetailsOfHandset(voiceDevice1.getDeviceName());

            MyBasket myBasket = handsetDetails.clickBuyOutRight();

            shopping = myBasket.clickContinueShopping();
            ChooseAccessories chooseAccessories = shopping.clickPhoneAccessoriesLink();

            // @TODO - need to replace the hard coded strings with device object
            chooseAccessories.setQuantityForAccessory("CSS-PQA-Battery-Phone-ACC1", "2");
            myBasket = chooseAccessories.clickContinue();

            Common.assertTextOnPage(tool, voiceDevice1.getDeviceName());
            Common.assertTextOnPage(tool, voiceDevice1.getDevicePriceinDollar());
            Common.assertTextOnPage(tool, "CSS-PQA-Battery-Phone-ACC1");
            Common.assertTextOnPage(tool, "59.98");

            TermsAndConditions termsAndConditions = myBasket.clickCheckOutExpectingTermsAndConditions();

            test.setBugId("CBS00163135");
            termsAndConditions.clickOkExpectingCheckoutRegister();
            test.setBugId("NoBug");

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
