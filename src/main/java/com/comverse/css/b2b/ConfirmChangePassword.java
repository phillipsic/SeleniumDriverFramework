/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.b2b;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.ConfirmChangePasswordCommon;

public class ConfirmChangePassword extends ConfirmChangePasswordCommon {

    public ConfirmChangePassword(AutomationTool tool, Test test, User user) throws Exception {

        super(tool, test, user);

    }

    @Override
    public ChangeLoginPassword clickOk() throws Exception {

        super.clickOk();
        return new ChangeLoginPassword(tool, test, user);
    }
}
