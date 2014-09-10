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

public class EBP0070_Register_bill_payment extends CSSTest {
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
    public void testEBP0070_Register_bill_payment() throws Exception {
        try {
            Invoice invoice = new Invoice();
            launchCSSApplicationAndSSOLogin();
            String accountNumber = invoice.getAcct("BILLED.PAYMENT");

            WorkSpace workSpace = new WorkSpace(tool, test, user);
            IdentifyCustomer manageAccount = workSpace.gotoManageAccount();
            AccountDetails AccountDetailsCommon = manageAccount.gotoAccountDashboardUsingAccountID(accountNumber);
            ViewInvoices viewInvoices = AccountDetailsCommon.clickBillsAndPayments();
            Common.assertTextOnPage(tool, "invoices found");
            Common.assertTextOnPage(tool, "Last invoice");

            RegisterBillPayment registerBillPayment = viewInvoices.clickPayLastInvoice();
            registerBillPayment.enterAmount("0.1");
            registerBillPayment.selectPaymentMethod("CASH");

            registerBillPayment = registerBillPayment.clickContinue();
            Common.assertTextOnPage(tool, "0.1");
            Common.assertTextOnPage(tool, "Cash");

            registerBillPayment = registerBillPayment.clickConfirm();
            Common.assertTextOnPage(tool, "Payment for invoice has been successfully registered.");
            Common.assertTextOnPage(tool, "0.1");
            Common.assertTextOnPage(tool, "Cash");

            viewInvoices = registerBillPayment.clickBackToInvoices();

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