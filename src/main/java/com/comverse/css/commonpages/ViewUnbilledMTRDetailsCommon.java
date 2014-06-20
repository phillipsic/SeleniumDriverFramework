package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class ViewUnbilledMTRDetailsCommon extends CommonMenu {

    public ViewUnbilledMTRDetailsCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

        String currentScreen = tool.getTitle();
        String expectedScreen = "View unbilled MTR details";
        // Check that we're on the right page.
        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);

        }
    }

    public ViewUnbilledMTRCommon clickBack() throws Exception {

        tool.clickUsingXPath("//input[@value='Back']");
        return new ViewUnbilledMTRCommon(tool, test, user);
    }
}
