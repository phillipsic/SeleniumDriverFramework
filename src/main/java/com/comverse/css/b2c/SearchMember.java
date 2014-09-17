/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.b2c;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class SearchMember extends B2CMenu {

    public SearchMember(AutomationTool tool, Test test, User user) throws Exception {

        super(tool, test, user);
        String currentScreen = tool.getTitle();
        String expectedScreen = "Search Member";

        if (!expectedScreen.equals(tool.getTitle())) {
            test.writeInLogFile("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }
        test.writeInLogFile(" >>> Page Now loaded: " + expectedScreen + " <<<");
    }

    public RegisterNewResidentialMember clickRegisterNewMember() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.clickUsingID("smnu_REGISTER_MEMBER");
        return new RegisterNewResidentialMember(tool, test, user);
    }

    public void enterLastName(String lastName) throws Exception {
        test.writeInLogFile(Common.getMethodName() + " using data (" + lastName + ")");
        tool.enterStringUsingId("p-L1:8-L3:1470", lastName);
    }

    public void clickSearchFirstLastNameButton() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.clickUsingXPath("//input[@value='Search']");

    }

    public void clickFirstFoundMember() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.clickUsingID("lnk_MEMBER_0");

    }

    public void clickOnCustomerNameLink(String lastname) throws Exception {
        test.writeInLogFile(Common.getMethodName() + " using data (" + lastname + ")");
        tool.clickUsingPartialLinkText(lastname);

    }

    public LoginInformation clickManageLogin() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.clickUsingLinkText("Manage Login");
        return new LoginInformation(tool, test, user);
    }

    public CustomerProfile clickChangeProfile() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.clickUsingLinkText("Change Profile");
        return new CustomerProfile(tool, test, user);
    }

}
