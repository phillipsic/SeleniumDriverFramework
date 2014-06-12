package com.comverse.css.pos.prs;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.css.pos.*;
import com.comverse.data.apps.POS;
import com.comverse.data.users.TelcoRetailerAdmin;

public class PRS0080_Test_primary_offer_subscriber_bundle_serviceability extends CSSTest {
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
    public void testPRS0080_Test_primary_offer_subscriber_bundle_serviceability() throws Exception {
        try {
            launchCSSApplication();
            String PRIMARY_OFFER = "DIY - Cable ConneKT";

            MyShapeChannel loginPage = new MyShapeChannel(tool, test, user);
            WorkSpace workSpace = loginPage.loginToPOS(user);

            EnterIdentificationData enterIdentificationData = workSpace.startNewConvergentResidentialCustomer();
            enterIdentificationData.enterDefaultIdentificationData();

            Shopping shopping = enterIdentificationData.clickContinue();
            Common.assertTextOnPage(tool, "Test eligibility");
            shopping.clickSubscriberBundlePrimaryOfferName(PRIMARY_OFFER);
            TestServiceAbility serviceAbility = shopping.clickSelectOfferInPopUpWindowWithServiceAbility();
            serviceAbility.setUnitnumber("501");
            serviceAbility.setCity("Marseille");
            serviceAbility.setZipCode("13001");
            Common.assertTextOnPage(tool, "Test Service Ability");
            Common.assertTextOnPage(tool, "Service ability criteria");
            shopping = serviceAbility.clickOK();

            Common.assertTextOnPage(tool, "Not Eligible");

            shopping.filterSubscriberBundlePrimaryOfferByName(PRIMARY_OFFER);
            shopping.clickNotEligibleLink();
            serviceAbility.setUnitnumber("201");
            serviceAbility.setCity("Marseille");
            serviceAbility.setZipCode("13001");
            Common.assertTextOnPage(tool, "Test Service Ability");
            Common.assertTextOnPage(tool, "Service ability criteria");
            serviceAbility.clickOK();

            Common.assertTextOnPage(tool, "Eligible");

            shopping.clickSubscriberBundlePrimaryOfferName(PRIMARY_OFFER);
            shopping.clickSelectOfferInPopUpWindow();
            Common.assertTextOnPage(tool, PRIMARY_OFFER);

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