package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class AdjustBalanceRequestResultCommon extends CommonMenu {
    static String expectedScreen = "Adjust balance - request result";

    public AdjustBalanceRequestResultCommon(AutomationTool tool, Test test, User user) throws Exception {

        super(tool, test, user);
        String currentScreen = tool.getTitle(tool);

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);

        }
    }

    public ViewBalanceCommon clickBack() throws Exception {

        tool.clickUsingXPath(tool, "//input[@value='Back']");
        return new ViewBalanceCommon(tool, test, user);
    }
}
