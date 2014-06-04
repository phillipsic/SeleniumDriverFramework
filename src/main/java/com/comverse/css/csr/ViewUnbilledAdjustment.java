package com.comverse.css.csr;

import org.openqa.selenium.WebDriver;

import com.comverse.css.commonpages.ViewUnbilledAdjustmentCommon;

public class ViewUnbilledAdjustment extends ViewUnbilledAdjustmentCommon {

    public ViewUnbilledAdjustment(WebDriver driver) throws Exception {
        super(driver);

    }

    @Override
    public AdjustmentDetails clickFirstAdjustment() throws Exception {

        super.clickFirstAdjustment();
        return new AdjustmentDetails(driver);
    }

    @Override
    public UnbilledTransaction clickBack() throws Exception {

        super.clickBack();
        return new UnbilledTransaction(driver);
    }
}
