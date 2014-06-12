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

public class AccountDepositsCommon extends CommonMenu {

    static String expectedScreen = "Account deposits";

    public AccountDepositsCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

        String currentScreen = tool.driver.getTitle();

        // Check that we're on the right page.
        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public AddDepositCommon clickAdd() throws Exception {

        tool.driver.findElement(By.linkText("Add")).click();
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new AddDepositCommon(tool, test, user);
    }

    public AccountDetailsCommon clickBack() throws Exception {

        tool.driver.findElement(By.xpath("//input[@value='Back']")).click();
        return new AccountDetailsCommon(tool, test, user);
    }
}
