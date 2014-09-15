package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class ViewUnbilledNRCTermDetailsCommon extends CommonMenu {

    public ViewUnbilledNRCTermDetailsCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

        String currentScreen = tool.getTitle();
        String expectedScreen = "View unbilled NRC term details";
        // Check that we're on the right page.
        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");

        }
    }

    public ViewUnbilledRCNRCCommon clickBack() throws Exception {  test.writeInLog(Common.getMethodName());

        tool.clickUsingXPath("//input[@value='Back']");
        return new ViewUnbilledRCNRCCommon(tool, test, user);
    }
}
