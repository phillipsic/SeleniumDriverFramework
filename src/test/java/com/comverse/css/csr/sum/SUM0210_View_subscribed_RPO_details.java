package com.comverse.css.csr.sum;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.css.csr.*;
import com.comverse.css.data.PO.PO_DIYRechargesPromotions;
import com.comverse.data.apps.CSR;
import com.comverse.data.users.CSRAdmin;

public class SUM0210_View_subscribed_RPO_details extends CSSTest {
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
    public void testSUM0210_View_subscribed_RPO_details() throws Exception {
        try {
            // RPO_DIYRechargePromotionalOffer3 rpo_DIYRechargePromotionalOffer3
            // = new RPO_DIYRechargePromotionalOffer3();
            PO_DIYRechargesPromotions po_DIYRechargesPromotions = new PO_DIYRechargesPromotions();
            launchCSSApplicationAndSSOLogin();

            WorkSpace workSpace = new WorkSpace(tool, test, user);

            workSpace.doResitdentialNCADIYRechargesPromotionsCSR();

            IdentifyCustomer identifyCustomer = workSpace.gotoManageAccount();
            AccountDetails accountDetails = identifyCustomer.searchByPersonLastNameSinglePerson(workSpace.getPerson().getPersonLastNameProperty());
            SubscriberDetails subscriberDashboard = accountDetails.selectFirstSubscriberFromNavigationPanel();

            Common.assertTextOnPage(tool, po_DIYRechargesPromotions.getOfferName());
            Common.assertTextOnPage(tool, po_DIYRechargesPromotions.getEngagementDuration());

            PrimaryOfferDetails primaryOfferDetails = subscriberDashboard.clickRPODetails(po_DIYRechargesPromotions.getOfferName());

            Common.assertTextOnPage(tool, po_DIYRechargesPromotions.getOfferName());

            primaryOfferDetails.clickRPOCompatiblePrimaryOffersTab();
            Common.assertTextOnPage(tool, "DIY - Additional Fiber Service");
            Common.assertTextOnPage(tool, "DIY - Additional TV Services 4U");
            Common.assertTextOnPage(tool, "DIY - Monthly Subscription Prime Offering");

            primaryOfferDetails.clickRPOTermsandConditionsTab();
            Common.assertTextOnPage(tool, "No specific Terms and Conditions apply.");

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
