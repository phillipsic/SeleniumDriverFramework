/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class ModifyLoginRolesCommon extends CommonMenu {

    public ModifyLoginRolesCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle();
        String expectedScreen = "Modify Login Roles";

        if (!expectedScreen.equals(tool.getTitle())) {

            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }
    }

    public LoginInformationCommon clickVeiwLoginInformationLink() throws Exception {
        test.writeInLogFile(Common.getMethodName());

        tool.clickUsingID("smnu_LOGIN");

        return new LoginInformationCommon(tool, test, user);
    }
}
