/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class AddDepositCommon extends CommonMenu {

    static String expectedScreen = "Add deposit";

    public AddDepositCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

        String currentScreen = tool.getTitle();

        // Check that we're on the right page.
        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }
    }

    public void setDepositType(String depositType) throws Exception {  test.writeInLog(Common.getMethodName());

        tool.enterStringNotTextFieldUsingId("depositType", depositType);
    }

    public void setBalance(String balanceName) throws Exception {  test.writeInLog(Common.getMethodName());

        tool.selectVisibleTextByID("balance", balanceName);

    }

    public void setDepositAmount(String depositAmount) throws Exception {  test.writeInLog(Common.getMethodName());

        tool.enterStringUsingId("amount", depositAmount);
    }

    public void selectPaymentMethod() throws Exception {  test.writeInLog(Common.getMethodName());

        // tool.clickUsingID(paymentMethod);
        tool.clickUsingXPath("(//input[@name='paymentMethod'])[1]");

    }

    public AddDepositReviewAndConfirmCommon clickContinue() throws Exception {  test.writeInLog(Common.getMethodName());

        tool.clickUsingXPath("//input[@value='Continue']");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new AddDepositReviewAndConfirmCommon(tool, test, user);
    }
}
