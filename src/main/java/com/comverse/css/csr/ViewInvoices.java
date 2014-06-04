package com.comverse.css.csr;

import org.openqa.selenium.WebDriver;

import com.comverse.css.commonpages.ViewInvoicesCommon;

public class ViewInvoices extends ViewInvoicesCommon {

    public ViewInvoices(WebDriver driver) throws Exception {
        super(driver);

    }

    @Override
    public ViewTransactionHistory clickTransactionHistory() throws Exception {

        super.clickTransactionHistory();
        return new ViewTransactionHistory(driver);
    }

    @Override
    public UnbilledTransaction clickUnbilledTransacations() throws Exception {

        super.clickUnbilledTransacations();
        return new UnbilledTransaction(driver);
    }

    @Override
    public ViewInvoiceDetails clickLastInvoice() throws Exception {

        super.clickLastInvoice();
        return new ViewInvoiceDetails(driver);
    }

    @Override
    public RegisterBillPayment clickPayLastInvoice() throws Exception {

        super.clickPayLastInvoice();
        return new RegisterBillPayment(driver);
    }

    @Override
    public ViewPayments clickPayments() throws Exception {

        super.clickPayments();
        return new ViewPayments(driver);
    }

    @Override
    public ViewInvoiceDetails clickInvoiceNumber(String billrefnumber) throws Exception {
        super.clickInvoiceNumber(billrefnumber);
        return new ViewInvoiceDetails(driver);
    }
}
