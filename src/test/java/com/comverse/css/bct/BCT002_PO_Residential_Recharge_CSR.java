package com.comverse.css.bct;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.css.csr.*;
import com.comverse.data.apps.CSR;
import com.comverse.data.users.CSRAdmin;

public class BCT002_PO_Residential_Recharge_CSR extends CSSTest {

    @Before
    @Override
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new CSR();
        user = new CSRAdmin();
    }

    @Test
    public void testBCT002_PO_Residential_Recharge_CSR() throws Exception {
        launchCSSApplicationAndSSOLogin();
        String accountLastName = Common.getLastNameRechargableAccount();
        String rechargeAmount = "1";

        WorkSpace workSpace = new WorkSpace(driver);

        IdentifyCustomer manageAccount = workSpace.gotoManageAccount();
        AccountDetails accountDetails = manageAccount.searchByAccountLastNameSinglePerson(accountLastName);

        SubscriberDetails subscriberDashboard = accountDetails.selectFirstSubscriberFromNavigationPanel();

        ViewBalance viewBalance = subscriberDashboard.viewBalanceAndRecharge();

        Double coreBalanceBeforeRecharge = viewBalance.getCoreBalance();

        NonVoucherRecharge nonVoucherRecharge = viewBalance.clickNonVoucherRechargeFreeAmount();

        NonVoucherRechargeReview nonVoucherRechargeReview = nonVoucherRecharge.nonVoucherRechargeByCheck(rechargeAmount);

        RechargeSubscriber rechargeSubscriber = nonVoucherRechargeReview.confirmNonVoucherRecharge();

        assertTrue(rechargeSubscriber.getRechargeClass().matches("^[\\s\\S]*Check[\\s\\S]*$"));

        viewBalance = rechargeSubscriber.clickViewBalances();

        Double expectedCoreBalanceAfterRecharge = coreBalanceBeforeRecharge + Double.parseDouble(rechargeAmount);

        Double coreBalanceAfterRecharge = viewBalance.getCoreBalance();

        assertEquals(expectedCoreBalanceAfterRecharge, coreBalanceAfterRecharge);

        test.setResult("pass");
    }

    @After
    @Override
    public void tearDown() throws Exception {
        super.tearDown();
    }
}
