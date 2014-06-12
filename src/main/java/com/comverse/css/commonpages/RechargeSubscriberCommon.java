/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import org.openqa.selenium.By;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class RechargeSubscriberCommon extends CommonMenu {

    public RechargeSubscriberCommon(AutomationTool tool, Test test, User user) throws Exception {

        super(tool, test, user);
        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "Recharge Subscriber";

        // Check that we're on the right page.
        if (!expectedScreen.equals(tool.driver.getTitle())) {
            // Alternatively, we could navigate to the login page, perhaps
            // logging out first
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public String getRechargeClass() throws Exception {

        String rechargeClass = tool.driver.findElement(By.xpath("//tr[4]/td[2]/span/strong")).getText();

        return rechargeClass;
    }

    public ViewBalanceCommon clickViewBalances() throws Exception {

        tool.driver.findElement(By.id("youcan_BACK_TO_BALANCE_VIEW")).click();

        return new ViewBalanceCommon(tool, test, user);
    }
}
