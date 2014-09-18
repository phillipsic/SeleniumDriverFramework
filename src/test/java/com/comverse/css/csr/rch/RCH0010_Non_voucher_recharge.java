package com.comverse.css.csr.rch;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.css.csr.*;
import com.comverse.data.apps.CSR;
import com.comverse.data.users.CSRAdmin;

public class RCH0010_Non_voucher_recharge extends CSSTest {
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
    public void testRCH0010_Non_voucher_recharge() throws Exception {
        try {
            launchCSSApplicationAndSSOLogin();
            String accountLastName = Common.getLastNameRechargableAccount();
            String rechargeAmount = "1";
            WorkSpace workSpace = new WorkSpace(tool, test, user);

            IdentifyCustomer manageAccount = workSpace.gotoManageAccount();
            AccountDetails accountDetails = manageAccount.gotoAccountDashboardUsingAccountLastName(accountLastName);

            SubscriberDetails subscriberDashboard = accountDetails.selectFirstSubscriberFromNavigationPanel();

            ViewBalance viewBalance = subscriberDashboard.viewBalanceAndRecharge();

            Double coreBalanceBeforeRecharge = viewBalance.getCoreBalance();

            NonVoucherRecharge nonVoucherRecharge = viewBalance.clickNonVoucherRechargeFreeAmount();

            nonVoucherRecharge.enterRechargeAmount(rechargeAmount);
            nonVoucherRecharge.selectPaymentMethodCash();

            NonVoucherRechargeReview nonVoucherRechargeReview = nonVoucherRecharge.clickContinueExpectingNonVoucherRechargeReview();

            RechargeSubscriber rechargeSubscriber = nonVoucherRechargeReview.confirmNonVoucherRecharge();

            viewBalance = rechargeSubscriber.clickViewBalances();

            Double expectedCoreBalanceAfterRecharge = coreBalanceBeforeRecharge + Double.parseDouble(rechargeAmount);

            Double coreBalanceAfterRecharge = viewBalance.getCoreBalance();

            Common.assertTextEquals(expectedCoreBalanceAfterRecharge, coreBalanceAfterRecharge);

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
