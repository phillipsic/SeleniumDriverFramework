package com.comverse.css.b2b;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;
import com.comverse.css.commonpages.ViewInvoicesCommon;

public class ViewInvoices extends ViewInvoicesCommon {

    public ViewInvoices(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

    }

    @Override
    public ViewTransactionHistory clickTransactionHistory() throws Exception {  test.writeInLog(Common.getMethodName());

        super.clickTransactionHistory();
        return new ViewTransactionHistory(tool, test, user);
    }

    @Override
    public UnbilledTransaction clickUnbilledTransacations() throws Exception {  test.writeInLog(Common.getMethodName());

        super.clickUnbilledTransacations();
        return new UnbilledTransaction(tool, test, user);
    }

    @Override
    public ViewInvoiceDetails clickLastInvoice() throws Exception {  test.writeInLog(Common.getMethodName());

        super.clickLastInvoice();
        return new ViewInvoiceDetails(tool, test, user);
    }

    @Override
    public RegisterBillPayment clickPayLastInvoice() throws Exception {  test.writeInLog(Common.getMethodName());

        super.clickPayLastInvoice();
        return new RegisterBillPayment(tool, test, user);
    }

    @Override
    public ViewPayments clickPayments() throws Exception {  test.writeInLog(Common.getMethodName());

        super.clickPayments();
        return new ViewPayments(tool, test, user);
    }

    @Override
    public ViewInvoiceDetails clickInvoiceNumber(String billrefnumber) throws Exception {  test.writeInLog(Common.getMethodName());

        super.clickInvoiceNumber(billrefnumber);
        return new ViewInvoiceDetails(tool, test, user);
    }
}
