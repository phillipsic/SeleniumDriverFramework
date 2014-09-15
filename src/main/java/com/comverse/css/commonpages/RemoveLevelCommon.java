/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class RemoveLevelCommon extends CommonMenu {

    public RemoveLevelCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

        String currentScreen = tool.getTitle();
        String expectedScreen = "Remove Level";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }

    }

    public ViewHierarchyCommon clickOk() throws Exception {
        test.writeInLog(Common.getMethodName());

        tool.clickUsingXPath("//form[@id='form_OK']/div/input");

        return new ViewHierarchyCommon(tool, test, user);

    }

    public RemoveLevelCommon clickOkToRemoveLevel() throws Exception {
        test.writeInLog(Common.getMethodName());

        tool.clickUsingXPath("//input[@value='OK']");

        return new RemoveLevelCommon(tool, test, user);

    }

    public ViewHierarchyCommon clickOkToConfirm() throws Exception {
        test.writeInLog(Common.getMethodName());

        tool.clickUsingXPath("//input[@value='OK']");

        return new ViewHierarchyCommon(tool, test, user);

    }

}
