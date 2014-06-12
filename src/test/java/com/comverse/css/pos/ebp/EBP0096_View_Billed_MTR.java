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
import com.comverse.data.users.TelcoRetailerAdmin;

public class EBP0096_View_Billed_MTR extends CSSTest {
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
    public void testEBP0096_View_Billed_MTR() throws Exception {
        try {
            launchCSSApplication();

            String accountNumber = preparation.readPropertyFromAccountPropertyFile("Invoice.MTR");

            MyShapeChannel loginPage = new MyShapeChannel(tool, test, user);
            WorkSpace workSpace = loginPage.loginToPOS(user);
            IdentifyCustomer manageAccount = workSpace.gotoManageAccount();
            AccountDetails AccountDetailsCommon = manageAccount.gotoAccountDashboardUsingAccountID(accountNumber);
            ViewInvoices viewInvoices = AccountDetailsCommon.clickBillsAndPayments();
            Common.assertTextOnPage(tool, "invoices found");
            Common.assertTextOnPage(tool, "Last invoice");

            ViewInvoiceDetails viewInvoiceDetails = viewInvoices.clickLastInvoice();
            ViewBilledMTR viewBilledMTR = viewInvoiceDetails.clickBilledMTR();

            ViewBilledMTRDetails viewBilledMTRDetails = viewBilledMTR.clickFirstMTR();
            Common.assertTextOnPage(tool, "Impacted Balances");

            viewBilledMTR = viewBilledMTRDetails.clickBack();

            viewInvoiceDetails = viewBilledMTR.clickBack();

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