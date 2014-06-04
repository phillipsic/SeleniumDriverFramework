package com.comverse.css.csr;

import org.openqa.selenium.WebDriver;

import com.comverse.css.commonpages.ViewRechargeDetailsCommon;

public class ViewRechargeDetails extends ViewRechargeDetailsCommon {

    public ViewRechargeDetails(WebDriver driver) throws Exception {

        super(driver);

    }

    @Override
    public ViewUnbilledRecharge clickBack() throws Exception {

        super.clickBack();
        return new ViewUnbilledRecharge(driver);
    }
}
