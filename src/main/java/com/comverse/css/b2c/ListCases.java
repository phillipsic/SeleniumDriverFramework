/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.b2c;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class ListCases extends B2CMenu {

    public ListCases(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle();
        String expectedScreen = "List Cases";

        if (!expectedScreen.equals(tool.getTitle())) {
            test.writeInLog("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }
        test.writeInLog(" >>> Page Now loaded: " + expectedScreen + " <<<");
    }

    public AddCase clickCreateCase() throws Exception {
        test.writeInLog(Common.getMethodName());
        tool.clickUsingID("smnu_CASE_ADD");
        Common.sleepForNumberOfSeconds(1);
        return new AddCase(tool, test, user);
    }

    public ViewCase clickOnCaseIDLink(String caseID) throws Exception {
        test.writeInLog(Common.getMethodName() + " using data (" + caseID + ")");
        tool.clickUsingLinkText(caseID);
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new ViewCase(tool, test, user);
    }

}
