package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class ViewInvoicesCommon extends CommonMenu {

    public ViewInvoicesCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "View invoices";
        // Check that we're on the right page.
        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);

        }

    }

    public ViewTransactionHistoryCommon clickTransactionHistory() throws Exception {

        tool.clickUsingID(tool, "mnu_HISTORIES");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new ViewTransactionHistoryCommon(tool, test, user);
    }

    public UnbilledTransactionCommon clickUnbilledTransacations() throws Exception {

        tool.clickUsingID(tool, "smnu_UNBILLED_TRANSACTIONS");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new UnbilledTransactionCommon(tool, test, user);
    }

    public ViewPaymentsCommon clickPayments() throws Exception {

        tool.clickUsingID(tool, "smnu_PAYMENTS");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new ViewPaymentsCommon(tool, test, user);
    }

    public ViewInvoiceDetailsCommon clickLastInvoice() throws Exception {

        tool.clickUsingXPath(tool, "//table[@id='listInvoices']/tbody/tr[2]/td/a");
        return new ViewInvoiceDetailsCommon(tool, test, user);
    }

    public ViewInvoiceDetailsCommon clickInvoiceNumber(String billrefnumber) throws Exception {

        tool.clickUsingLinkText(tool, billrefnumber);
        return new ViewInvoiceDetailsCommon(tool, test, user);
    }

    public RegisterBillPaymentCommon clickPayLastInvoice() throws Exception {

        tool.clickUsingLinkText(tool, "Pay invoice");
        return new RegisterBillPaymentCommon(tool, test, user);
    }

}
