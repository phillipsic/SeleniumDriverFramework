package com.comverse.css.b2c;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class RechargeDone extends B2CMenu {

    public RechargeDone(AutomationTool tool, Test test, User user) {
        super(tool, test, user);
        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "Recharge Done";

        // Check that we're on the right page.
        if (!expectedScreen.equals(tool.driver.getTitle())) {
            // Alternatively, we could navigate to the login page, perhaps
            // logging out first
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public void selectFreeAmount() throws Exception {

        tool.clickUsingXPath(tool, "//div[3]/input");
    }

    public RechargeWithFreeAmount clickSubmit() throws Exception {

        tool.clickUsingXPath(tool, "//input[@value='Continue']");
        return new RechargeWithFreeAmount(tool, test, user);
    }
}
