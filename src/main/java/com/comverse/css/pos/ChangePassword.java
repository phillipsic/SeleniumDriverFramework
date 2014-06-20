package com.comverse.css.pos;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.ChangePasswordCommon;

public class ChangePassword extends ChangePasswordCommon {

    public ChangePassword(AutomationTool tool, Test test, User user) throws Exception {

        super(tool, test, user);

    }

    @Override
    public ModifyLoginPassword clickChange() throws Exception {

        tool.clickUsingXPath("//input[@value='Change']");
        return new ModifyLoginPassword(tool, test, user);
    }
}
