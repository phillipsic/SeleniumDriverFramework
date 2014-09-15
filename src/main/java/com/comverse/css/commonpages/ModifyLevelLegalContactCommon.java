/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class ModifyLevelLegalContactCommon extends CommonMenu {

    public ModifyLevelLegalContactCommon(AutomationTool tool, Test test, User user) throws Exception {

        super(tool, test, user);
        String currentScreen = tool.getTitle();
        String expectedScreen = "Modify Level Legal Contact";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }
    }

    public ViewHierarchyCommon clickBack() throws Exception {
        test.writeInLog(Common.getMethodName());
        tool.clickUsingID("youcan_ON_BACK");
        return new ViewHierarchyCommon(tool, test, user);
    }

    public void setNewLevelName(String uniqueString) throws Exception {
        test.writeInLog(Common.getMethodName());

        tool.enterStringUsingId("company_name", uniqueString);
    }

    public void setNewLevelState(String uniqueState) throws Exception {
        test.writeInLog(Common.getMethodName());

        tool.selectVisibleTextByID("home_state", uniqueState);

    }

    public ModifyLevelLegalContactCommon clickOk() throws Exception {
        test.writeInLog(Common.getMethodName());

        tool.clickUsingXPath("//input[@value='OK']");

        return new ModifyLevelLegalContactCommon(tool, test, user);
    }

    public ModifyLevelLegalContactCommon clickOkAgain() throws Exception {
        test.writeInLog(Common.getMethodName());

        tool.clickUsingXPath("//input[@value='OK']");

        return new ModifyLevelLegalContactCommon(tool, test, user);
    }

    public LevelLegalContactCommon clickOkButton() throws Exception {
        test.writeInLog(Common.getMethodName());

        tool.clickUsingXPath("//input[@value='OK']");

        return new LevelLegalContactCommon(tool, test, user);
    }
}
