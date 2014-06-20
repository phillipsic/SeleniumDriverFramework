package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class ReconfigureBalanceCommon extends CommonMenu {

    static String expectedScreen = "Configure Balance";

    public ReconfigureBalanceCommon(AutomationTool tool, Test test, User user) throws Exception {

        super(tool, test, user);
        String currentScreen = tool.getTitle();

        if (!currentScreen.equals(expectedScreen)) {
            throw new IllegalStateException("Expected: " + expectedScreen + " but got: " + currentScreen);
        }

    }

    public ReconfigureBalanceCommon setMoreUnitsForThisPeriod(String unitsToAdd) throws Exception {

        tool.enterStringUsingId("balanceValue", unitsToAdd);
        return new ReconfigureBalanceCommon(tool, test, user);
    }

    public ReconfigureBalanceReviewCommon clickAddUnits() throws Exception {

        tool.clickUsingName("submit_add_units");
        return new ReconfigureBalanceReviewCommon(tool, test, user);
    }

    public ReconfigureBalanceCommon setCreditSpendingLimit(String limitValue) throws Exception {

        tool.enterStringUsingId("configuredLimit", limitValue);
        return new ReconfigureBalanceCommon(tool, test, user);
    }

    public ReconfigureBalanceCommon setCreditSpendingLimitUnlimited() throws Exception {

        tool.clickUsingName("isUnlimitedCheckBox");
        return new ReconfigureBalanceCommon(tool, test, user);
    }

    public void selectUseAccountUnitsFrom(String selectOption) throws Exception {
        tool.selectVisibleTextByID("targetBalance", selectOption);
    }

    public ReconfigureBalanceReviewCommon clickReconfigureBalance() throws Exception {

        tool.clickUsingName("submit_reconfigure_limit");
        return new ReconfigureBalanceReviewCommon(tool, test, user);
    }

}
