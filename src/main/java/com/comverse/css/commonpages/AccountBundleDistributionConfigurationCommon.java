package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class AccountBundleDistributionConfigurationCommon extends CommonMenu {
    static String expectedScreen = "Account Bundle Distribution/Configuration";

    public AccountBundleDistributionConfigurationCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle();

        if (!expectedScreen.equals(currentScreen)) {
            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }
    }

    public void clickSBSelectiveOffers() throws Exception {
        // Need to remove xpath here
        tool.clickUsingXPath("//tr[6]/td/input");
    }

    public ConfigureContractDetailsCommon clickContinue() throws Exception {
        tool.clickUsingXPath("//input[@value='Continue']");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new ConfigureContractDetailsCommon(tool, test, user);
    }
}