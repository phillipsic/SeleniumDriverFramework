package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class AdjustBalanceDetailsCommon extends CommonMenu {
    static String expectedScreen = "Adjust balance - details";

    public AdjustBalanceDetailsCommon(AutomationTool tool, Test test, User user) throws Exception {

        super(tool, test, user);
        String currentScreen = tool.driver.getTitle();

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);

        }
    }

    public void enterAdjustmentAmount(String amount) throws Exception {

        
        tool.enterStringUsingId(tool, "adjustmentValue", amount);
    }

    public AdjustBalanceReviewCommon clickContinue() throws Exception {

        tool.clickUsingXPath(tool, "//input[@value='Continue']");
        return new AdjustBalanceReviewCommon(tool, test, user);
    }
}
