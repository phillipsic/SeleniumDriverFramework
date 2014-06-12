/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import org.openqa.selenium.By;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class SubscriberIdentifiersSwapCommon extends CommonMenu {
    static String expectedScreen = "Subscriber Identifiers swap";

    public SubscriberIdentifiersSwapCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.driver.getTitle();
        if (!expectedScreen.equals(tool.driver.getTitle())) {
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public ConfigureServiceConnectionDetailsCommon clickSwapMSISDNInventory() throws Exception {
        String firstDelimiterString = "MSISDN reference:";
        String secondDelimiterString = "swap_";

        this.clickSwapButton(firstDelimiterString, secondDelimiterString);
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new ConfigureServiceConnectionDetailsCommon(tool, test, user);
    }

    public void clickSwapButton(String firstDelimiterString, String secondDelimiterString) throws Exception {
        String tempString[];
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        String pageSource = tool.driver.getPageSource();

        tempString = pageSource.split(firstDelimiterString);
        tempString = tempString[1].split(secondDelimiterString);
        tempString = tempString[1].split("\"");

        tool.driver.findElement(By.name(secondDelimiterString + tempString[0])).click();
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
    }

}
