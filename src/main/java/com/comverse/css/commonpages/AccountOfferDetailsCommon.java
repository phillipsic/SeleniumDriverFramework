/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class AccountOfferDetailsCommon extends CommonMenu {
    static String expectedScreen = "Account Offer Detail";

    public AccountOfferDetailsCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle();

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }
    }

    public SelectOffersForYourAccountCommon clickReturnToList() throws Exception {  test.writeInLog(Common.getMethodName());
        tool.clickUsingName("select");
        return new SelectOffersForYourAccountCommon(tool, test, user);
    }

}
