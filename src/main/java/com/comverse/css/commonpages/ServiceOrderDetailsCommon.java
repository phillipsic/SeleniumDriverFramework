/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Account;
import com.comverse.css.common.Common;

public class ServiceOrderDetailsCommon extends CommonMenu {

    public ServiceOrderDetailsCommon(AutomationTool tool, Test test, User user) throws Exception {

        super(tool, test, user);
        String currentScreen = tool.getTitle();
        String expectedScreen = "Service Order Details";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }
    }

    public void getAccountID(Account account) throws Exception {  test.writeInLog(Common.getMethodName());
        String accountID = tool.getTextUsingXPath("//td[2]/a");
        System.out.println("AccountID = " + accountID);
        account.setBillingAccountIDProperty(accountID);
    }

    public SearchOrdersCommon clickBack() throws Exception {  test.writeInLog(Common.getMethodName());
        tool.clickUsingCssSelector("input[type='submit'][value='Back']");
        return new SearchOrdersCommon(tool, test, user);
    }
}
