package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class ClearTheCurrentBasketCommon extends CommonMenu {

    public ClearTheCurrentBasketCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle();
        String expectedScreen = "Clear the current basket";

        // Check that we're on the right page.
        if (!expectedScreen.equals(tool.getTitle())) {
            // Alternatively, we could navigate to the login page, perhaps
            // logging out first
            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }
    }

    public AccountDetailsCommon clickOK() throws Exception {  test.writeInLog(Common.getMethodName());
        tool.clickUsingXPath("//input[@value='OK']");
        return new AccountDetailsCommon(tool, test, user);
    }

}
