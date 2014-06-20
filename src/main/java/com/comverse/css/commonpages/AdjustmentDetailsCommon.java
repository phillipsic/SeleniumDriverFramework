package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class AdjustmentDetailsCommon extends CommonMenu {
    static String expectedScreen = "Adjustment details";

    public AdjustmentDetailsCommon(AutomationTool tool, Test test, User user) throws Exception {

        super(tool, test, user);
        String currentScreen = tool.getTitle();

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);

        }

    }

    public ViewUnbilledAdjustmentCommon clickBack() throws Exception {

        tool.clickUsingXPath("//input[@value='Back']");
        return new ViewUnbilledAdjustmentCommon(tool, test, user);
    }
}
