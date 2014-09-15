/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.csr;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;
import com.comverse.css.commonpages.LoginActivatedCommon;

public class LoginActivated extends LoginActivatedCommon {

    public LoginActivated(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
    }

    @Override
    public ModifyLoginPassword clickChangePassword() throws Exception {  test.writeInLog(Common.getMethodName());

        super.clickChangePassword();
        return new ModifyLoginPassword(tool, test, user);
    }

}
