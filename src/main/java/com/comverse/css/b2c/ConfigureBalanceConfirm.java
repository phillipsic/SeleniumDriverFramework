package com.comverse.css.b2c;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class ConfigureBalanceConfirm extends B2CMenu {

    public ConfigureBalanceConfirm(AutomationTool tool, Test test, User user) {
        super(tool, test, user);
        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "Configure balance - Confirm";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public ViewBalances clickBack() throws Exception {
        tool.clickUsingCssSelector(tool, "input[type='submit'][value='Back']");
        return new ViewBalances(tool, test, user);

    }
}
