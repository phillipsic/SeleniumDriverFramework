package com.comverse.css.b2c;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class RechargeDone extends B2CMenu {

    public RechargeDone(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle();
        String expectedScreen = "Recharge Done";

         if (!expectedScreen.equals(tool.getTitle())) {
            test.writeInLog("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }
        test.writeInLog(" >>> Page Now loaded: " + expectedScreen + " <<<");
    }

    public void selectFreeAmount() throws Exception {

        tool.clickUsingXPath("//div[3]/input");
    }

    public RechargeWithFreeAmount clickSubmit() throws Exception {

        tool.clickUsingXPath("//input[@value='Continue']");
        return new RechargeWithFreeAmount(tool, test, user);
    }
}
