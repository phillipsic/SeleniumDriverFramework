/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.b2c;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class SearchCustomer extends B2CMenu {

    public SearchCustomer(AutomationTool tool, Test test, User user) throws Exception {

        super(tool, test, user);
        String currentScreen = tool.getTitle(tool);
        String expectedScreen = "Search Customer";

        if (!expectedScreen.equals(tool.getTitle(tool))) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
        System.out.println(">>" + currentScreen);
    }

    public void enterLastName(String lastName) throws Exception {

        tool.enterStringUsingId(tool, "p-L1:3-L3:1470", lastName);
    }

    public RequestSubmission clickSearch() throws Exception {

        tool.clickUsingXPath(tool, "(//input[@value='Search'])[2]");
        return new RequestSubmission(tool, test, user);
    }

    public SearchMember clickSearchMemberLink() throws Exception {

        tool.clickUsingID(tool, "smnu_SEARCH_BY_MEMBER");
        return new SearchMember(tool, test, user);
    }

    public ContactInformation clickOnCustomerNameLink(String lastname) throws Exception {

        tool.clickUsingPartialLinkText(tool, lastname);
        return new ContactInformation(tool, test, user);
    }

    public void clickSearchLastFirstName() throws Exception {
        tool.clickUsingXPath(tool, "(//input[@value='Search'])[2]");
    }
}
