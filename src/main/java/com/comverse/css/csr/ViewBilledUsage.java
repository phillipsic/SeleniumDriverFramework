package com.comverse.css.csr;

import org.openqa.selenium.WebDriver;

import com.comverse.css.commonpages.ViewBilledUsageCommon;

public class ViewBilledUsage extends ViewBilledUsageCommon {

    public ViewBilledUsage(WebDriver driver) throws Exception {
        super(driver);

    }

    @Override
    public ViewBilledUsage clickSearch() throws Exception {

        super.clickSearch();
        return new ViewBilledUsage(driver);
    }

    @Override
    public ViewBilledUsageDetails clickFirstUsage() throws Exception {

        super.clickFirstUsage();
        return new ViewBilledUsageDetails(driver);
    }

    @Override
    public ViewInvoiceDetails clickBack() throws Exception {

        super.clickBack();
        return new ViewInvoiceDetails(driver);
    }
}
