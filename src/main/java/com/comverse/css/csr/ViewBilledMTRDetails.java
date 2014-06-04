package com.comverse.css.csr;

import org.openqa.selenium.WebDriver;

import com.comverse.css.commonpages.ViewBilledMTRDetailsCommon;

public class ViewBilledMTRDetails extends ViewBilledMTRDetailsCommon {

    public ViewBilledMTRDetails(WebDriver driver) throws Exception {
        super(driver);

    }

    @Override
    public ViewBilledMTR clickBack() throws Exception {

        super.clickBack();
        return new ViewBilledMTR(driver);
    }
}
