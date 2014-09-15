package com.comverse.css.b2c;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class ConfigureBalanceReview extends B2CMenu {

    public ConfigureBalanceReview(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle();
        String expectedScreen = "Configure balance - Review";

         if (!expectedScreen.equals(tool.getTitle())) {
            test.writeInLog("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }
        test.writeInLog(" >>> Page Now loaded: " + expectedScreen + " <<<");
    }

    public ConfigureBalanceConfirm clickConfirm() throws Exception {
        tool.clickUsingCssSelector("input[type='button'][value='Confirm']");
        return new ConfigureBalanceConfirm(tool, test, user);

    }

    public ViewBalances clickBack() throws Exception {
        tool.clickUsingCssSelector("input[type='submit'][value='Back']");
        return new ViewBalances(tool, test, user);

    }
}
