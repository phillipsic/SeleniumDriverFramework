/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.b2c;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class SearchMember extends B2CMenu {

    public SearchMember(AutomationTool tool, Test test, User user) throws Exception {

        super(tool, test, user);
        String currentScreen = tool.getTitle();
        String expectedScreen = "Search Member";

        if (!expectedScreen.equals(tool.getTitle())) {
            test.writeInLog("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }
        test.writeInLog(" >>> Page Now loaded: " + expectedScreen + " <<<");
    }

    public RegisterNewResidentialMember clickRegisterNewMember() throws Exception {

        tool.clickUsingID("smnu_REGISTER_MEMBER");
        return new RegisterNewResidentialMember(tool, test, user);
    }

    public void enterLastName(String lastName) throws Exception {

        tool.enterStringUsingId("p-L1:8-L3:1470", lastName);
    }

    public void clickSearchFirstLastNameButton() throws Exception {

        tool.clickUsingXPath("//input[@value='Search']");

    }

    public void clickFirstFoundMember() throws Exception {

        tool.clickUsingID("lnk_MEMBER_0");

    }

    public void clickOnCustomerNameLink(String lastname) throws Exception {

        tool.clickUsingPartialLinkText(lastname);

    }

    public LoginInformation clickManageLogin() throws Exception {

        tool.clickUsingLinkText("Manage Login");
        return new LoginInformation(tool, test, user);
    }

    public CustomerProfile clickChangeProfile() throws Exception {

        tool.clickUsingLinkText("Change Profile");
        return new CustomerProfile(tool, test, user);
    }

}
