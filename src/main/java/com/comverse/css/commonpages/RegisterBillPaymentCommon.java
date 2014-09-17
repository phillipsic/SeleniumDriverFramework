package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class RegisterBillPaymentCommon extends CommonMenu {

    public RegisterBillPaymentCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle();
        String expectedScreen = "Register Bill Payment";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }
    }

    public void enterAmount(String amount) throws Exception {
        test.writeInLogFile(Common.getMethodName());

        tool.enterStringUsingId("amount", amount);
    }

    public void selectPaymentMethod(String paymentmethod) throws Exception {
        test.writeInLogFile(Common.getMethodName());

        tool.clickUsingID(paymentmethod);
    }

    public RegisterBillPaymentCommon clickContinue() throws Exception {
        test.writeInLogFile(Common.getMethodName());

        tool.clickUsingXPath("//input[@value='Continue']");
        return new RegisterBillPaymentCommon(tool, test, user);
    }

    public RegisterBillPaymentCommon clickConfirm() throws Exception {
        test.writeInLogFile(Common.getMethodName());

        tool.clickUsingXPath("//input[@value='Confirm']");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new RegisterBillPaymentCommon(tool, test, user);
    }

    public ViewInvoicesCommon clickBackToInvoices() throws Exception {
        test.writeInLogFile(Common.getMethodName());

        tool.clickUsingXPath("//input[@name='confirm']");
        return new ViewInvoicesCommon(tool, test, user);
    }
}
