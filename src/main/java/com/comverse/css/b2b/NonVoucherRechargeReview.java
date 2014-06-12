/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.b2b;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.NonVoucherRechargeReviewCommon;

public class NonVoucherRechargeReview extends NonVoucherRechargeReviewCommon {

    public NonVoucherRechargeReview(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

    }

    @Override
    public RechargeSubscriber confirmNonVoucherRecharge() throws Exception {

        super.confirmNonVoucherRecharge();
        return new RechargeSubscriber(tool, test, user);
    }

    @Override
    public RechargeSubscriber confirmNonVoucherRechargeByCreditCard() throws Exception {

        super.confirmNonVoucherRechargeByCreditCard();
        return new RechargeSubscriber(tool, test, user);
    }
}
