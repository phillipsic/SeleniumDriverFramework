package com.comverse.css.csr;

import org.openqa.selenium.WebDriver;

import com.comverse.css.commonpages.ViewUnbilledRechargeCommon;

public class ViewUnbilledRecharge extends ViewUnbilledRechargeCommon {

    public ViewUnbilledRecharge(WebDriver driver) throws Exception {
        super(driver);

    }

    @Override
    public ViewRechargeDetails clickFirstRecharge() throws Exception {

        super.clickFirstRecharge();
        return new ViewRechargeDetails(driver);
    }

    @Override
    public UnbilledTransaction clickBack() throws Exception {

        super.clickBack();
        return new UnbilledTransaction(driver);
    }
}
