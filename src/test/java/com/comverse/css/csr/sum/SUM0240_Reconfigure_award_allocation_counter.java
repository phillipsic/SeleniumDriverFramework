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
import com.comverse.css.data.SO.RPO_DIYRechargePromotionalOffer2;
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
    }

    @Test
    public void testSUM0240_Reconfigure_award_allocation_counter() throws Exception {
        try {
            RPO_DIYRechargePromotionalOffer2 rpo_DIYRechargePromotionalOffer2 = new RPO_DIYRechargePromotionalOffer2();
            launchCSSApplicationAndSSOLogin();

            WorkSpace workSpace = new WorkSpace(tool, test, user);

            workSpace.doResitdentialNCAResidentialUltraPostpaidCSR();

            IdentifyCustomerCommon identifyCustomer = workSpace.gotoManageAccount();

            AccountDetailsCommon accountDetails = identifyCustomer.searchByPersonLastNameSinglePerson(workSpace.getPerson().getPersonLastNameProperty());

            SubscriberDetailsCommon subscriberDashboard = accountDetails.selectFirstSubscriberFromNavigationPanel();
            subscriberDashboard.doAddRPO(rpo_DIYRechargePromotionalOffer2.getOfferName());
            Common.assertTextOnPage(tool, rpo_DIYRechargePromotionalOffer2.getOfferName());
            subscriberDashboard.clickReconfigureAwardCounter();
            Common.assertTextOnPage(tool, "Reconfigure award counter");
            subscriberDashboard.clickSetAwardCounter();
            subscriberDashboard.clickConfirmAwardCounterReconfiguration();
            subscriberDashboard.clickRefreshRPO();
            Common.assertTextOnPage(tool, "2/4");

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
