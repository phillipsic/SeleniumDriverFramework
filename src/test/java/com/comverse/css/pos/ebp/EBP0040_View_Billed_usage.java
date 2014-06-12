package com.comverse.css.pos.ebp;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.css.pos.*;
import com.comverse.data.apps.POS;
import com.comverse.data.users.TelcoRetailerAdmin;

public class EBP0040_View_Billed_usage extends CSSTest {
    private StringBuffer verificationErrors = new StringBuffer();

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new POS();
        user = new TelcoRetailerAdmin();
    }

    @Test
    public void testEBP0040_View_Billed_usage() throws Exception {
        try {
            launchCSSApplication();

            String accountNumber = preparation.readPropertyFromAccountPropertyFile("Invoice.Usage");

            MyShapeChannel loginPage = new MyShapeChannel(tool, test, user);
            WorkSpace workSpace = loginPage.loginToPOS(user);
            IdentifyCustomer manageAccount = workSpace.gotoManageAccount();
            AccountDetails AccountDetailsCommon = manageAccount.gotoAccountDashboardUsingAccountID(accountNumber);
            ViewInvoices viewInvoices = AccountDetailsCommon.clickBillsAndPayments();
            ViewInvoiceDetails viewInvoiceDetails = viewInvoices.clickLastInvoice();

            ViewBilledUsage viewBilledUsage = viewInvoiceDetails.clickBilledUsages();
            viewBilledUsage.enterFromDate("01/01/2010");
            viewBilledUsage = viewBilledUsage.clickSearch();
            assertTrue(Common.isTextNotOnPage(tool, "No data"));
            Common.assertTextOnPage(tool, "Billed usages of the invoice");
            Common.assertTextOnPage(tool, "Usage Date/Time");

            viewInvoiceDetails = viewBilledUsage.clickBack();

            viewInvoices = viewInvoiceDetails.clickBack();
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