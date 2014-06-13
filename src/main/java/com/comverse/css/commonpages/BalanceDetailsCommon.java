package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class BalanceDetailsCommon extends CommonMenu {

    static String expectedScreen = "Balance Details";

    public BalanceDetailsCommon(AutomationTool tool, Test test, User user) throws Exception {

        super(tool, test, user);
        String currentScreen = tool.driver.getTitle();

        if (!expectedScreen.equals(currentScreen)) {
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }

    }

    // From Account shared balance details page
    public BalanceDetailsCommon viewSubscriberBalanceDetails(String balanceName) throws Exception {

        tool.clickUsingLinkText(tool, balanceName);
        return new BalanceDetailsCommon(tool, test, user);
    }

    // From Subscriber balance details page
    public ViewBalanceCommon viewAccountBalances() throws Exception {

        tool.clickUsingLinkText(tool, "View account balances");
        return new ViewBalanceCommon(tool, test, user);
    }

    public ViewBalanceCommon clickGoToListOfBalances() throws Exception {
        tool.clickUsingID(tool, "youcan_ON_BACK");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new ViewBalanceCommon(tool, test, user);
    }

}
