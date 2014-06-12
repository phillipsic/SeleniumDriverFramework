package com.comverse.css.csr.ucd;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.css.csr.*;
import com.comverse.data.apps.CSR;
import com.comverse.data.users.CSRUser;

public class UCD0020_View_account_unbilled_adjustments extends CSSTest {
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
    public void testUCD0020_View_account_unbilled_adjustments() throws Exception {
        try {
            launchCSSApplicationAndSSOLogin();

            String accountNumber = preparation.readPropertyFromAccountPropertyFile("Unbilled.Adjustment");

            WorkSpace workSpace = new WorkSpace(tool, test, user);
            IdentifyCustomer manageAccount = workSpace.gotoManageAccount();
            AccountDetails accountDetails = manageAccount.gotoAccountDashboardUsingAccountID(accountNumber);
            ViewInvoices viewInvoices = accountDetails.clickBillsAndPayments();
            UnbilledTransaction unbilledTransaction = viewInvoices.clickUnbilledTransacations();

            ViewUnbilledAdjustment viewUnbilledAdjustment = unbilledTransaction.clickUnbilledAdjustment();

            Common.assertTextOnPage(tool, "Unbilled Adjustments");

            AdjustmentDetails adjustmentDetails = viewUnbilledAdjustment.clickFirstAdjustment();
            Common.assertTextOnPage(tool, "Adjustment type");

            viewUnbilledAdjustment = adjustmentDetails.clickBack();

            unbilledTransaction = viewUnbilledAdjustment.clickBack();

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
