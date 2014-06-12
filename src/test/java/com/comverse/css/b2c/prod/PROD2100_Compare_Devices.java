package com.comverse.css.b2c.prod;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.b2c.ChooseYourHandset;
import com.comverse.css.b2c.CompareDevices;
import com.comverse.css.b2c.HomePage;
import com.comverse.css.b2c.Shopping;
import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Prep;
import com.comverse.css.data.DEV.VD_CSSPQAVoiceDeviceStandardPhonesDEV1;
import com.comverse.css.data.DEV.VD_CSSPQAVoiceDeviceStandardPhonesDEV2;
import com.comverse.data.apps.B2C;

public class PROD2100_Compare_Devices extends CSSTest {
    private StringBuffer verificationErrors = new StringBuffer();

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new B2C();
    }

    @Test
    public void testPROD2100_Compare_Devices() throws Exception {
        try {
            launchCSSApplication();

            VD_CSSPQAVoiceDeviceStandardPhonesDEV1 voiceDevice1 = new VD_CSSPQAVoiceDeviceStandardPhonesDEV1();
            VD_CSSPQAVoiceDeviceStandardPhonesDEV2 voiceDevice6 = new VD_CSSPQAVoiceDeviceStandardPhonesDEV2();
            HomePage homePage = new HomePage(tool, test, user);
            homePage.clickShoppingLink();

            Shopping shopping = homePage.selectAccountSegmentAll();

            ChooseYourHandset chooseYourHandset = shopping.clickVoiceDevicesLink();
            chooseYourHandset = chooseYourHandset.clickAddToCompare(voiceDevice1.getDeviceName());
            chooseYourHandset = chooseYourHandset.clickAddToCompare(voiceDevice6.getDeviceName());

            assertEquals(voiceDevice1.getDeviceName(), chooseYourHandset.comparableDevice1());
            assertEquals(voiceDevice6.getDeviceName(), chooseYourHandset.comparableDevice2());
            CompareDevices compareDevices = chooseYourHandset.clickCompare();

            assertEquals(voiceDevice1.getDeviceName(), compareDevices.getDevice1());
            assertEquals(voiceDevice6.getDeviceName(), compareDevices.getDevice2());

            chooseYourHandset = compareDevices.clickReturnToList();

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
