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
import com.comverse.css.data.Offer;
import com.comverse.css.data.SB.SB_DIY10_10SuperBundle;
import com.comverse.css.data.SB.SB_ResidentialUltraPostpaidBundle;
import com.comverse.data.apps.CSR;
import com.comverse.data.users.CSRAdmin;

public class PRS0060_View_subscriber_bundle_details extends CSSTest {
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
    public void testPRS0060_View_subscriber_bundle_details() throws Exception {
        try {
            launchCSSApplicationAndSSOLogin();
            SB_DIY10_10SuperBundle sb_DIY10_10SuperBundle = new SB_DIY10_10SuperBundle();
            SB_ResidentialUltraPostpaidBundle sb_ResidentialUltraPostpaidBundle = new SB_ResidentialUltraPostpaidBundle();

            WorkSpace workSpace = new WorkSpace(tool, test, user);

            EnterIdentificationData enterIdentificationData = workSpace.startNewConvergentResidentialCustomer();
            enterIdentificationData.enterDefaultIdentificationData();

            Shopping shopping = enterIdentificationData.clickContinue();

            shopping.clickSubscriberBundlePrimaryOfferName(sb_DIY10_10SuperBundle.getOfferName());
            Common.assertTextOnPage(tool, sb_DIY10_10SuperBundle.getOfferDescription());
            shopping.clickPOCompatibleOffersTab();
            Common.assertTextOnPage(tool, "Bundle Supplementary Offers");
            Common.assertTextOnPage(tool, "Optional Supplementary Offers");
            shopping.clickPOTermsAndConditionsTab();
            Common.assertTextOnPage(tool, ((Offer) sb_DIY10_10SuperBundle.getPO_DIYInteractiveTVOfferforAll()).getOfferTermsAndConditions());
            shopping.clickPOOfferPolicyDetailsTab();
            Common.assertTextOnPage(tool, "No specific Offer Policy found.");
            shopping.clickClose();

            shopping.clickSubscriberBundlePrimaryOfferName(sb_ResidentialUltraPostpaidBundle.getOfferName());
            Common.assertTextOnPage(tool, sb_ResidentialUltraPostpaidBundle.getOfferNetworkType());
            shopping.clickPOCompatibleOffersTab();
            Common.assertTextOnPage(tool, "Bundle Supplementary Offers");
            Common.assertTextOnPage(tool, "Included Supplementary Offers");
            Common.assertTextOnPage(tool, "Selective Supplementary Offers");
            shopping.clickPOTermsAndConditionsTab();
            Common.assertTextOnPage(tool, "No specific Terms and Conditions apply.");
            shopping.clickPOOfferPolicyDetailsTab();
            Common.assertTextOnPage(tool, "No specific Offer Policy found.");
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
