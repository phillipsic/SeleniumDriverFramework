package com.comverse.css.b2c;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class RechargeWithFreeAmount extends B2CMenu {

    public RechargeWithFreeAmount(AutomationTool tool, Test test, User user) {
        super(tool, test, user);
        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "Recharge with free amount";

        // Check that we're on the right page.
        if (!expectedScreen.equals(tool.driver.getTitle())) {
            // Alternatively, we could navigate to the login page, perhaps
            // logging out first
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public void enterRechargeAmount(String rechargeAmount) throws Exception {

        
        tool.enterStringUsingId(tool, "rechargeAmount", rechargeAmount);
    }

    public SelectRechargePaymentMethod clickContinue() throws Exception {

        tool.clickUsingXPath(tool, "//input[@value='Continue']");
        return new SelectRechargePaymentMethod(tool, test, user);
    }
}
