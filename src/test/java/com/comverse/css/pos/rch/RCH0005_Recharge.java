package com.comverse.css.pos.rch;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.css.pos.*;
import com.comverse.data.apps.POS;
import com.comverse.data.users.TelcoRetailerUser;

public class RCH0005_Recharge extends CSSTest {
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    @Override
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new POS();
        user = new TelcoRetailerUser();
    }

    @Test
    public void testRCH0005_Recharge() throws Exception {
        try {
            launchCSSApplication();
            String accountLastName = Common.getLastNameRechargableAccount();
            String voucherNumber = Common.getRechargeVoucher();
            MyShapeChannel loginPage = new MyShapeChannel(tool, test, user);
            WorkSpace workSpace = loginPage.loginToPOS(user);

            IdentifyCustomer manageAccount = workSpace.gotoManageAccount();
            AccountDetails accountDetails = manageAccount.gotoAccountDashboardUsingAccountLastName(accountLastName);

            SubscriberDetails subscriberDashboard = accountDetails.selectFirstSubscriberFromNavigationPanel();

            ViewBalance viewBalance = subscriberDashboard.viewBalanceAndRecharge();

            viewBalance.getCoreBalance();

            RechargeWithVoucher rechargeWithVoucher = viewBalance.clickRechargeByVoucher();
            rechargeWithVoucher.enterVoucherNumber(voucherNumber);
            RechargeSubscriber rechargeSubscriber = rechargeWithVoucher.clickContinue();

            Common.assertTextOnPage(tool, "has been successfully recharged");
            viewBalance = rechargeSubscriber.clickViewBalances();

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
