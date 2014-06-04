package com.comverse.css.csr;

import org.openqa.selenium.WebDriver;

import com.comverse.css.commonpages.ViewBilledRCNRCTermDetailsCommon;

public class ViewBilledRCNRCTermDetails extends ViewBilledRCNRCTermDetailsCommon {

    public ViewBilledRCNRCTermDetails(WebDriver driver) throws Exception {
        super(driver);

    }

    @Override
    public ViewBilledRCNRCTerms clickBack() throws Exception {

        super.clickBack();
        return new ViewBilledRCNRCTerms(driver);
    }
}
