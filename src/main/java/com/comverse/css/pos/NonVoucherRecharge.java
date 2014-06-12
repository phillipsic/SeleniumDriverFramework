/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.pos;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.NonVoucherRechargeCommon;

public class NonVoucherRecharge extends NonVoucherRechargeCommon {

    public NonVoucherRecharge(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

    }

    @Override
    public NonVoucherRechargeReview clickSelect() throws Exception {
        super.clickSelect();
        return new NonVoucherRechargeReview(tool, test, user);
    }

    @Override
    public NonVoucherRechargeReview clickContinueExpectingNonVoucherRechargeReview() throws Exception {
        super.clickContinueExpectingNonVoucherRechargeReview();
        return new NonVoucherRechargeReview(tool, test, user);
    }
}
