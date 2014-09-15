/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.b2c;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class SearchCustomer extends B2CMenu {

    public SearchCustomer(AutomationTool tool, Test test, User user) throws Exception {

        super(tool, test, user);
        String currentScreen = tool.getTitle();
        String expectedScreen = "Search Customer";

        if (!expectedScreen.equals(tool.getTitle())) {
            test.writeInLog("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }
        test.writeInLog(" >>> Page Now loaded: " + expectedScreen + " <<<");
    }

    public void enterLastName(String lastName) throws Exception {
        test.writeInLog(Common.getMethodName() + " using data (" + lastName + ")");
        tool.enterStringUsingId("p-L1:3-L3:1470", lastName);
    }

    public RequestSubmission clickSearch() throws Exception {
        test.writeInLog(Common.getMethodName());
        tool.clickUsingXPath("(//input[@value='Search'])[2]");
        return new RequestSubmission(tool, test, user);
    }

    public SearchMember clickSearchMemberLink() throws Exception {
        test.writeInLog(Common.getMethodName());
        tool.clickUsingID("smnu_SEARCH_BY_MEMBER");
        return new SearchMember(tool, test, user);
    }

    public ContactInformation clickOnCustomerNameLink(String lastname) throws Exception {
        test.writeInLog(Common.getMethodName() + " using data (" + lastname + ")");
        tool.clickUsingPartialLinkText(lastname);
        return new ContactInformation(tool, test, user);
    }

    public void clickSearchLastFirstName() throws Exception {
        test.writeInLog(Common.getMethodName());
        tool.clickUsingXPath("(//input[@value='Search'])[2]");
    }
}
