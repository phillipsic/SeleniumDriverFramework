package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class ViewUnbilledUsageDetailsCommon extends CommonMenu {

    public ViewUnbilledUsageDetailsCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

        String currentScreen = tool.getTitle();
        String expectedScreen = "View unbilled usage details";
        // Check that we're on the right page.
        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");

        }
    }

    public ViewUnbilledUsageCommon clickBack() throws Exception {  test.writeInLog(Common.getMethodName());

        tool.clickUsingXPath("//input[@value='Back']");
        return new ViewUnbilledUsageCommon(tool, test, user);
    }
}
