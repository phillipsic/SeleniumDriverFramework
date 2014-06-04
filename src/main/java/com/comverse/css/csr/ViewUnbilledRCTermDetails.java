package com.comverse.css.csr;

import org.openqa.selenium.WebDriver;

import com.comverse.css.commonpages.ViewUnbilledRCTermDetailsCommon;

public class ViewUnbilledRCTermDetails extends ViewUnbilledRCTermDetailsCommon {

    public ViewUnbilledRCTermDetails(WebDriver driver) throws Exception {
        super(driver);

    }

    @Override
    public ViewUnbilledRCNRC clickBack() throws Exception {

        super.clickBack();
        return new ViewUnbilledRCNRC(driver);
    }
}
