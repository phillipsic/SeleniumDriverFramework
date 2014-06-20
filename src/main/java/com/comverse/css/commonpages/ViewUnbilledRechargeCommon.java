package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class ViewUnbilledRechargeCommon extends CommonMenu {

    public ViewUnbilledRechargeCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

        String currentScreen = tool.getTitle();
        String expectedScreen = "View Unbilled Recharges";
        // Check that we're on the right page.
        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);

        }
    }

    public ViewRechargeDetailsCommon clickFirstRecharge() throws Exception {

        /* tool.clickUsingXPath("//td/div/a"); */
        tool.clickUsingXPath("//fieldset/div/table/tbody[2]/tr/td/div/a");
        return new ViewRechargeDetailsCommon(tool, test, user);
    }

    public UnbilledTransactionCommon clickBack() throws Exception {

        tool.clickUsingXPath("//input[@value='Back']");
        return new UnbilledTransactionCommon(tool, test, user);
    }
}
