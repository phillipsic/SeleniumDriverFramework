package com.comverse.css.csr;

import org.openqa.selenium.WebDriver;

import com.comverse.css.commonpages.ViewUnbilledRCNRCCommon;

public class ViewUnbilledRCNRC extends ViewUnbilledRCNRCCommon {

    public ViewUnbilledRCNRC(WebDriver driver) throws Exception {
        super(driver);

    }

    @Override
    public ViewUnbilledRCTermDetails clickFirstRCTerm() throws Exception {

        super.clickFirstRCTerm();
        return new ViewUnbilledRCTermDetails(driver);
    }

    @Override
    public UnbilledTransaction clickBack() throws Exception {

        super.clickBack();
        return new UnbilledTransaction(driver);
    }
}
