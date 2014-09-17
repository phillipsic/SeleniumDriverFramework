package com.comverse.css.b2c;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class BalanceDetails extends B2CMenu {

    public BalanceDetails(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle();
        String expectedScreen = "Balance Details";

        if (!expectedScreen.equals(tool.getTitle())) {
            test.writeInLogFile("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }
        test.writeInLogFile(" >>> Page Now loaded: " + expectedScreen + " <<<");
    }

    public ViewBalances clickGoToListOfSubscribers() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.clickUsingID("youcan_ON_BACK");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new ViewBalances(tool, test, user);
    }

}
