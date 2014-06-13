package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class ReconfigureBalanceConfirmCommon extends CommonMenu {

    static String expectedScreen = "Configure balance - Confirm";

    public ReconfigureBalanceConfirmCommon(AutomationTool tool, Test test, User user) throws Exception {

        super(tool, test, user);
        String currentScreen = tool.driver.getTitle();

        if (!currentScreen.equals(expectedScreen)) {
            throw new IllegalStateException("Expected: " + expectedScreen + " but got: " + currentScreen);
        }
    }

    public ViewBalanceCommon clickBack() throws Exception {

        tool.clickUsingXPath(tool, "//input[@value='Back']");
        return new ViewBalanceCommon(tool, test, user);
    }

}
