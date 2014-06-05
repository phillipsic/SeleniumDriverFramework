package com.comverse.css.b2c.prod;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.b2c.ChooseYourHandset;
import com.comverse.css.b2c.HandsetDetails;
import com.comverse.css.b2c.HomePage;
import com.comverse.css.b2c.Shopping;
import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.css.data.DEV.VD_CSSPQAVoiceDeviceStandardPhonesDEV1;
import com.comverse.data.apps.B2C;

public class PROD1100_View_Device_Details extends CSSTest {
    private StringBuffer verificationErrors = new StringBuffer();

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new B2C();
    }

    @Test
    public void testPROD1100_View_Device_Details() throws Exception {
        try {
            launchCSSApplication();

            VD_CSSPQAVoiceDeviceStandardPhonesDEV1 voiceDevice1 = new VD_CSSPQAVoiceDeviceStandardPhonesDEV1();
            HomePage homePage = new HomePage(driver);
            homePage.clickShoppingLink();

            Shopping shopping = homePage.selectAccountSegmentAll();

            ChooseYourHandset chooseYourHandset = shopping.clickVoiceDevicesLink();
            HandsetDetails handsetDetails = chooseYourHandset.viewDetailsOfHandset(voiceDevice1.getDeviceName());
            Common.assertTextOnPage(driver, voiceDevice1.getDeviceDescription());
            handsetDetails.clickTermsAndConditionsTab();
            Common.assertTextOnPage(driver, voiceDevice1.getDeviceTermsAndConditions());
            chooseYourHandset = handsetDetails.clickReturnToList();

            Common.assertTextOnPage(driver, voiceDevice1.getDeviceName());

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
