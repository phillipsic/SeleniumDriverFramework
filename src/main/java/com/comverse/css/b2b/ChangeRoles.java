/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.b2b;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.ChangeRolesCommon;

public class ChangeRoles extends ChangeRolesCommon {

    public ChangeRoles(AutomationTool tool, Test test, User user) throws Exception {

        super(tool, test, user);

    }

    public LoginInformation clickConfirm() throws Exception {

        tool.clickUsingXPath(tool, "//input[@value='Confirm']");
        return new LoginInformation(tool, test, user);

    }

    public LoginInformation clickOK() throws Exception {

        super.clickOk();
        return new LoginInformation(tool, test, user);
    }
}
