/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.csr;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.AddDepositCommon;

public class AddDeposit extends AddDepositCommon {

    public AddDeposit(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

    }

    @Override
    public void setDepositType(String depositType) throws Exception {
        super.setDepositType(depositType);
    }

    @Override
    public void setBalance(String balanceName) throws Exception {
        super.setBalance(balanceName);
    }

    @Override
    public void setDepositAmount(String depositAmount) throws Exception {
        super.setDepositAmount(depositAmount);
    }

    @Override
    public void selectPaymentMethod() throws Exception {
        super.selectPaymentMethod();
    }

    @Override
    public AddDepositReviewAndConfirm clickContinue() throws Exception {
        super.clickContinue();
        return new AddDepositReviewAndConfirm(tool, test, user);
    }
}
