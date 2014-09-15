package com.comverse.css.b2c;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class RechargeWithFreeAmount extends B2CMenu {

    public RechargeWithFreeAmount(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle();
        String expectedScreen = "Recharge with free amount";

        if (!expectedScreen.equals(tool.getTitle())) {
            test.writeInLog("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }
        test.writeInLog(" >>> Page Now loaded: " + expectedScreen + " <<<");
    }

    public void enterRechargeAmount(String rechargeAmount) throws Exception {

        
        tool.enterStringUsingId("rechargeAmount", rechargeAmount);
    }

    public SelectRechargePaymentMethod clickContinue() throws Exception {

        tool.clickUsingXPath("//input[@value='Continue']");
        return new SelectRechargePaymentMethod(tool, test, user);
    }
}
