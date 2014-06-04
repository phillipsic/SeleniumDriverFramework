package com.comverse.css.csr;

import org.openqa.selenium.WebDriver;

import com.comverse.css.commonpages.ViewInvoiceDetailsCommon;

public class ViewInvoiceDetails extends ViewInvoiceDetailsCommon {

    public ViewInvoiceDetails(WebDriver driver) throws Exception {
        super(driver);

    }

    @Override
    public ViewBilledMTR clickBilledMTR() throws Exception {
        super.clickBilledMTR();
        return new ViewBilledMTR(driver);
    }

    @Override
    public ViewBilledRecharges clickBilledRecharges() throws Exception {
        super.clickBilledRecharges();
        return new ViewBilledRecharges(driver);
    }

    @Override
    public ViewBilledRCNRCTerms clickBilledRCNRC() throws Exception {
        super.clickBilledRCNRC();
        return new ViewBilledRCNRCTerms(driver);
    }

    @Override
    public ViewInvoices clickBack() throws Exception {
        super.clickBack();
        return new ViewInvoices(driver);
    }

    @Override
    public ViewBilledUsage clickBilledUsages() throws Exception {
        super.clickBilledUsages();
        return new ViewBilledUsage(driver);
    }

    @Override
    public ViewPaymentDistributions clickPaymentDistribution() throws Exception {
        super.clickPaymentDistribution();
        return new ViewPaymentDistributions(driver);
    }

    @Override
    public InvoiceImageInText clickAsciiImage() throws Exception {
        super.clickAsciiImage();
        return new InvoiceImageInText(driver);
    }

    @Override
    public ViewInvoiceBalanceDetails clickBalanceName() throws Exception {
        super.clickBalanceName();
        return new ViewInvoiceBalanceDetails(driver);
    }
}
