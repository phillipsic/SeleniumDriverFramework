/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.b2b;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;
import com.comverse.css.commonpages.IdentifyCustomerCommon;

public class ManageAccount extends IdentifyCustomerCommon {

    public ManageAccount(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

        String currentScreen = tool.getTitle();
        String expectedScreen = "Identify Customer";

        // Check that we're on the right page.
        if (!expectedScreen.equals(tool.getTitle())) {
            // Alternatively, we could navigate to the login page, perhaps
            // logging out first
            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }
    }

    @Override
    public AccountDetails searchByAccountID(String accountID) throws Exception {  test.writeInLogFile(Common.getMethodName());

        tool.enterStringUsingId("p-L2:40-L3:2150", accountID);
        tool.clickUsingCssSelector("input.submit");

        return new AccountDetails(tool, test, user);
    }

    public AccountDetails searchByLastName(String lastName) throws Exception {  test.writeInLogFile(Common.getMethodName());

        tool.enterStringUsingId("p-L2:40-L2:520", lastName);
        tool.clickUsingCssSelector("input.submit");

        return new AccountDetails(tool, test, user);
    }

    public SearchResults searchAccountIDWithWildCard() throws Exception {  test.writeInLogFile(Common.getMethodName());

        tool.enterStringUsingId("accountId", "*");
        tool.clickUsingName("accountButton");

        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new SearchResults(tool, test, user);

    }
}
