package com.comverse.css.pos.ebp;

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

public class EBP0140_View_unbilled_recharges extends CSSTest {
    private StringBuffer verificationErrors = new StringBuffer();

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new POS();
        user = new TelcoRetailerUser();
    }

    @Test
    public void testEBP0140_View_unbilled_recharges() throws Exception {
        try {
            launchCSSApplication();

            String accountNumber = preparation.readPropertyFromAccountPropertyFile("Unbilled.Recharge");

            MyShapeChannel loginPage = new MyShapeChannel(tool, test, user);
            WorkSpace workSpace = loginPage.loginToPOS(user);
            IdentifyCustomer manageAccount = workSpace.gotoManageAccount();
            AccountDetails AccountDetailsCommon = manageAccount.gotoAccountDashboardUsingAccountID(accountNumber);
            ViewInvoices viewInvoices = AccountDetailsCommon.clickBillsAndPayments();

            UnbilledTransaction unbilledTransaction = viewInvoices.clickUnbilledTransacations();

            ViewUnbilledRecharge viewUnbilledRecharge = unbilledTransaction.clickUnbilledRecharge();
            Common.assertTextOnPage(tool, "Unbilled Recharges");

            ViewRechargeDetails viewRechargeDetails = viewUnbilledRecharge.clickFirstRecharge();
            Common.assertTextOnPage(tool, "Recharge Details");
            Common.assertTextOnPage(tool, "Impacted Balances");

            viewUnbilledRecharge = viewRechargeDetails.clickBack();
            unbilledTransaction = viewUnbilledRecharge.clickBack();

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
