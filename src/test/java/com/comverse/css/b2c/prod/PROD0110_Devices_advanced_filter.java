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
import com.comverse.css.data.DEV.DD_CSSPQADataDeviceSmartPhonesDEV3;
import com.comverse.css.data.DEV.DD_CSSPQADataDeviceSmartPhonesDEV4;
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
            HomePage homePage = new HomePage(driver);
            homePage.clickShoppingLink();

            Shopping shopping = homePage.selectAccountSegmentAll();

            ChooseYourHandset chooseYourHandset = shopping.clickDataDevicesLink();
            chooseYourHandset.clickAdvanceFilterLink();
            Common.assertTextOnPage(driver, "Simple Filter");
            Common.assertTextOnPage(driver, "Select Manufacturer:");
            Common.assertTextOnPage(driver, "Select Features:");
            Common.assertTextOnPage(driver, "Select Values:");
            Common.assertTextOnPage(driver, "Search Attributes:");
            chooseYourHandset.selectManufacturer1();

            chooseYourHandset.clickFilter();
            Common.assertTextOnPage(driver, dataDevice3.getDeviceName());
            Common.assertTextNotOnPage(driver, dataDevice4.getDeviceName());
            chooseYourHandset.unSelectManufacturer1();
            chooseYourHandset.selectManufacturer2();
            chooseYourHandset.clickFilter();

            Common.assertTextNotOnPage(driver, dataDevice3.getDeviceName());
            Common.assertTextOnPage(driver, dataDevice4.getDeviceName());
            chooseYourHandset.selectManufacturer1();
            chooseYourHandset.selectManufacturer2();

            Common.assertTextOnPage(driver, dataDevice4.getDeviceName());
            chooseYourHandset.unSelectManufacturer1();
            chooseYourHandset.unSelectManufacturer2();
            chooseYourHandset.setSearchAttribute("dev4");
            chooseYourHandset.clickFilter();
            Common.assertTextNotOnPage(driver, dataDevice3.getDeviceName());
            Common.assertTextOnPage(driver, dataDevice4.getDeviceName());

            chooseYourHandset.selectManufacturer1();
            chooseYourHandset.setSearchAttribute("dev3");
            chooseYourHandset.clickFilter();
            Common.assertTextOnPage(driver, dataDevice3.getDeviceName());
            Common.assertTextNotOnPage(driver, dataDevice4.getDeviceName());

            chooseYourHandset.unSelectManufacturer1();
            chooseYourHandset.selectManufacturer2();
            chooseYourHandset.setSearchAttribute("dev4");
            chooseYourHandset.clickFilter();

            Common.assertTextOnPage(driver, dataDevice4.getDeviceName());

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
