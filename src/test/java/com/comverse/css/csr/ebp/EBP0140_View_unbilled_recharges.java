package com.comverse.css.csr.ebp;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.common.Invoice;
import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.css.csr.*;
import com.comverse.data.apps.CSR;
import com.comverse.data.users.CSRUser;

public class EBP0140_View_unbilled_recharges extends CSSTest {
    private StringBuffer verificationErrors = new StringBuffer();

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new CSR();
        user = new CSRUser();
    }

    @Test
    public void testEBP0140_View_unbilled_recharges() throws Exception {
        try {
            Invoice invoice = new Invoice();
            String accountNumber = invoice.getAcct("UNBILLED.RECHARGE");
            launchCSSApplicationAndSSOLogin();

            WorkSpace workSpace = new WorkSpace(tool, test, user);
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
