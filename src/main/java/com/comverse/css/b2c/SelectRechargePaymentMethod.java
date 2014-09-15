package com.comverse.css.b2c;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class SelectRechargePaymentMethod extends B2CMenu {

    public SelectRechargePaymentMethod(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle();
        String expectedScreen = "Select recharge payment method";

        if (!expectedScreen.equals(tool.getTitle())) {
            test.writeInLog("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }
        test.writeInLog(" >>> Page Now loaded: " + expectedScreen + " <<<");
    }

    public void enterCardNumber(String cardNumber) throws Exception {
        test.writeInLog(Common.getMethodName() + " using data (" + cardNumber + ")");
        tool.enterStringUsingId("cardNumber", cardNumber);
    }

    public void enterCardExpDate(String expirationDate) throws Exception {
        test.writeInLog(Common.getMethodName() + " using data (" + expirationDate + ")");
        tool.enterStringUsingId("cardExpirationDate", expirationDate);
    }

    public void enterCardHolderLastName(String lastName) throws Exception {
        test.writeInLog(Common.getMethodName() + " using data (" + lastName + ")");
        tool.enterStringUsingId("cardHolderName", lastName);
    }

    public void enterCardHolderFirstName(String firstName) throws Exception {
        test.writeInLog(Common.getMethodName() + " using data (" + firstName + ")");
        tool.enterStringUsingId("cardHolderFName", firstName);
    }

    public void enterCardSecretCode(String secretCode) throws Exception {
        test.writeInLog(Common.getMethodName() + " using data (" + secretCode + ")");
        tool.enterStringUsingId("cardSecretCode", secretCode);
    }

    public RechargeDone clickSelect() throws Exception {
        test.writeInLog(Common.getMethodName());
        tool.clickUsingXPath("//input[@name='select']");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new RechargeDone(tool, test, user);
    }
}
