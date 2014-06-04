package com.comverse.css.csr;

import org.openqa.selenium.WebDriver;

import com.comverse.css.commonpages.ViewUnbilledUsageDetailsCommon;

public class ViewUnbilledUsageDetails extends ViewUnbilledUsageDetailsCommon {

    public ViewUnbilledUsageDetails(WebDriver driver) throws Exception {
        super(driver);

    }

    @Override
    public ViewUnbilledUsage clickBack() throws Exception {

        super.clickBack();
        return new ViewUnbilledUsage(driver);
    }
}
