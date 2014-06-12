package com.comverse.css.pos;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.CheckoutReviewCommon;

public class CheckoutReview extends CheckoutReviewCommon {

    public CheckoutReview(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

    }

    @Override
    public CheckoutConfirmation clickConfirm() throws Exception {

        super.clickConfirm();
        return new CheckoutConfirmation(tool, test, user);
    }

    @Override
    public ImmediatePayment clickConfirmWithGoods() throws Exception {

        super.clickConfirmWithGoods();
        return new ImmediatePayment(tool, test, user);
    }
}
