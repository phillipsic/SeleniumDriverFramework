package com.comverse.css.csr;

import org.openqa.selenium.WebDriver;

import com.comverse.css.commonpages.ViewBilledRechargesCommon;

public class ViewBilledRecharges extends ViewBilledRechargesCommon {

    public ViewBilledRecharges(WebDriver driver) throws Exception {
        super(driver);

    }

    @Override
    public ViewRechargeDetails clickFirstRecharge() throws Exception {

        super.clickFirstRecharge();
        return new ViewRechargeDetails(driver);
    }
}
