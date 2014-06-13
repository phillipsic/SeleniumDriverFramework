package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class UnbilledTransactionCommon extends CommonMenu {

    public UnbilledTransactionCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "View Unbilled Transactions";

        // Check that we're on the right page.
        if (!expectedScreen.equals(tool.driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public ViewUnbilledRCNRCCommon clickUnbilledRCNRC() throws Exception {

        tool.clickUsingID(tool, "youcan_VIEW_RC_NRC");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new ViewUnbilledRCNRCCommon(tool, test, user);
    }

    public ViewUnbilledUsageCommon clickUnbilledUsage() throws Exception {

        tool.clickUsingID(tool, "youcan_VIEW_USAGES");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new ViewUnbilledUsageCommon(tool, test, user);
    }

    public ViewUnbilledMTRCommon clickUnbilledMTR() throws Exception {

        tool.clickUsingID(tool, "youcan_VIEW_MTR");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new ViewUnbilledMTRCommon(tool, test, user);
    }

    public ViewUnbilledRechargeCommon clickUnbilledRecharge() throws Exception {

        tool.clickUsingID(tool, "youcan_VIEW_RECHARGES");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new ViewUnbilledRechargeCommon(tool, test, user);
    }

    public ViewUnbilledAdjustmentCommon clickUnbilledAdjustment() throws Exception {

        tool.clickUsingID(tool, "youcan_VIEW_ADJUSTMENTS");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new ViewUnbilledAdjustmentCommon(tool, test, user);
    }

}
