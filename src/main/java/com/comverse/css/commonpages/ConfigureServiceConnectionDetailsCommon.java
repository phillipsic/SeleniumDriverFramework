/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class ConfigureServiceConnectionDetailsCommon extends CommonMenu {
    static String expectedScreen = "Configure Service Connection Details";

    public ConfigureServiceConnectionDetailsCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.driver.getTitle();

        if (!expectedScreen.equals(currentScreen)) {
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public MyBasketCommon clickContinue() throws Exception {
        tool.driver.findElement(By.xpath("//input[@value='Continue >']")).click();
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new MyBasketCommon(tool, test, user);
    }

    public SwapSubscriberExternalIdConfirmationCommon clickContinueExpectingSwapSubscriberExternalIdConfirmation() throws Exception {
        tool.driver.findElement(By.xpath("//input[@value='Continue >']")).click();
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new SwapSubscriberExternalIdConfirmationCommon(tool, test, user);
    }

    public void selectTopLevelContainerType(String containerType) throws Exception {
        new Select(tool.searchUsingID(tool, "p-advInvSearch-L4:17000")).selectByVisibleText(containerType);
    }

    public ServiceConnectionDetailsCommon clickOK() throws Exception {
        tool.driver.findElement(By.xpath("//input[@value='OK']")).click();
        return new ServiceConnectionDetailsCommon(tool, test, user);
    }

    public void setServiceConnectionEmail(String Email) throws Exception {
        
        tool.enterStringUsingId(tool, "inputFields1178", Email);

    }

}
