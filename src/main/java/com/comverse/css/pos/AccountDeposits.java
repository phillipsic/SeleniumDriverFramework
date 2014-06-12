/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.pos;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.AccountDepositsCommon;

public class AccountDeposits extends AccountDepositsCommon {

    public AccountDeposits(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

    }

    @Override
    public AddDeposit clickAdd() throws Exception {

        super.clickAdd();
        return new AddDeposit(tool, test, user);
    }

    @Override
    public AccountDetails clickBack() throws Exception {

        super.clickBack();
        return new AccountDetails(tool, test, user);
    }
}
