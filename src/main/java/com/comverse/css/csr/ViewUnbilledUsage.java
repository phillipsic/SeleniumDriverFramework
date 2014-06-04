package com.comverse.css.csr;

import org.openqa.selenium.WebDriver;

import com.comverse.css.commonpages.ViewUnbilledUsageCommon;

public class ViewUnbilledUsage extends ViewUnbilledUsageCommon {

    public ViewUnbilledUsage(WebDriver driver) throws Exception {
        super(driver);

    }

    @Override
    public ViewUnbilledUsage clickSearch() throws Exception {

        super.clickSearch();
        return new ViewUnbilledUsage(driver);
    }

    @Override
    public ViewUnbilledUsageDetails clickFirstUsage() throws Exception {

        super.clickFirstUsage();
        return new ViewUnbilledUsageDetails(driver);
    }

    @Override
    public UnbilledTransaction clickBack() throws Exception {

        super.clickBack();
        return new UnbilledTransaction(driver);
    }
}
