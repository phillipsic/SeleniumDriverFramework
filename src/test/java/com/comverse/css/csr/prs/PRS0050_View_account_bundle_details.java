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
import com.comverse.css.csr.WorkSpace;
import com.comverse.css.data.AB.AB_DIYSuperPack;
import com.comverse.data.apps.CSR;
import com.comverse.data.users.CSRAdmin;

public class PRS0050_View_account_bundle_details extends CSSTest {
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
    public void testPRS0050_View_account_bundle_details() throws Exception {
        try {
            launchCSSApplicationAndSSOLogin();
            AB_DIYSuperPack ab_DIYSuperPack = new AB_DIYSuperPack();

            WorkSpace workSpace = new WorkSpace(tool, test, user);

            EnterIdentificationData enterIdentificationData = workSpace.startNewConvergentResidentialCustomer();
            enterIdentificationData.enterDefaultIdentificationData();

            Shopping shopping = enterIdentificationData.clickContinue();
            shopping.clickAccountBundlesTab();

            shopping.clickAccountBundleOfferName(ab_DIYSuperPack.getOfferName());
            Common.assertTextOnPage(tool, ab_DIYSuperPack.getOfferDescription());
            shopping.clickABCompatibleOffersTab();
            Common.assertTextOnPage(tool, "Bundle Offers");
            Common.assertTextOnPage(tool, "Included Offers");
            Common.assertTextOnPage(tool, "Optional Offers");
            shopping.clickABTermsAndConditionsTab();
            Common.assertTextOnPage(tool, ab_DIYSuperPack.getOfferTermsAndConditions());
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
