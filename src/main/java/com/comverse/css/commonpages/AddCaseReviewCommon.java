/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class AddCaseReviewCommon extends CommonMenu {
    static String expectedScreen = "Add case - review";

    public AddCaseReviewCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

        String currentScreen = tool.getTitle();

        // Check that we're on the right page.
        if (!expectedScreen.equals(tool.getTitle())) {

            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }
    }

    public AddCaseConfirmationCommon clickCreateCase() throws Exception {  test.writeInLog(Common.getMethodName());

        tool.clickUsingName("ACTION_CREATE");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new AddCaseConfirmationCommon(tool, test, user);

    }

    public AddCaseConfirmationCommon clickCreateCaseAndClose() throws Exception {  test.writeInLog(Common.getMethodName());

        tool.clickUsingName("ACTION_CREATE_AND_CLOSE");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new AddCaseConfirmationCommon(tool, test, user);

    }
}
