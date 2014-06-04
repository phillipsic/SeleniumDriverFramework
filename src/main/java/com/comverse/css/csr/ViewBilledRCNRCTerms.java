package com.comverse.css.csr;

import org.openqa.selenium.WebDriver;

import com.comverse.css.commonpages.ViewBilledRCNRCTermsCommon;

public class ViewBilledRCNRCTerms extends ViewBilledRCNRCTermsCommon {

    public ViewBilledRCNRCTerms(WebDriver driver) throws Exception {
        super(driver);

    }

    @Override
    public ViewBilledRCNRCTermDetails clickFirstRCTerm() throws Exception {

        super.clickFirstRCTerm();
        return new ViewBilledRCNRCTermDetails(driver);
    }

    @Override
    public ViewInvoiceDetails clickBack() throws Exception {

        super.clickBack();
        return new ViewInvoiceDetails(driver);
    }
}
