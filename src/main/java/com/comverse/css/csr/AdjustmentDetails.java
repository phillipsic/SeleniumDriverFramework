package com.comverse.css.csr;

import org.openqa.selenium.WebDriver;

import com.comverse.css.commonpages.AdjustmentDetailsCommon;

public class AdjustmentDetails extends AdjustmentDetailsCommon {

    public AdjustmentDetails(WebDriver driver) throws Exception {

        super(driver);

    }

    @Override
    public ViewUnbilledAdjustment clickBack() throws Exception {

        super.clickBack();
        return new ViewUnbilledAdjustment(driver);
    }
}
