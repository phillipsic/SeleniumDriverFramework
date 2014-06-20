package com.comverse.css.b2c;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class RechargeDone extends B2CMenu {

    public RechargeDone(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle();
        String expectedScreen = "Recharge Done";

        // Check that we're on the right page.
        if (!expectedScreen.equals(tool.getTitle())) {
            // Alternatively, we could navigate to the login page, perhaps
            // logging out first
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public void selectFreeAmount() throws Exception {

        tool.clickUsingXPath("//div[3]/input");
    }

    public RechargeWithFreeAmount clickSubmit() throws Exception {

        tool.clickUsingXPath("//input[@value='Continue']");
        return new RechargeWithFreeAmount(tool, test, user);
    }
}
