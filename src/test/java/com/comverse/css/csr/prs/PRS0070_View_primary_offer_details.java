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
import com.comverse.css.data.PO.PO_DIYInteractiveTVOfferforAll;
import com.comverse.css.data.PO.PO_ResidentialUltraPostpaid;
import com.comverse.data.apps.CSR;
import com.comverse.data.users.CSRAdmin;

public class PRS0070_View_primary_offer_details extends CSSTest {
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
    public void testPRS0070_View_primary_offer_details() throws Exception {
        try {
            launchCSSApplicationAndSSOLogin();
            PO_DIYInteractiveTVOfferforAll po_DIYInteractiveTVOfferforAll = new PO_DIYInteractiveTVOfferforAll();
            PO_ResidentialUltraPostpaid po_ResidentialUltraPostpaid = new PO_ResidentialUltraPostpaid();

            WorkSpace workSpace = new WorkSpace(tool, test, user);

            EnterIdentificationData enterIdentificationData = workSpace.startNewConvergentResidentialCustomer();
            enterIdentificationData.enterDefaultIdentificationData();

            Shopping shopping = enterIdentificationData.clickContinue();

            shopping.clickSubscriberBundlePrimaryOfferName(po_ResidentialUltraPostpaid.getOfferName());
            Common.assertTextOnPage(tool, po_ResidentialUltraPostpaid.getOfferNetworkType());
            shopping.clickPOCompatibleOffersTab();
            Common.assertTextOnPage(tool, "Supplementary Offers and Options");
            Common.assertTextOnPage(tool, "Optional Supplementary Offers");
            shopping.clickPOTermsAndConditionsTab();
            Common.assertTextOnPage(tool, "No specific Terms and Conditions apply.");
            shopping.clickPOOfferPolicyDetailsTab();
            Common.assertTextOnPage(tool, "No specific Offer Policy found.");
            shopping.clickClose();

            shopping.clickSubscriberBundlePrimaryOfferName(po_DIYInteractiveTVOfferforAll.getOfferName());
            Common.assertTextOnPage(tool, po_DIYInteractiveTVOfferforAll.getOfferNetworkType());
            shopping.clickPOCompatibleOffersTab();
            Common.assertTextOnPage(tool, "Supplementary Offers and Options");
            Common.assertTextOnPage(tool, "Optional Supplementary Offers");
            shopping.clickPOTermsAndConditionsTab();
            Common.assertTextOnPage(tool, po_DIYInteractiveTVOfferforAll.getOfferTermsAndConditions());
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
