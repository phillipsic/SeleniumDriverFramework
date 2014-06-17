package com.comverse.css.b2c.prod;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.b2c.ChooseYourHandset;
import com.comverse.css.b2c.HomePage;
import com.comverse.css.b2c.Shopping;
import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.css.data.DEVICE.DD_CSSPQADataDeviceSmartPhonesDEV3;
import com.comverse.css.data.DEVICE.DD_CSSPQADataDeviceSmartPhonesDEV4;
import com.comverse.data.apps.B2C;

public class PROD0110_Devices_advanced_filter extends CSSTest {
    private StringBuffer verificationErrors = new StringBuffer();

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new B2C();
    }

    @Test
    public void testPROD0110_Devices_advanced_filter() throws Exception {
        try {
            launchCSSApplication();

            DD_CSSPQADataDeviceSmartPhonesDEV3 dataDevice3 = new DD_CSSPQADataDeviceSmartPhonesDEV3();
            DD_CSSPQADataDeviceSmartPhonesDEV4 dataDevice4 = new DD_CSSPQADataDeviceSmartPhonesDEV4();
            HomePage homePage = new HomePage(tool, test, user);
            homePage.clickShoppingLink();

            Shopping shopping = homePage.selectAccountSegmentAll();

            ChooseYourHandset chooseYourHandset = shopping.clickDataDevicesLink();
            chooseYourHandset.clickAdvanceFilterLink();
            Common.assertTextOnPage(tool, "Simple Filter");
            Common.assertTextOnPage(tool, "Select Manufacturer:");
            Common.assertTextOnPage(tool, "Select Features:");
            Common.assertTextOnPage(tool, "Select Values:");
            Common.assertTextOnPage(tool, "Search Attributes:");
            chooseYourHandset.selectManufacturer1();

            chooseYourHandset.clickFilter();
            Common.assertTextOnPage(tool, dataDevice3.getDeviceName());
            Common.assertTextNotOnPage(tool, dataDevice4.getDeviceName());
            chooseYourHandset.unSelectManufacturer1();
            chooseYourHandset.selectManufacturer2();
            chooseYourHandset.clickFilter();

            Common.assertTextNotOnPage(tool, dataDevice3.getDeviceName());
            Common.assertTextOnPage(tool, dataDevice4.getDeviceName());
            chooseYourHandset.selectManufacturer1();
            chooseYourHandset.selectManufacturer2();

            Common.assertTextOnPage(tool, dataDevice4.getDeviceName());
            chooseYourHandset.unSelectManufacturer1();
            chooseYourHandset.unSelectManufacturer2();
            chooseYourHandset.setSearchAttribute("dev4");
            chooseYourHandset.clickFilter();
            Common.assertTextNotOnPage(tool, dataDevice3.getDeviceName());
            Common.assertTextOnPage(tool, dataDevice4.getDeviceName());

            chooseYourHandset.selectManufacturer1();
            chooseYourHandset.setSearchAttribute("dev3");
            chooseYourHandset.clickFilter();
            Common.assertTextOnPage(tool, dataDevice3.getDeviceName());
            Common.assertTextNotOnPage(tool, dataDevice4.getDeviceName());

            chooseYourHandset.unSelectManufacturer1();
            chooseYourHandset.selectManufacturer2();
            chooseYourHandset.setSearchAttribute("dev4");
            chooseYourHandset.clickFilter();

            Common.assertTextOnPage(tool, dataDevice4.getDeviceName());

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
