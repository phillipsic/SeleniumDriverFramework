package com.comverse.css.b2c;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class BalanceDetails extends B2CMenu {

    public BalanceDetails(AutomationTool tool, Test test, User user) {
        super(tool, test, user);
        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "Balance Details";

        if (!expectedScreen.equals(tool.driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public ViewBalances clickGoToListOfSubscribers() throws Exception {

        tool.clickUsingID(tool, "youcan_ON_BACK");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new ViewBalances(tool, test, user);
    }

}
