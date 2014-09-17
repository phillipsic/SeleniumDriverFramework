package com.comverse.css.csr;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.ReconfigureBalanceCommon;

public class ReconfigureBalance extends ReconfigureBalanceCommon {

    public ReconfigureBalance(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
    }

    @Override
    public ReconfigureBalance setMoreUnitsForThisPeriod(String unitsToAdd) throws Exception {
        super.setMoreUnitsForThisPeriod(unitsToAdd);
        return new ReconfigureBalance(tool, test, user);
    }

    @Override
    public ReconfigureBalanceReview clickAddUnits() throws Exception {
        super.clickAddUnits();
        return new ReconfigureBalanceReview(tool, test, user);
    }

    @Override
    public ReconfigureBalance setCreditSpendingLimit(String limitValue) throws Exception {
        super.setCreditSpendingLimit(limitValue);
        return new ReconfigureBalance(tool, test, user);
    }

    @Override
    public ReconfigureBalance setCreditSpendingLimitUnlimited() throws Exception {
        super.setCreditSpendingLimitUnlimited();
        return new ReconfigureBalance(tool, test, user);
    }

    @Override
    public ReconfigureBalanceReview clickReconfigureBalance() throws Exception {
        super.clickReconfigureBalance();
        return new ReconfigureBalanceReview(tool, test, user);
    }

}
