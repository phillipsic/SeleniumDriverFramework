package com.comverse.css.csr;

import org.openqa.selenium.WebDriver;

import com.comverse.css.commonpages.UnbilledTransactionCommon;

public class UnbilledTransaction extends UnbilledTransactionCommon {

    public UnbilledTransaction(WebDriver driver) throws Exception {
        super(driver);

    }

    @Override
    public ViewUnbilledMTR clickUnbilledMTR() throws Exception {

        super.clickUnbilledMTR();
        return new ViewUnbilledMTR(driver);
    }

    @Override
    public ViewUnbilledRecharge clickUnbilledRecharge() throws Exception {

        super.clickUnbilledRecharge();
        return new ViewUnbilledRecharge(driver);
    }

    @Override
    public ViewUnbilledUsage clickUnbilledUsage() throws Exception {

        super.clickUnbilledUsage();
        return new ViewUnbilledUsage(driver);
    }

    @Override
    public ViewUnbilledRCNRC clickUnbilledRCNRC() throws Exception {

        super.clickUnbilledRCNRC();
        return new ViewUnbilledRCNRC(driver);
    }

    @Override
    public ViewUnbilledAdjustment clickUnbilledAdjustment() throws Exception {

        super.clickUnbilledAdjustment();
        return new ViewUnbilledAdjustment(driver);
    }
}
