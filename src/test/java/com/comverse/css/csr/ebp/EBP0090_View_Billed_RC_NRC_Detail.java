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
import com.comverse.data.users.CSRAdmin;

public class EBP0090_View_Billed_RC_NRC_Detail extends CSSTest {
    private StringBuffer verificationErrors = new StringBuffer();

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new CSR();
        user = new CSRAdmin();
    }

    @Test
    public void testEBP0090_View_Billed_RC_NRC_Detail() throws Exception {
        try {
            Invoice invoice = new Invoice();
            String accountNumber = invoice.getAcct("BILLED.RC");
            launchCSSApplicationAndSSOLogin();

            WorkSpace workSpace = new WorkSpace(tool, test, user);
            IdentifyCustomer manageAccount = workSpace.gotoManageAccount();
            AccountDetails AccountDetailsCommon = manageAccount.gotoAccountDashboardUsingAccountID(accountNumber);
            ViewInvoices viewInvoices = AccountDetailsCommon.clickBillsAndPayments();
            ViewInvoiceDetails viewInvoiceDetails = viewInvoices.clickLastInvoice();

            ViewBilledRCNRCTerms viewBilledRCNRCTerms = viewInvoiceDetails.clickBilledRCNRC();
            Common.assertTextOnPage(tool, "Billed RC/NRC terms for invoice");
            Common.assertTextOnPage(tool, "Non recurring charges:");
            Common.assertTextOnPage(tool, "Recurring charges:");

            ViewBilledRCNRCTermDetails viewBilledRCNRCTermDetails = viewBilledRCNRCTerms.clickFirstRCTerm();
            Common.assertTextOnPage(tool, "Billed RC/NRC term details");
            Common.assertTextOnPage(tool, "Impacted Balances");
            Common.assertTextOnPage(tool, "Adjustments");

            viewBilledRCNRCTerms = viewBilledRCNRCTermDetails.clickBack();

            viewInvoiceDetails = viewBilledRCNRCTerms.clickBack();
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