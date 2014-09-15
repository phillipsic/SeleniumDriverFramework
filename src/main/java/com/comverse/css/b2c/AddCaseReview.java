package com.comverse.css.b2c;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class AddCaseReview extends B2CMenu {

    public AddCaseReview(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle();
        String expectedScreen = "Add case - review";

        if (!expectedScreen.equals(tool.getTitle())) {
            test.writeInLog("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }
        test.writeInLog(" >>> Page Now loaded: " + expectedScreen + " <<<");
    }

    public AddCaseConfirmation clickCreateCase() throws Exception {  test.writeInLog(Common.getMethodName());
        test.writeInLog(Common.getMethodName());
        tool.clickUsingXPath("//input[@value='Create case']");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new AddCaseConfirmation(tool, test, user);
    }
}
