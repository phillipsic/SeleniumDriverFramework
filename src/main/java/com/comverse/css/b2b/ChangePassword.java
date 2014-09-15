package com.comverse.css.b2b;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;
import com.comverse.css.commonpages.ChangePasswordCommon;

public class ChangePassword extends ChangePasswordCommon {

    public ChangePassword(AutomationTool tool, Test test, User user) throws Exception {

        super(tool, test, user);

    }

    @Override
    public ModifyLoginPassword clickChange() throws Exception {  test.writeInLog(Common.getMethodName());

        super.clickChange();
        return new ModifyLoginPassword(tool, test, user);
    }
}
