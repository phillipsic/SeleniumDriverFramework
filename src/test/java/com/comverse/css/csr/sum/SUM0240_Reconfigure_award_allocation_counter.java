package com.comverse.css.csr.sum;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.css.commonpages.AccountDetailsCommon;
import com.comverse.css.commonpages.IdentifyCustomerCommon;
import com.comverse.css.commonpages.SubscriberDetailsCommon;
import com.comverse.css.csr.WorkSpace;
import com.comverse.css.data.SO.RPO_DIYRechargePromotionalOffer3;
import com.comverse.data.apps.CSR;
import com.comverse.data.users.CSRAdmin;

public class SUM0240_Reconfigure_award_allocation_counter extends CSSTest {
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    @Override
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new CSR();
        user = new CSRAdmin();
        preparation.enableRPO(application);
    }

    @Test
    public void testSUM0240_Reconfigure_award_allocation_counter() throws Exception {
        try {
            RPO_DIYRechargePromotionalOffer3 rpo_DIYRechargePromotionalOffer3 = new RPO_DIYRechargePromotionalOffer3();
            launchCSSApplicationAndSSOLogin();

            WorkSpace workSpace = new WorkSpace(tool, test, user);

            workSpace.doResitdentialNCADIYRechargesPromotionsCSR();

            IdentifyCustomerCommon identifyCustomer = workSpace.gotoManageAccount();

            AccountDetailsCommon accountDetails = identifyCustomer.searchByPersonLastNameSinglePerson(workSpace.getPerson().getPersonLastNameProperty());

            SubscriberDetailsCommon subscriberDashboard = accountDetails.selectFirstSubscriberFromNavigationPanel();
            subscriberDashboard.doAddRPOCSR(rpo_DIYRechargePromotionalOffer3.getOfferName());
            Common.assertTextOnPage(tool, rpo_DIYRechargePromotionalOffer3.getOfferName());
            subscriberDashboard.clickReconfigureAwardCounter();
            Common.assertTextOnPage(tool, "Reconfigure award counter");
            subscriberDashboard.clickSetAwardCounter();
            subscriberDashboard.clickConfirmAwardCounterReconfiguration();
            subscriberDashboard.clickRefreshRPO();
            Common.assertTextOnPage(tool, "2/3");

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
