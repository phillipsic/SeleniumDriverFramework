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

public class AddDepositCommon extends CommonMenu {

    static String expectedScreen = "Add deposit";

    public AddDepositCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

        String currentScreen = tool.driver.getTitle();

        // Check that we're on the right page.
        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public void setDepositType(String depositType) throws Exception {

        tool.driver.findElement(By.id("depositType")).sendKeys(depositType);
    }

    public void setBalance(String balanceName) throws Exception {

        new Select(tool.driver.findElement(By.id("balance"))).selectByVisibleText(balanceName);

    }

    public void setDepositAmount(String depositAmount) throws Exception {

        tool.driver.findElement(By.id("amount")).clear();
        tool.driver.findElement(By.id("amount")).sendKeys(depositAmount);
    }

    public void selectPaymentMethod() throws Exception {

        // tool.driver.findElement(By.id(paymentMethod)).click();
        tool.driver.findElement(By.xpath("(//input[@name='paymentMethod'])[1]")).click();

    }

    public AddDepositReviewAndConfirmCommon clickContinue() throws Exception {

        tool.driver.findElement(By.xpath("//input[@value='Continue']")).click();
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new AddDepositReviewAndConfirmCommon(tool, test, user);
    }
}
