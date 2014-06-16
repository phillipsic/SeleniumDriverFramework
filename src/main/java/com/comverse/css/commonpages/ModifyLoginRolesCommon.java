/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class ModifyLoginRolesCommon extends CommonMenu {

    public ModifyLoginRolesCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle(tool);
        String expectedScreen = "Modify Login Roles";

        if (!expectedScreen.equals(tool.driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public LoginInformationCommon clickVeiwLoginInformationLink() throws Exception {

        tool.clickUsingID(tool, "smnu_LOGIN");

        return new LoginInformationCommon(tool, test, user);
    }
}
