package com.comverse.css.csr;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.RegisterPrepaymentConfirmCommon;

public class RegisterPrepaymentConfirm extends RegisterPrepaymentConfirmCommon {

    public RegisterPrepaymentConfirm(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
    }

    @Override
    public AccountDetails clickBackToAccount() throws Exception {

        super.clickBackToAccount();
        return new AccountDetails(tool, test, user);
    }
}
