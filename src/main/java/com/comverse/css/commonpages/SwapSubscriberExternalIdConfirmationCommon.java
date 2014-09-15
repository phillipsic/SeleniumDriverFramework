package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;
import com.comverse.css.common.Subscriber;

public class SwapSubscriberExternalIdConfirmationCommon extends CommonMenu {
    static String expectedScreen = "Swap Subscriber External Id - Confirmation";

    public SwapSubscriberExternalIdConfirmationCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle();

        if (!expectedScreen.equals(currentScreen)) {
            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }
    }

    public SubscriberExternalIDSwapDoneCommon clickContinue() throws Exception {
        tool.clickUsingName("submit");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new SubscriberExternalIDSwapDoneCommon(tool, test, user);
    }

    public void setNewMSISDNInventory(Subscriber subscriber) throws Exception {
        String MSISDN = tool.getTextUsingXPath("//tr[3]/td/span[2]");
        subscriber.setSubscriberMSISDNProperty(MSISDN);
    }
}