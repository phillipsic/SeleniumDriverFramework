package com.comverse.css.csr;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.AddStandaloneChargeCommon;

public class AddStandaloneCharge extends AddStandaloneChargeCommon {

    public AddStandaloneCharge(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
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
