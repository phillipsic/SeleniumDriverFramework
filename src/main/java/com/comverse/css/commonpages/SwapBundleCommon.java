package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class SwapBundleCommon extends CommonMenu {

    public SwapBundleCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle();
        String expectedScreen = "Swap Bundle";
        if (!expectedScreen.equals(currentScreen)) {
            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }
    }

    public void clickToAccountBundle(String accountBundle) throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.clickUsingXPath("//tr[@id='abtr:" + accountBundle + "']/td/input");
    }

    public void clickAdditionalParticipants() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.clickUsingName("additionalPartChk");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
    }

    public AccountBundleDistributionConfigurationCommon clickContinue() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.clickUsingID("futureDistContinueBtn");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new AccountBundleDistributionConfigurationCommon(tool, test, user);
    }
}