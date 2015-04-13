package com.company.css.bct;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.framework.app.common.AppTest;
import com.framework.app.common.Common;
import com.framework.app.common.Prep;
import com.company.css.csr.*;
import com.company.data.apps.CSR;
import com.company.data.users.CSRAdmin;

public class BCT002_PO_Residential_Recharge_CSR extends AppTest {

    @Before
    @Override
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new CSR();
        user = new CSRAdmin();
    }

    @AppTest
    public void testBCT002_PO_Residential_Recharge_CSR() throws Exception {
        launchCSSApplicationAndSSOLogin();
        String accountLastName = Common.getLastNameRechargableAccount();
        String rechargeAmount = "1";

        WorkSpace workSpace = new WorkSpace(tool, test, user);

        IdentifyCustomer manageAccount = workSpace.gotoManageAccount();
        AccountDetails accountDetails = manageAccount.searchByAccountLastNameSinglePerson(accountLastName);

        SubscriberDetails subscriberDashboard = accountDetails.selectFirstSubscriberFromNavigationPanel();

        ViewBalance viewBalance = subscriberDashboard.viewBalanceAndRecharge();

        Double coreBalanceBeforeRecharge = viewBalance.getCoreBalance();

        NonVoucherRecharge nonVoucherRecharge = viewBalance.clickNonVoucherRechargeFreeAmount();

        NonVoucherRechargeReview nonVoucherRechargeReview = nonVoucherRecharge.nonVoucherRechargeByCheck(rechargeAmount);

        RechargeSubscriber rechargeSubscriber = nonVoucherRechargeReview.confirmNonVoucherRecharge();

        Common.assertVerifyTrue(tool, rechargeSubscriber.getRechargeClass().matches("^[\\s\\S]*Check[\\s\\S]*$"));

        viewBalance = rechargeSubscriber.clickViewBalances();

        Double expectedCoreBalanceAfterRecharge = coreBalanceBeforeRecharge + Double.parseDouble(rechargeAmount);

        Double coreBalanceAfterRecharge = viewBalance.getCoreBalance();

        Common.assertTextEquals(expectedCoreBalanceAfterRecharge, coreBalanceAfterRecharge);

        test.setResult("pass");
    }

    @After
    @Override
    public void tearDown() throws Exception {
        super.tearDown();
    }
}
