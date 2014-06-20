/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.comverse.css.csr;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.CommonMenu;

public class ModifyLoginRoles extends CommonMenu {

    public ModifyLoginRoles(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle();
        String expectedScreen = "Modify Login Roles";

        if (!expectedScreen.equals(tool.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public LoginInformation clickVeiwLoginInformationLink() throws Exception {

        tool.clickUsingID("smnu_LOGIN");

        return new LoginInformation(tool, test, user);
    }
}
