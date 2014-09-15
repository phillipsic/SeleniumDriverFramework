/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class ContactInformationCommon extends CommonMenu {

    public ContactInformationCommon(AutomationTool tool, Test test, User user) throws Exception {

        super(tool, test, user);
        String currentScreen = tool.getTitle();
        String expectedScreen = "Contact Information";

        if (!expectedScreen.equals(tool.getTitle())) {

            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }
    }

    public String getFirstName() throws Exception {
        test.writeInLog(Common.getMethodName());

        return tool.getTextUsingXPath("//div[@id='mainContents']/div/div/fieldset/p[2]");

    }

    public String getLastName() throws Exception {
        test.writeInLog(Common.getMethodName());

        return tool.getTextUsingXPath("//div[@id='mainContents']/div/div/fieldset/p[3]");
    }

    public LoginInformationCommon clickViewLoginInformationLink() throws Exception {
        test.writeInLog(Common.getMethodName());

        tool.clickUsingLinkText("View Login Information");
        return new LoginInformationCommon(tool, test, user);
    }

    public MoveMemberCommon clickMoveMember() throws Exception {
        test.writeInLog(Common.getMethodName());

        tool.clickUsingID("youcan_MOVE_MEMBER");
        return new MoveMemberCommon(tool, test, user);
    }

    public ViewHierarchyCommon clickBack() throws Exception {
        test.writeInLog(Common.getMethodName());

        tool.clickUsingID("youcan_ON_BACK");
        return new ViewHierarchyCommon(tool, test, user);
    }

    public ModifyContactInformationCommon clickModifyContactInformation() throws Exception {
        test.writeInLog(Common.getMethodName());
        tool.clickUsingID("youcan_MODIFY_CONTACT");
        return new ModifyContactInformationCommon(tool, test, user);
    }

    public ModifyEmployeeContactCommon clickModifyContact() throws Exception {
        test.writeInLog(Common.getMethodName());

        tool.clickUsingID("youcan_MODIFY_CONTACT");
        return new ModifyEmployeeContactCommon(tool, test, user);
    }

}
