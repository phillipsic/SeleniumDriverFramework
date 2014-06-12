package com.comverse.css.pos;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.ReconfigureBalanceReviewCommon;

public class ReconfigureBalanceReview extends ReconfigureBalanceReviewCommon {

    public ReconfigureBalanceReview(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
    }

    @Override
    public ReconfigureBalanceConfirm clickConfirm() throws Exception {

        super.clickConfirm();
        return new ReconfigureBalanceConfirm(tool, test, user);
    }

}
