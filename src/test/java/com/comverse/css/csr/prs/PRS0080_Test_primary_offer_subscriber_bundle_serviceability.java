package com.comverse.css.csr.prs;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.css.csr.EnterIdentificationData;
import com.comverse.css.csr.Shopping;
import com.comverse.css.csr.TestServiceAbility;
import com.comverse.css.csr.WorkSpace;
import com.comverse.css.data.PO.PO_DIYCableConneKT;
import com.comverse.data.apps.CSR;
import com.comverse.data.users.CSRAdmin;

public class PRS0080_Test_primary_offer_subscriber_bundle_serviceability extends CSSTest {
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    @Override
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new CSR();
        user = new CSRAdmin();
    }

    @Test
    public void testPRS0080_Test_primary_offer_subscriber_bundle_serviceability() throws Exception {
        try {
            launchCSSApplicationAndSSOLogin();
            PO_DIYCableConneKT po_DIYCableConneKT = new PO_DIYCableConneKT();

            WorkSpace workSpace = new WorkSpace(tool, test, user);

            EnterIdentificationData enterIdentificationData = workSpace.startNewConvergentResidentialCustomer();
            enterIdentificationData.enterDefaultIdentificationData();

            Shopping shopping = enterIdentificationData.clickContinue();
            Common.assertTextOnPage(tool, "Test eligibility");
            shopping.clickSubscriberBundlePrimaryOfferName(po_DIYCableConneKT.getOfferName());
            TestServiceAbility serviceAbility = shopping.clickSelectOfferInPopUpWindowWithServiceAbility();
            serviceAbility.setUnitnumber("501");
            serviceAbility.setCity("Marseille");
            serviceAbility.setZipCode("13001");
            Common.assertTextOnPage(tool, "Test Service Ability");
            Common.assertTextOnPage(tool, "Service ability criteria");
            shopping = serviceAbility.clickOK();

            Common.assertTextOnPage(tool, "Not Eligible");

            shopping.filterSubscriberBundlePrimaryOfferByName(po_DIYCableConneKT.getOfferName());
            shopping.clickNotEligibleLink();
            serviceAbility.setUnitnumber("201");
            serviceAbility.setCity("Marseille");
            serviceAbility.setZipCode("13001");
            Common.assertTextOnPage(tool, "Test Service Ability");
            Common.assertTextOnPage(tool, "Service ability criteria");
            serviceAbility.clickOK();

            Common.assertTextOnPage(tool, "Eligible");

            shopping.clickSubscriberBundlePrimaryOfferName(po_DIYCableConneKT.getOfferName());
            shopping.clickSelectOfferInPopUpWindow();
            Common.assertTextOnPage(tool, po_DIYCableConneKT.getOfferName());

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
