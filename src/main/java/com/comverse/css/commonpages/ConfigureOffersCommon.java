/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class ConfigureOffersCommon extends CommonMenu {

    public ConfigureOffersCommon(AutomationTool tool, Test test, User user) throws Exception {

        super(tool, test, user);
        String currentScreen = tool.getTitle(tool);
        String expectedScreen = "Configure Offers";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public ConfigureBalanceCommon clickContinue() throws Exception {
        tool.clickUsingXPath(tool, "//input[@value='Continue >']");
        return new ConfigureBalanceCommon(tool, test, user);
    }

    public MyBasketCommon clickContinueExpectingMyBasket() throws Exception {
        tool.clickUsingXPath(tool, "//input[@value='Continue >']");
        return new MyBasketCommon(tool, test, user);
    }

    public ServiceConnectionDetailsCommon clickContinueExpectingServiceConnectionDetails() throws Exception {
        tool.clickUsingXPath(tool, "//input[@value='Continue >']");
        return new ServiceConnectionDetailsCommon(tool, test, user);
    }

    public SwapImpactCommon clickContinueExpectingSwapImpact() throws Exception {
        tool.clickUsingXPath(tool, "//input[@value='Continue >']");
        return new SwapImpactCommon(tool, test, user);
    }

}
