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

public class AddDepositReviewAndConfirmCommon extends CommonMenu {

    static String expectedScreen = "Add deposit - Review and Confirm";

    public AddDepositReviewAndConfirmCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

        String currentScreen = tool.driver.getTitle();

        // Check that we're on the right page.
        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public AddDepositReviewAndConfirmCommon clickConfirm() throws Exception {

        tool.driver.findElement(By.xpath("//input[@value='Confirm']")).click();
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new AddDepositReviewAndConfirmCommon(tool, test, user);
    }

    public AccountDetailsCommon clickOk() throws Exception {

        tool.driver.findElement(By.xpath("//input[@value='OK']")).click();
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new AccountDetailsCommon(tool, test, user);
    }

    public AccountDepositsCommon clickOkToViewDeposits() throws Exception {

        tool.driver.findElement(By.xpath("//input[@value='OK']")).click();
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new AccountDepositsCommon(tool, test, user);
    }
}
