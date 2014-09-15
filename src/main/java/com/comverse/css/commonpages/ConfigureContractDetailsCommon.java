package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class ConfigureContractDetailsCommon extends CommonMenu {

    public ConfigureContractDetailsCommon(AutomationTool tool, Test test, User user) throws Exception {

        super(tool, test, user);
        String currentScreen = tool.getTitle();
        String expectedScreen = "Configure Contract Details";

        if (!expectedScreen.equals(currentScreen)) {
            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }
    }

    public MyBasketCommon clickContinue() throws Exception {
        tool.clickUsingXPath("//input[@value='Continue >']");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new MyBasketCommon(tool, test, user);
    }

    public void setSpendingLimit(String limitName, String limitAmount) throws Exception {
        
        tool.enterStringUsingId(limitName + "_limit", limitAmount);
    }

    public void setLang(String lang) throws Exception {
        tool.selectVisibleTextByID("p-param-L4:80000", lang);
    }

    public ConfigureBalanceCommon clickContinueExpectingConfigureBalance() throws Exception {
        tool.clickUsingXPath("//input[@value='Continue >']");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new ConfigureBalanceCommon(tool, test, user);
    }

}
