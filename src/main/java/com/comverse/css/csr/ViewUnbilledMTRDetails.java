package com.comverse.css.csr;

import org.openqa.selenium.WebDriver;

import com.comverse.css.commonpages.ViewUnbilledMTRDetailsCommon;

public class ViewUnbilledMTRDetails extends ViewUnbilledMTRDetailsCommon {

    public ViewUnbilledMTRDetails(WebDriver driver) throws Exception {
        super(driver);

    }

    @Override
    public ViewUnbilledMTR clickBack() throws Exception {

        super.clickBack();
        return new ViewUnbilledMTR(driver);
    }
}
