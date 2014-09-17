package com.comverse.css.csr;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;
import com.comverse.css.commonpages.AddLoginCommon;

public class AddLogin extends AddLoginCommon {

    public AddLogin(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
    }

    @Override
    public PersonManagement clickContinue() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        super.clickContinue();
        return new PersonManagement(tool, test, user);
    }
}
