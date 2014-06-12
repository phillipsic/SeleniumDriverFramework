package com.comverse.css.pos.prs;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.css.data.PO.PO_DIYInteractiveTVOfferforAll;
import com.comverse.css.data.PO.PO_ResidentialUltraPostpaid;
import com.comverse.css.pos.EnterIdentificationData;
import com.comverse.css.pos.MyShapeChannel;
import com.comverse.css.pos.Shopping;
import com.comverse.css.pos.WorkSpace;
import com.comverse.data.apps.POS;
import com.comverse.data.users.TelcoRetailerAdmin;

public class PRS0070_View_primary_offer_details extends CSSTest {
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
    public void testPRS0070_View_primary_offer_details() throws Exception {
        try {
            launchCSSApplication();
            PO_DIYInteractiveTVOfferforAll po_DIYInteractiveTVOfferforAll = new PO_DIYInteractiveTVOfferforAll();
            PO_ResidentialUltraPostpaid po_ResidentialUltraPostpaid = new PO_ResidentialUltraPostpaid();

            MyShapeChannel loginPage = new MyShapeChannel(tool, test, user);
            WorkSpace workSpace = loginPage.loginToPOS(user);

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
            shopping.clickClose();

            shopping.clickSubscriberBundlePrimaryOfferName(po_DIYInteractiveTVOfferforAll.getOfferName());
            Common.assertTextOnPage(tool, po_DIYInteractiveTVOfferforAll.getOfferNetworkType());
            shopping.clickPOCompatibleOffersTab();
            Common.assertTextOnPage(tool, "Supplementary Offers and Options");
            Common.assertTextOnPage(tool, "Optional Supplementary Offers");
            shopping.clickPOTermsAndConditionsTab();
            Common.assertTextOnPage(tool, po_DIYInteractiveTVOfferforAll.getOfferTermsAndConditions());
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
