/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class ProfileInformationCommon extends CommonMenu {

    public ProfileInformationCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

        String currentScreen = tool.getTitle();
        String expectedScreen = "Profile Information";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }

    }

    @Override
    public ViewHierarchyCommon clickHierarchy() throws Exception {
        test.writeInLog(Common.getMethodName());
        tool.clickUsingID("mnu_HIERARCHY");
        return new ViewHierarchyCommon(tool, test, user);
    }

    public ModifyProfileInformationCommon clickModify() throws Exception {
        test.writeInLog(Common.getMethodName());
        tool.clickUsingID("modifyCustomer");
        return new ModifyProfileInformationCommon(tool, test, user);
    }
}
