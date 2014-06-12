package com.comverse.css.csr.aca;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Prep;
import com.comverse.css.csr.*;
import com.comverse.data.apps.CSR;
import com.comverse.data.users.CSRAdmin;

public class ACA0030_View_RC_history extends CSSTest {
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
    public void testACA0030_View_RC_history() throws Exception {
        try {
            launchCSSApplicationAndSSOLogin();
            String accountNumberWithRC = preparation.readPropertyFromAccountPropertyFile("Invoice.RC");

            WorkSpace workSpace = new WorkSpace(tool, test, user);
            IdentifyCustomer manageAccount = workSpace.gotoManageAccount();
            AccountDetails accountDetails = manageAccount.gotoAccountDashboardUsingAccountID(accountNumberWithRC);
            // ViewInvoices viewInvocies =
            // accountDetails.clickBillsAndPayments();
            ViewTransactionHistory viewTransactionHistory = accountDetails.clickHistories();
            ViewRCHistory viewRCHistory = viewTransactionHistory.clickonRCHistory();
            viewRCHistory.enterToDateTodayFromDateMinus10();
            viewRCHistory.clickSearch();
            assertTrue("RC history found".equals(viewRCHistory.getSearchResults()));
            viewRCHistory.ViewRCTermDetails();

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
