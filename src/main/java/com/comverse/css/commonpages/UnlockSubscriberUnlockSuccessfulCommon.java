package com.comverse.css.commonpages;

import org.openqa.selenium.By;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class UnlockSubscriberUnlockSuccessfulCommon extends CommonMenu {

    public UnlockSubscriberUnlockSuccessfulCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "Unlock subscriber - Unlock successful";
        if (!expectedScreen.equals(currentScreen)) {
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public SubscriberDetailsCommon clickOK() throws Exception {

        tool.driver.findElement(By.xpath("//input[@value='OK']")).click();
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());

        return new SubscriberDetailsCommon(tool, test, user);
    }
}
