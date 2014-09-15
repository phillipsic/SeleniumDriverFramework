/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.b2b;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;
import com.comverse.css.commonpages.NonVoucherRechargeCommon;

public class NonVoucherRecharge extends NonVoucherRechargeCommon {

    public NonVoucherRecharge(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

    }

    @Override
    public void selectPaymentMethodCreditCard() throws Exception {  test.writeInLog(Common.getMethodName());

        tool.clickUsingXPath("//input[@value='CREDIT_CARD']");
    }

    @Override
    public NonVoucherRechargeReview nonVoucherRechargeByCheck(String rechargeAmount) throws Exception {  test.writeInLog(Common.getMethodName());

        super.nonVoucherRechargeByCheck(rechargeAmount);
        return new NonVoucherRechargeReview(tool, test, user);
    }

    @Override
    public NonVoucherRechargeReview clickSelect() throws Exception {  test.writeInLog(Common.getMethodName());

        super.clickSelect();
        return new NonVoucherRechargeReview(tool, test, user);
    }
}
