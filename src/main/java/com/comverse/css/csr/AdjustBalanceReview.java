package com.comverse.css.csr;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;
import com.comverse.css.commonpages.AdjustBalanceReviewCommon;

public class AdjustBalanceReview extends AdjustBalanceReviewCommon {

    public AdjustBalanceReview(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
    }

    @Override
    public AdjustBalanceRequestResult clickConfirm() throws Exception {  test.writeInLogFile(Common.getMethodName());

        super.clickConfirm();
        return new AdjustBalanceRequestResult(tool, test, user);
    }
}
