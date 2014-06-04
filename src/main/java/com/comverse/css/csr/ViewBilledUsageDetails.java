package com.comverse.css.csr;

import org.openqa.selenium.WebDriver;

import com.comverse.css.commonpages.ViewBilledUsageDetailsCommon;

public class ViewBilledUsageDetails extends ViewBilledUsageDetailsCommon {

    public ViewBilledUsageDetails(WebDriver driver) throws Exception {
        super(driver);

    }

    @Override
    public ViewBilledUsage clickBack() throws Exception {

        super.clickBack();
        return new ViewBilledUsage(driver);
    }
}
