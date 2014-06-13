package com.comverse.css.b2c;

import org.openqa.selenium.By;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class SubscriberStatusHistory extends B2CMenu {

    public SubscriberStatusHistory(AutomationTool tool, Test test, User user) {
        super(tool, test, user);
        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "Subscriber Status History";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public SubscriberDetail clickOk() throws Exception {

        tool.clickUsingXPath(tool, "//input[@value='OK']");
        // Common.waitForEndOfWaitingPage(tool,
        // this.getClass().getSimpleName());
        return new SubscriberDetail(tool, test, user);
    }

    public String getStatus() throws Exception {
        String subscriberStatus;
        subscriberStatus = tool.driver.findElement(By.xpath("//td[2]")).getText();
        return subscriberStatus;

    }

}
