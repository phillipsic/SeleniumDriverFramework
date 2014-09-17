/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.csr;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;
import com.comverse.css.commonpages.AddDepositCommon;

public class AddDeposit extends AddDepositCommon {

    public AddDeposit(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

    }

    @Override
    public void setDepositType(String depositType) throws Exception {
        test.writeInLogFile(Common.getMethodName());

        super.setDepositType(depositType);
    }

    @Override
    public void setBalance(String balanceName) throws Exception {
        test.writeInLogFile(Common.getMethodName());

        super.setBalance(balanceName);
    }

    @Override
    public void setDepositAmount(String depositAmount) throws Exception {
        test.writeInLogFile(Common.getMethodName());

        super.setDepositAmount(depositAmount);
    }

    @Override
    public void selectPaymentMethod() throws Exception {
        test.writeInLogFile(Common.getMethodName());

        super.selectPaymentMethod();
    }

    @Override
    public AddDepositReviewAndConfirm clickContinue() throws Exception {
        test.writeInLogFile(Common.getMethodName());

        super.clickContinue();
        return new AddDepositReviewAndConfirm(tool, test, user);
    }
}
