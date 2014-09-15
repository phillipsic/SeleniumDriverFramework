package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class ViewUnbilledAdjustmentCommon extends CommonMenu {

    public ViewUnbilledAdjustmentCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

        String currentScreen = tool.getTitle();
        String expectedScreen = "View Unbilled Adjustments";
        // Check that we're on the right page.
        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");

        }
    }

    public AdjustmentDetailsCommon clickFirstAdjustment() throws Exception {
        test.writeInLog(Common.getMethodName());

        tool.clickUsingXPath("//fieldset/div/table/tbody[2]/tr/td/div/a");
        return new AdjustmentDetailsCommon(tool, test, user);
    }

    public UnbilledTransactionCommon clickBack() throws Exception {
        test.writeInLog(Common.getMethodName());

        tool.clickUsingXPath("//input[@value='Back']");
        return new UnbilledTransactionCommon(tool, test, user);
    }
}
