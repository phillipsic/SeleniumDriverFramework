package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class ViewInvoicesCommon extends CommonMenu {

    public ViewInvoicesCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

        String currentScreen = tool.getTitle();
        String expectedScreen = "View invoices";
        // Check that we're on the right page.
        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");

        }

    }

    public ViewTransactionHistoryCommon clickTransactionHistory() throws Exception {
        test.writeInLog(Common.getMethodName());

        tool.clickUsingID("mnu_HISTORIES");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new ViewTransactionHistoryCommon(tool, test, user);
    }

    public UnbilledTransactionCommon clickUnbilledTransacations() throws Exception {
        test.writeInLog(Common.getMethodName());

        tool.clickUsingID("smnu_UNBILLED_TRANSACTIONS");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new UnbilledTransactionCommon(tool, test, user);
    }

    public ViewPaymentsCommon clickPayments() throws Exception {
        test.writeInLog(Common.getMethodName());

        tool.clickUsingID("smnu_PAYMENTS");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new ViewPaymentsCommon(tool, test, user);
    }

    public ViewInvoiceDetailsCommon clickLastInvoice() throws Exception {
        test.writeInLog(Common.getMethodName());

        tool.clickUsingXPath("//table[@id='listInvoices']/tbody/tr[2]/td/a");
        return new ViewInvoiceDetailsCommon(tool, test, user);
    }

    public ViewInvoiceDetailsCommon clickInvoiceNumber(String billrefnumber) throws Exception {
        test.writeInLog(Common.getMethodName());

        tool.clickUsingLinkText(billrefnumber);
        return new ViewInvoiceDetailsCommon(tool, test, user);
    }

    public RegisterBillPaymentCommon clickPayLastInvoice() throws Exception {
        test.writeInLog(Common.getMethodName());

        tool.clickUsingLinkText("Pay invoice");
        return new RegisterBillPaymentCommon(tool, test, user);
    }

}
