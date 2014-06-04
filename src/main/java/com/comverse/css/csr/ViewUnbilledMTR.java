package com.comverse.css.csr;

import org.openqa.selenium.WebDriver;

import com.comverse.css.commonpages.ViewUnbilledMTRCommon;

public class ViewUnbilledMTR extends ViewUnbilledMTRCommon {

    public ViewUnbilledMTR(WebDriver driver) throws Exception {
        super(driver);

    }

    @Override
    public ViewUnbilledMTRDetails clickFirstMTR() throws Exception {

        super.clickFirstMTR();
        return new ViewUnbilledMTRDetails(driver);
    }

    @Override
    public UnbilledTransaction clickBack() throws Exception {

        super.clickBack();
        return new UnbilledTransaction(driver);
    }
}
