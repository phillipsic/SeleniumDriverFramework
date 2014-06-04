package com.comverse.css.csr;

import org.openqa.selenium.WebDriver;

import com.comverse.css.commonpages.ViewBilledMTRCommon;

public class ViewBilledMTR extends ViewBilledMTRCommon {

    public ViewBilledMTR(WebDriver driver) throws Exception {
        super(driver);

    }

    @Override
    public ViewBilledMTRDetails clickFirstMTR() throws Exception {

        super.clickFirstMTR();
        return new ViewBilledMTRDetails(driver);
    }

    @Override
    public ViewInvoiceDetails clickBack() throws Exception {

        super.clickBack();
        return new ViewInvoiceDetails(driver);
    }
}
