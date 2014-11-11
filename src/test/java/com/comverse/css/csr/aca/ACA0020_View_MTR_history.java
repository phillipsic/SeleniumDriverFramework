package com.comverse.css.csr.aca;

import com.comverse.common.Invoice;
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

public class ACA0020_View_MTR_history extends CSSTest {

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
    public void testACA0020_View_MTR_history() throws Exception {

        try {
            Invoice invoice = new Invoice();

            launchCSSApplicationAndSSOLogin();
            String accountNumber = invoice.getAcct("BILLED.MTR");
            WorkSpace workSpace = new WorkSpace(tool, test, user);
            IdentifyCustomer manageAccount = workSpace.gotoManageAccount();
            AccountDetails accountDetails = manageAccount.gotoAccountDashboardUsingAccountID(accountNumber);
            ViewTransactionHistory viewTransactionHistory = accountDetails.clickHistories();
            // ViewTransactionHistory viewTransactionHistory =
            // viewInvocies.clickTransactionHistory();
            ViewMTRHistory viewMTRHistory = viewTransactionHistory.clickonMTRHistory();
            viewMTRHistory.enterToDateTodayFromDateMinus10();
            viewMTRHistory.clickSearch();
            Common.assertVerifyTrue(tool, "MTR history found".equals(viewMTRHistory.getSearchResults()));
            viewMTRHistory.ViewMTRDetails();
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
