package com.comverse.css.commonpages;

import org.openqa.selenium.By;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;
import com.comverse.css.common.Subscriber;

public class SwapSubscriberExternalIdConfirmationCommon extends CommonMenu {
    static String expectedScreen = "Swap Subscriber External Id - Confirmation";

    public SwapSubscriberExternalIdConfirmationCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.driver.getTitle();

        if (!expectedScreen.equals(currentScreen)) {
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public SubscriberExternalIDSwapDoneCommon clickContinue() throws Exception {
        tool.clickUsingName(tool, "submit");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new SubscriberExternalIDSwapDoneCommon(tool, test, user);
    }

    public void setNewMSISDNInventory(Subscriber subscriber) throws Exception {
        String MSISDN = tool.driver.findElement(By.xpath("//tr[3]/td/span[2]")).getText();
        subscriber.setSubscriberMSISDNProperty(MSISDN);
    }
}