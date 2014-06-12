package com.comverse.css.csr;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.ViewInvoicesCommon;

public class ViewInvoices extends ViewInvoicesCommon {

    public ViewInvoices(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
    }

    @Override
    public ViewTransactionHistory clickTransactionHistory() throws Exception {
        super.clickTransactionHistory();
        return new ViewTransactionHistory(tool, test, user);
    }

    @Override
    public UnbilledTransaction clickUnbilledTransacations() throws Exception {
        super.clickUnbilledTransacations();
        return new UnbilledTransaction(tool, test, user);
    }

    @Override
    public ViewInvoiceDetails clickLastInvoice() throws Exception {
        super.clickLastInvoice();
        return new ViewInvoiceDetails(tool, test, user);
    }

    @Override
    public RegisterBillPayment clickPayLastInvoice() throws Exception {
        super.clickPayLastInvoice();
        return new RegisterBillPayment(tool, test, user);
    }

    @Override
    public ViewPayments clickPayments() throws Exception {
        super.clickPayments();
        return new ViewPayments(tool, test, user);
    }

    @Override
    public ViewInvoiceDetails clickInvoiceNumber(String billrefnumber) throws Exception {
        super.clickInvoiceNumber(billrefnumber);
        return new ViewInvoiceDetails(tool, test, user);
    }
}
