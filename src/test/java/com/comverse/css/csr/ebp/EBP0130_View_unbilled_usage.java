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

public class EBP0130_View_unbilled_usage extends CSSTest {
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
    public void testEBP0130_View_unbilled_usage() throws Exception {
        try {
            Invoice invoice = new Invoice();
            String accountNumber = invoice.getAcct("UNBILLED.USAGE");
            launchCSSApplicationAndSSOLogin();

            WorkSpace workSpace = new WorkSpace(tool, test, user);
            IdentifyCustomer manageAccount = workSpace.gotoManageAccount();
            AccountDetails accountDetails = manageAccount.gotoAccountDashboardUsingAccountID(accountNumber);
            ViewInvoices viewInvoices = accountDetails.clickBillsAndPayments();
            UnbilledTransaction unbilledTransaction = viewInvoices.clickUnbilledTransacations();
            ViewUnbilledUsage viewUnbilledUsage = unbilledTransaction.clickUnbilledUsage();

            viewUnbilledUsage.enterFromDate("01/01/2010");
            viewUnbilledUsage = viewUnbilledUsage.clickSearch();

            Common.assertTextOnPage(tool, "Unbilled usage found");

            ViewUnbilledUsageDetails viewUnbilledUsageDetails = viewUnbilledUsage.clickFirstUsage();
            Common.assertTextOnPage(tool, "Unbilled usage details");
            Common.assertTextOnPage(tool, "Impacted balances by this usage");

            test.setBugId("CBS00165925");
            viewUnbilledUsage = viewUnbilledUsageDetails.clickBack();
            test.setBugId("NoBug");
            unbilledTransaction = viewUnbilledUsage.clickBack();

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
