package com.comverse.css.commonpages;

import org.openqa.selenium.By;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class DisconnectSubscriberImpactsCommon extends CommonMenu {

    public DisconnectSubscriberImpactsCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "Disconnect subscriber - Impacts";
        if (!expectedScreen.equals(currentScreen)) {
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public DisconnectSubscriberCommon clickConfirm() throws Exception {

        tool.driver.findElement(By.xpath("//input[@value='Confirm']")).click();
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());

        return new DisconnectSubscriberCommon(tool, test, user);
    }
}
