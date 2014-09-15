package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

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
        test.writeInLog(Common.getMethodName());

        tool.enterStringUsingId("balanceValue", unitsToAdd);
        return new ReconfigureBalanceCommon(tool, test, user);
    }

    public ReconfigureBalanceReviewCommon clickAddUnits() throws Exception {
        test.writeInLog(Common.getMethodName());

        tool.clickUsingName("submit_add_units");
        return new ReconfigureBalanceReviewCommon(tool, test, user);
    }

    public ReconfigureBalanceCommon setCreditSpendingLimit(String limitValue) throws Exception {
        test.writeInLog(Common.getMethodName());

        tool.enterStringUsingId("configuredLimit", limitValue);
        return new ReconfigureBalanceCommon(tool, test, user);
    }

    public ReconfigureBalanceCommon setCreditSpendingLimitUnlimited() throws Exception {
        test.writeInLog(Common.getMethodName());

        tool.clickUsingName("isUnlimitedCheckBox");
        return new ReconfigureBalanceCommon(tool, test, user);
    }

    public void selectUseAccountUnitsFrom(String selectOption) throws Exception {
        test.writeInLog(Common.getMethodName());
        tool.selectVisibleTextByID("targetBalance", selectOption);
    }

    public ReconfigureBalanceReviewCommon clickReconfigureBalance() throws Exception {
        test.writeInLog(Common.getMethodName());

        tool.clickUsingName("submit_reconfigure_limit");
        return new ReconfigureBalanceReviewCommon(tool, test, user);
    }

}
