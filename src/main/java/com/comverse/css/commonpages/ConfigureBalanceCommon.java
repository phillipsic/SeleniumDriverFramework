/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class ConfigureBalanceCommon extends CommonMenu {

    public ConfigureBalanceCommon(AutomationTool tool, Test test, User user) throws Exception {

        super(tool, test, user);
        String currentScreen = tool.getTitle();
        String expectedScreen = "Configure Balance";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public ServiceConnectionDetailsCommon clickContinueExpectingServiceConnectionDetails() throws Exception {
        this.clickContinue();
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new ServiceConnectionDetailsCommon(tool, test, user);
    }

    public ConfigureContractDetailsCommon clickContinueExpectingConfigureContractDetails() throws Exception {
        this.clickContinue();
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new ConfigureContractDetailsCommon(tool, test, user);
    }

    public MyBasketCommon clickContinueExpectingMyBasket() throws Exception {
        this.clickContinue();
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new MyBasketCommon(tool, test, user);
    }

    public void setSpendingLimit(String limitName, String limitAmount) throws Exception {
        tool.enterStringUsingId(limitName + "_limit", limitAmount);
    }

    public void setBalanceUnlimited(String balanceName) throws Exception {
        tool.clickUsingXPath("//input[@type='checkbox' and contains(@onclick, '" + balanceName + "_limit')]");
    }

    public void clickContinue() throws Exception {
        tool.clickUsingXPath("//input[@value='Continue >']");
    }
}
