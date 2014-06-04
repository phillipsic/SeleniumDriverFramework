package com.comverse.css.csr;

import org.openqa.selenium.WebDriver;

import com.comverse.css.commonpages.ViewPaymentDistributionsCommon;

public class ViewPaymentDistributions extends ViewPaymentDistributionsCommon {

    public ViewPaymentDistributions(WebDriver driver) throws Exception {
        super(driver);

    }

    @Override
    public ViewInvoiceDetails clickBack() throws Exception {

        super.clickBack();
        return new ViewInvoiceDetails(driver);
    }
}
