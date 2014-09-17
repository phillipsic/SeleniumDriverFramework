/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.b2b;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;
import com.comverse.css.commonpages.NonVoucherRechargeReviewCommon;

public class NonVoucherRechargeReview extends NonVoucherRechargeReviewCommon {

    public NonVoucherRechargeReview(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

    }

    @Override
    public RechargeSubscriber confirmNonVoucherRecharge() throws Exception {  test.writeInLogFile(Common.getMethodName());

        super.confirmNonVoucherRecharge();
        return new RechargeSubscriber(tool, test, user);
    }

    @Override
    public RechargeSubscriber confirmNonVoucherRechargeByCreditCard() throws Exception {  test.writeInLogFile(Common.getMethodName());

        super.confirmNonVoucherRechargeByCreditCard();
        return new RechargeSubscriber(tool, test, user);
    }
}
