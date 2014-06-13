/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.pos;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.ActivateLoginCommon;

public class ActivateLogin extends ActivateLoginCommon {

    public ActivateLogin(AutomationTool tool, Test test, User user) throws Exception {

        super(tool, test, user);

    }

    public ModifyLoginPassword clickConfirm() throws Exception {

        tool.clickUsingXPath(tool, "//input[@value='Confirm']");
        return new ModifyLoginPassword(tool, test, user);
    }

}