package com.comverse.css.pos;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.ReconfigureBalanceCommon;

public class ReconfigureBalance extends ReconfigureBalanceCommon {

    public ReconfigureBalance(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
    }

    @Override
    public ReconfigureBalanceReview clickReconfigureBalance() throws Exception {

        super.clickReconfigureBalance();
        return new ReconfigureBalanceReview(tool, test, user);
    }

    @Override
    public ReconfigureBalanceReview clickAddUnits() throws Exception {

        super.clickAddUnits();
        return new ReconfigureBalanceReview(tool, test, user);
    }

}
