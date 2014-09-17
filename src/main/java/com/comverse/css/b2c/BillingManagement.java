package com.comverse.css.b2c;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class BillingManagement extends B2CMenu {

    public BillingManagement(AutomationTool tool, Test test, User user) throws Exception {

        super(tool, test, user);
        String currentScreen = tool.getTitle();
        String expectedScreen = "Billing Management";

        if (!expectedScreen.equals(tool.getTitle())) {
            test.writeInLogFile("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }
        test.writeInLogFile(" >>> Page Now loaded: " + expectedScreen + " <<<");
    }

    public CheckoutReview clickContinue() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.clickUsingXPath("//input[@value='Continue >']");
        return new CheckoutReview(tool, test, user);
    }

    public CheckOutBillingAccountInformation clickIWantASeparateBillForFirstSubscriber() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.clickUsingID("change_billing_contract_0");
        return new CheckOutBillingAccountInformation(tool, test, user);
    }

    public CheckOutBillingAccountInformation clickIWantASeparateBillForSecondSubscriber() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.clickUsingID("change_billing_contract_1");
        return new CheckOutBillingAccountInformation(tool, test, user);
    }
}
