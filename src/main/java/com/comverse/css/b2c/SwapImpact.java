/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.b2c;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class SwapImpact extends B2CMenu {

    public SwapImpact(AutomationTool tool, Test test, User user) throws Exception {

        super(tool, test, user);
        String currentScreen = tool.getTitle();
        String expectedScreen = "Swap Impact";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
        System.out.println(">>" + currentScreen);
    }

    public MyBasket clickOk() throws Exception {

        tool.clickUsingXPath("//input[@value='Ok']");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new MyBasket(tool, test, user);
    }

    public ConfigureBalance clickOkExpectingConfigureBalance() throws Exception {

        tool.clickUsingXPath("//input[@value='Ok']");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new ConfigureBalance(tool, test, user);
    }

}
