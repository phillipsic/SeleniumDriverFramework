package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class RegisterPrepaymentConfirmCommon extends CommonMenu {

    public RegisterPrepaymentConfirmCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle();
        String expectedScreen = "Register PrePayment";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }
    }

    public AccountDetailsCommon clickBackToAccount() throws Exception {  test.writeInLog(Common.getMethodName());

        tool.clickUsingXPath("//input[@name='confirm']");
        return new AccountDetailsCommon(tool, test, user);
    }
}
