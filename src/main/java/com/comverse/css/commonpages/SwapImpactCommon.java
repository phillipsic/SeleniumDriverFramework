package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class SwapImpactCommon extends CommonMenu {
    static String expectedScreen = "Swap Impact";

    public SwapImpactCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

        String currentScreen = tool.driver.getTitle();

        // Check that we're on the right page.
        if (!expectedScreen.equals(currentScreen)) {
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public MyBasketCommon clickOK() throws Exception {
        tool.clickUsingName(tool, "ON_OK");
        return new MyBasketCommon(tool, test, user);
    }

    public ConfigureBalanceCommon clickOKExpectingConfigureBalance() throws Exception {
        tool.clickUsingName(tool, "ON_OK");
        return new ConfigureBalanceCommon(tool, test, user);
    }
}
