/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class ConfigureServiceConnectionDetailsCommon extends CommonMenu {
    static String expectedScreen = "Configure Service Connection Details";

    public ConfigureServiceConnectionDetailsCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle();

        if (!expectedScreen.equals(currentScreen)) {
            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }
    }

    public MyBasketCommon clickContinue() throws Exception {
        tool.clickUsingXPath("//input[@value='Continue >']");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new MyBasketCommon(tool, test, user);
    }

    public SwapSubscriberExternalIdConfirmationCommon clickContinueExpectingSwapSubscriberExternalIdConfirmation() throws Exception {
        tool.clickUsingXPath("//input[@value='Continue >']");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new SwapSubscriberExternalIdConfirmationCommon(tool, test, user);
    }

    public void selectTopLevelContainerType(String containerType) throws Exception {
        tool.selectVisibleTextByID("p-advInvSearch-L4:17000", containerType);
    }

    public ServiceConnectionDetailsCommon clickOK() throws Exception {
        tool.clickUsingXPath("//input[@value='OK']");
        return new ServiceConnectionDetailsCommon(tool, test, user);
    }

    public void setServiceConnectionEmail(String Email) throws Exception {
        
        tool.enterStringUsingId("inputFields1178", Email);

    }

}
