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

public class RechargeWithVoucherCommon extends CommonMenu {

    public RechargeWithVoucherCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "Recharge with voucher";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public void enterVoucherNumber(String voucherNumber) throws Exception {
        tool.driver.findElement(By.id("pkgnumber")).clear();
        tool.driver.findElement(By.id("pkgnumber")).sendKeys(voucherNumber);
    }

    public RechargeSubscriberCommon clickContinue() throws Exception {
        tool.driver.findElement(By.xpath("//input[@value='Continue']")).click();
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new RechargeSubscriberCommon(tool, test, user);
    }

}
