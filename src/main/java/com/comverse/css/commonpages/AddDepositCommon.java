/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

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

        tool.enterStringUsingId(tool, "depositType", depositType);
    }

    public void setBalance(String balanceName) throws Exception {

        new Select(tool.searchUsingID(tool, "balance")).selectByVisibleText(balanceName);

    }

    public void setDepositAmount(String depositAmount) throws Exception {

        
        tool.enterStringUsingId(tool, "amount", depositAmount);
    }

    public void selectPaymentMethod() throws Exception {

        // tool.driver.findElement(By.id(paymentMethod)).click();
        tool.clickUsingXPath(tool, "(//input[@name='paymentMethod'])[1]");

    }

    public AddDepositReviewAndConfirmCommon clickContinue() throws Exception {

        tool.clickUsingXPath(tool, "//input[@value='Continue']");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new AddDepositReviewAndConfirmCommon(tool, test, user);
    }
}
