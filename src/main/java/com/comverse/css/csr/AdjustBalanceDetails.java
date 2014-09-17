package com.comverse.css.csr;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;
import com.comverse.css.commonpages.AdjustBalanceDetailsCommon;

public class AdjustBalanceDetails extends AdjustBalanceDetailsCommon {

    public AdjustBalanceDetails(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
    }

    @Override
    public AdjustBalanceReview clickContinue() throws Exception {  test.writeInLogFile(Common.getMethodName());

        super.clickContinue();
        return new AdjustBalanceReview(tool, test, user);
    }
}
