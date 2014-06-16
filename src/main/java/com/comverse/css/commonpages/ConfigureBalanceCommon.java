/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class ConfigureBalanceCommon extends CommonMenu {

    public ConfigureBalanceCommon(AutomationTool tool, Test test, User user) throws Exception {

        super(tool, test, user);
        String currentScreen = tool.getTitle(tool);
        String expectedScreen = "Configure Balance";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public ServiceConnectionDetailsCommon clickContinueExpectingServiceConnectionDetails() throws Exception {
        this.clickContinue();
        return new ServiceConnectionDetailsCommon(tool, test, user);
    }

    public ConfigureContractDetailsCommon clickContinueExpectingConfigureContractDetails() throws Exception {
        this.clickContinue();
        return new ConfigureContractDetailsCommon(tool, test, user);
    }

    public MyBasketCommon clickContinueExpectingMyBasket() throws Exception {
        this.clickContinue();
        return new MyBasketCommon(tool, test, user);
    }

    public void setSpendingLimit(String limitName, String limitAmount) throws Exception {
        
        tool.enterStringUsingId(tool, limitName + "_limit", limitAmount);
    }

    public void clickContinue() throws Exception {
        tool.clickUsingXPath(tool, "//input[@value='Continue >']");
    }
}
