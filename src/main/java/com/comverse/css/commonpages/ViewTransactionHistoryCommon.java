/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import java.util.concurrent.TimeUnit;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class ViewTransactionHistoryCommon extends CommonMenu {
    static String expectedScreen = "View transaction history";

    public ViewTransactionHistoryCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

        String currentScreen = tool.driver.getTitle();

        // Check that we're on the right page.
        if (!expectedScreen.equals(currentScreen)) {
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public ViewUsageHistoryCommon clickOnUsageHistory() throws Exception {
        tool.clickUsingID(tool, "youcan_USAGE_HISTORY");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new ViewUsageHistoryCommon(tool, test, user);
    }

    public ViewMTRHistoryCommon clickonMTRHistory() throws Exception {
        tool.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        tool.clickUsingID(tool, "youcan_MTR_HISTORY");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new ViewMTRHistoryCommon(tool, test, user);
    }

    public ViewRCHistoryCommon clickonRCHistory() throws Exception {
        tool.clickUsingID(tool, "youcan_RC_HISTORY");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new ViewRCHistoryCommon(tool, test, user);
    }

    public ViewNRCHistoryCommon clickonNRCHistory() throws Exception {
        tool.clickUsingID(tool, "youcan_NRC_HISTORY");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new ViewNRCHistoryCommon(tool, test, user);
    }

    public ViewCombinedHistoryCommon clickonCombinedHistory() throws Exception {
        tool.clickUsingID(tool, "youcan_COMBINED_HISTORY");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new ViewCombinedHistoryCommon(tool, test, user);
    }
}
