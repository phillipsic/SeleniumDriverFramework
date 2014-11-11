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

public class ACA0010_View_usage_history extends CSSTest {
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
    public void testACA0010_View_usage_history() throws Exception {
        try {
            Invoice invoice = new Invoice();
            launchCSSApplicationAndSSOLogin();

            String accountNumberWithInvoiceUsage = invoice.getAcct("BILLED.USAGE");

            WorkSpace workSpace = new WorkSpace(tool, test, user);
            IdentifyCustomer manageAccount = workSpace.gotoManageAccount();
            AccountDetails accountDetails = manageAccount.gotoAccountDashboardUsingAccountID(accountNumberWithInvoiceUsage);
            SubscriberDetails subscriberDetails = accountDetails.selectFirstSubscriberFromNavigationPanel();
            ViewTransactionHistory viewTransactionHistory = subscriberDetails.clickHistories();
            ViewUsageHistory viewUsageHistory = viewTransactionHistory.clickOnUsageHistory();
            viewUsageHistory.enterToDateTodayFromDateMinus20();
            test.setBugId("CBS00163146");
            viewUsageHistory.clickSearch();
            Common.assertVerifyTrue(tool, !"No data".equals(viewUsageHistory.getSearchResults()));
            test.setBugId("NoBug");
            viewUsageHistory.ViewUsageDetails();

            // Boris Stoyanov - Sometimes this test is failing to fund usage for
            // the given time frame ( 20 days back)
            // It can be related to non reliable data from the properties.

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
