package com.comverse.css.pos.prs;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.css.pos.EnterIdentificationData;
import com.comverse.css.pos.MyShapeChannel;
import com.comverse.css.pos.Shopping;
import com.comverse.css.pos.WorkSpace;
import com.comverse.data.apps.POS;
import com.comverse.data.users.TelcoRetailerAdmin;

public class PRS0050_View_account_bundle_details extends CSSTest {
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    @Override
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new POS();
        user = new TelcoRetailerAdmin();
    }

    @Test
    public void testPRS0050_View_account_bundle_details() throws Exception {
        try {
            launchCSSApplication();
            String ACCOUNT_BUNDLE = "DIY - Super-Pack";

            MyShapeChannel loginPage = new MyShapeChannel(tool, test, user);
            WorkSpace workSpace = loginPage.loginToPOS(user);

            EnterIdentificationData enterIdentificationData = workSpace.startNewConvergentResidentialCustomer();
            enterIdentificationData.enterDefaultIdentificationData();

            Shopping shopping = enterIdentificationData.clickContinue();
            shopping.clickAccountBundlesTab();

            shopping.clickAccountBundleOfferName(ACCOUNT_BUNDLE);
            Common.assertTextOnPage(tool, "DIY allows you to extensively customize your services.");
            shopping.clickABCompatibleOffersTab();
            Common.assertTextOnPage(tool, "Bundle Offers");
            Common.assertTextOnPage(tool, "Included Offers");
            Common.assertTextOnPage(tool, "Optional Offers");
            shopping.clickABTermsAndConditionsTab();
            Common.assertTextOnPage(tool, "DIY - Super-Pack Terms and Conditions.");
            shopping.clickClose();

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