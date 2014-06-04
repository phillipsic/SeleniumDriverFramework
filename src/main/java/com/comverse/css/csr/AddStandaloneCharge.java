package com.comverse.css.csr;

import org.openqa.selenium.WebDriver;

import com.comverse.css.commonpages.AddStandaloneChargeCommon;

public class AddStandaloneCharge extends AddStandaloneChargeCommon {

    public AddStandaloneCharge(WebDriver driver) throws Exception {
        super(driver);

    }

    @Override
    public void selectEventTypeDispatch() throws Exception {
        super.selectEventTypeDispatch();
    }

    public void VerifyNRCInUnbilledTransactions() {
        super.verifyNRCInUnbilledTransaction();
    }

    @Override
    public void confirmStandaloneCharge() throws Exception {
        super.confirmStandaloneCharge();
    }

    @Override
    public void selectNRCTypeDispatchFee() throws Exception {
        super.selectNRCTypeDispatchFee();
    }

}
